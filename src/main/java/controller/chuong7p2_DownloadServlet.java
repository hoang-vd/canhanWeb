package controller;

import model.chuong7p2_User;
import dao.chuong7p2_ProductIO;
import model.chuong7p2_Product;
import dao.chuong7p2_UserIO;
import util.chuong7p2_CookieUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DownloadServletCh7p2", urlPatterns = {"/chuong7p2/download"})
public class chuong7p2_DownloadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "viewAlbums";  // default action
        }

        // perform action and set URL to appropriate page
    String url = "/baitap_jsp/chuong7p2_index.jsp"; // adjusted base path
        if (action.equals("viewAlbums")) {
            url = "/baitap_jsp/chuong7p2_index.jsp";
        } else if (action.equals("checkUser")) {
            url = checkUser(request, response);
        } else if (action.equals("viewCookies")) {
            url = "/baitap_jsp/chuong7p2_view_cookies.jsp";
        } else if (action.equals("deleteCookies")) {
            url = deleteCookies(request, response);
        }

        // forward to the view
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        
        // perform action and set URL to appropriate page
    String url = "/baitap_jsp/chuong7p2_index.jsp"; // adjusted
        if (action.equals("registerUser")) {
            url = registerUser(request, response);
        }

        // forward to the view
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String checkUser(HttpServletRequest request,
            HttpServletResponse response) {

        String productCode = request.getParameter("productCode");
        // Lấy đường dẫn file products.txt
        ServletContext sc = this.getServletContext();
    String productPath = sc.getRealPath("/baitap_jsp/products.txt"); // adjusted path
        // Lấy Product object từ file
        chuong7p2_Product product = chuong7p2_ProductIO.getProduct(productCode, productPath);
        // Lưu Product object vào session
        HttpSession session = request.getSession();
        session.setAttribute("product", product);
        chuong7p2_User user = (chuong7p2_User) session.getAttribute("user");

        String url;
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String emailAddress =
                    chuong7p2_CookieUtil.getCookieValue(cookies, "emailCookie");

            if (emailAddress == null || emailAddress.equals("")) {
                url = "/baitap_jsp/chuong7p2_register.jsp";
            } else {
                ServletContext sc2 = getServletContext();
                String path = sc2.getRealPath("/baitap_jsp/chuong8_EmailList.txt");
                user = chuong7p2_UserIO.getUser(emailAddress, path);
                session.setAttribute("user", user);
                url = "/baitap_jsp/chuong7p2_" + productCode + "_download.jsp";
            }
        } else {
            url = "/baitap_jsp/chuong7p2_" + productCode + "_download.jsp";
        }
        return url;
    }

    private String registerUser(HttpServletRequest request,
            HttpServletResponse response) {

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        chuong7p2_User user = new chuong7p2_User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        ServletContext sc = getServletContext();
    String path = sc.getRealPath("/baitap_jsp/chuong8_EmailList.txt");
        chuong7p2_UserIO.add(user, path);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        Cookie c = new Cookie("emailCookie", email);
        c.setMaxAge(60 * 60 * 24 * 365 * 2);
        c.setPath("/");
        response.addCookie(c);

        chuong7p2_Product product = (chuong7p2_Product) session.getAttribute("product");
    String url = "/baitap_jsp/chuong7p2_" + product.getCode() + "_download.jsp";
        return url;
   }

    private String deleteCookies(HttpServletRequest request,
            HttpServletResponse response) {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    String url = "/baitap_jsp/chuong7p2_delete_cookies.jsp";
        return url;
    }
}