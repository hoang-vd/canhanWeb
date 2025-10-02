package controller;

import model.chuong7p1_Product;
import model.chuong7p1_LineItem;
import model.chuong7p1_Cart;
import dao.chuong7p1_ProductIO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import javax.servlet.annotation.WebServlet;

@WebServlet(name = "CartServletCh7p1", urlPatterns = {"/chuong7p1/cart"})
public class chuong7p1_CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
    String url = "/baitap_jsp/chuong7p1_index.jsp";
        ServletContext sc = getServletContext();
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("shop")) {
            url = "/baitap_jsp/chuong7p1_index.jsp";    // the "index" page
        }
        else if (action.equals("cart")) {
            String productCode = request.getParameter("productCode");
            String quantityString = request.getParameter("quantity");

            HttpSession session = request.getSession();
            chuong7p1_Cart cart = (chuong7p1_Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new chuong7p1_Cart();
            }

            // Xử lý số lượng
            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) {
                    quantity = 1;
                }
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }

            String path = sc.getRealPath("/baitap_jsp/products.txt");
            chuong7p1_Product product = chuong7p1_ProductIO.getProduct(productCode, path);

            // Lấy quantity cũ
            int oldQuantity = 0;
            for (chuong7p1_LineItem it : cart.getItems()) {
                if (it.getProduct().getCode().equals(productCode)) {
                    oldQuantity = it.getQuantity();
                    break;
                }
            }

            boolean isUpdate = request.getParameter("update") != null;

            // Kiểm tra Remove trước khi cộng dồn
            if (quantity == 0) {
                cart.removeItemByCode(productCode);
            } else {
                // Nếu không phải update (nghĩa là Add To Cart) → cộng dồn
                if (!isUpdate) {
                    quantity = oldQuantity + quantity;
                }

                chuong7p1_LineItem lineItem = new chuong7p1_LineItem();
                lineItem.setProduct(product);
                lineItem.setQuantity(quantity);

                cart.addItem(lineItem);
            }

            session.setAttribute("cart", cart);
            url = "/baitap_jsp/chuong7p1_cart.jsp";
        }
        else if (action.equals("checkout")) {
            url = "/baitap_jsp/chuong7p1_checkout.jsp";
        }

        sc.getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}