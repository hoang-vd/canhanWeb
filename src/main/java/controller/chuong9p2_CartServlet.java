// package controller;

// import model.chuong9p2_LineItem;
// import model.chuong9p2_Cart;
// import model.chuong9p2_Product;
// import dao.chuong9p2_ProductIO;

// import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;
// import java.io.IOException;

// @WebServlet(name = "CartServletCh9Ex2", urlPatterns = {"/chuong9p2/cart"})
// public class chuong9p2_CartServlet extends HttpServlet {

//     @Override
//     protected void doPost(HttpServletRequest request,
//             HttpServletResponse response)
//             throws ServletException, IOException {
        
//         ServletContext sc = getServletContext();
        
//         // get current action
//         String action = request.getParameter("action");
//         if (action == null) {
//             action = "cart";  // default action
//         }

//         // perform action and set URL to appropriate page
//     String url = "/baitap_jsp/chuong9p2_index.jsp";
//         if (action.equals("shop")) {            
//             url = "/baitap_jsp/chuong9p2_index.jsp";    // the "index" page
//         } 
//         else if (action.equals("cart")) {
//             String productCode = request.getParameter("productCode");
//             String quantityString = request.getParameter("quantity");

//             HttpSession session = request.getSession();
//             chuong9p2_Cart cart = (chuong9p2_Cart) session.getAttribute("cart");
//             if (cart == null) {
//                 cart = new chuong9p2_Cart();
//             }

//             // Determine whether this is an "Add To Cart" action (no quantity provided)
//             // or an update/remove action (quantity provided from cart.jsp).
//             boolean isAddToCart = (quantityString == null || quantityString.trim().isEmpty());

//             // if the user enters a negative or invalid quantity on update,
//             // the quantity is automatically reset to 1.
//             int quantity;
//             if (!isAddToCart) {
//                 try {
//                     quantity = Integer.parseInt(quantityString);
//                     if (quantity < 0) {
//                         quantity = 1;
//                     }
//                 } catch (NumberFormatException nfe) {
//                     quantity = 1;
//                 }
//             } else {
//                 // Add to cart from index.jsp: increment by 1 if item already exists
//                 quantity = 1; // default for new item
//                 for (chuong9p2_LineItem li : cart.getItems()) {
//                     if (li.getProduct().getCode().equals(productCode)) {
//                         quantity = li.getQuantity() + 1;
//                         break;
//                     }
//                 }
//             }

//             String path = sc.getRealPath("/baitap_jsp/products.txt");
//             chuong9p2_Product product = chuong9p2_ProductIO.getProduct(productCode, path);

//             chuong9p2_LineItem lineItem = new chuong9p2_LineItem();
//             lineItem.setProduct(product);
//             lineItem.setQuantity(quantity);
//             if (quantity > 0) {
//                 cart.addItem(lineItem);
//             } else if (quantity == 0) {
//                 cart.removeItem(lineItem);
//             }

//             session.setAttribute("cart", cart);
//             url = "/baitap_jsp/chuong9p2_cart.jsp";
//         }
//         else if (action.equals("checkout")) {
//             url = "/baitap_jsp/chuong9p2_checkout.jsp";
//         }

//         sc.getRequestDispatcher(url)
//                 .forward(request, response);
//     }
    
//     @Override
//     protected void doGet(HttpServletRequest request,
//             HttpServletResponse response)
//             throws ServletException, IOException {
//         doPost(request, response);
//     }
    
// }