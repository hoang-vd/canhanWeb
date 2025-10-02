// package controller;

// import model.chuong9p1_User;
// import dao.chuong9p1_UserIO;
// import util.chuong9p1_CookieUtil;

// import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.*;
// import java.io.IOException;

// @WebServlet(name = "DownloadServletCh9Ex1", urlPatterns = {"/chuong9p1/download"})
// public class chuong9p1_DownloadServlet extends HttpServlet {

//     @Override
//     public void doGet(HttpServletRequest request,
//             HttpServletResponse response)
//             throws IOException, ServletException {

//         String action = request.getParameter("action");
//         if (action == null) action = "viewAlbums";  // default action guard

//     String url = "/baitap_jsp/chuong9p1_index.jsp";
//         switch (action) {
//             case "viewAlbums":
//                 url = "/baitap_jsp/chuong9p1_index.jsp";
//                 break;
//             case "checkUser":
//                 url = checkUser(request, response);
//                 break;
//             case "viewCookies":
//                 url = "/baitap_jsp/chuong9p1_view_cookies.jsp";
//                 break;
//             case "deleteCookies":
//                 url = deleteCookies(request, response);
//                 break;
//             default:
//                 url = "/baitap_jsp/chuong9p1_index.jsp";
//         }

//         getServletContext().getRequestDispatcher(url).forward(request, response);
//     }

//     @Override
//     public void doPost(HttpServletRequest request,
//             HttpServletResponse response)
//             throws IOException, ServletException {

//         String action = request.getParameter("action");
//         if (action == null) action = ""; // guard

//     String url = "/baitap_jsp/chuong9p1_index.jsp";
//         if ("registerUser".equals(action)) {
//             url = registerUser(request, response);
//         }

//         getServletContext().getRequestDispatcher(url).forward(request, response);
//     }

//     private String checkUser(HttpServletRequest request,
//             HttpServletResponse response) {

//         String productCode = request.getParameter("productCode");
//         if (productCode == null || productCode.isBlank()) {
//             return "/baitap_jsp/chuong9p1_index.jsp"; // fall back safely
//         }
//         HttpSession session = request.getSession();
//         session.setAttribute("productCode", productCode);
//         chuong9p1_User user = (chuong9p1_User) session.getAttribute("user");

//         String url;
//         if (user == null) {
//             Cookie[] cookies = request.getCookies();
//             String emailAddress = chuong9p1_CookieUtil.getCookieValue(cookies, "emailCookie");
//             if (emailAddress == null || emailAddress.isEmpty()) {
//                 url = "/baitap_jsp/chuong9p1_register.jsp";
//             } else {
//                 ServletContext sc = getServletContext();
//                 String path = sc.getRealPath("/baitap_jsp/chuong8_EmailList.txt");
//                 user = chuong9p1_UserIO.getUser(emailAddress, path);
//                 session.setAttribute("user", user);
//                 url = "/baitap_jsp/chuong9p1_" + productCode + "_download.jsp";
//             }
//         } else {
//             url = "/baitap_jsp/chuong9p1_" + productCode + "_download.jsp";
//         }
//         return url;
//     }

//     private String registerUser(HttpServletRequest request,
//             HttpServletResponse response) {

//         String email = request.getParameter("email");
//         String firstName = request.getParameter("firstName");
//         String lastName = request.getParameter("lastName");

//         chuong9p1_User user = new chuong9p1_User();
//         user.setEmail(email);
//         user.setFirstName(firstName);
//         user.setLastName(lastName);

//         ServletContext sc = getServletContext();
//     String path = sc.getRealPath("/baitap_jsp/chuong8_EmailList.txt");
//         chuong9p1_UserIO.add(user, path);

//         HttpSession session = request.getSession();
//         session.setAttribute("user", user);

//         Cookie c1 = new Cookie("emailCookie", email);
//         c1.setMaxAge(60 * 60 * 24 * 365 * 2);
//         c1.setPath("/");
//         response.addCookie(c1);

//         Cookie c2 = new Cookie("firstNameCookie", firstName);
//         c2.setMaxAge(60 * 60 * 24 * 365 * 2);
//         c2.setPath("/");
//         response.addCookie(c2);

//         String productCode = (String) session.getAttribute("productCode");
//         if (productCode == null || productCode.isBlank()) {
//             return "/baitap_jsp/chuong9p1_index.jsp";
//         }
//     return "/baitap_jsp/chuong9p1_" + productCode + "_download.jsp";
//     }

//     private String deleteCookies(HttpServletRequest request,
//             HttpServletResponse response) {

//         Cookie[] cookies = request.getCookies();
//         if (cookies != null) {
//             for (Cookie cookie : cookies) {
//                 cookie.setMaxAge(0);
//                 cookie.setPath("/");
//                 response.addCookie(cookie);
//             }
//         }
//     return "/baitap_jsp/chuong9p1_delete_cookies.jsp";
//     }
// }