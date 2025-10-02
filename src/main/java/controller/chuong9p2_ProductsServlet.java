// package controller;

// import model.chuong9p2_Product;
// import dao.chuong9p2_ProductIO;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;
// import java.io.IOException;
// import java.util.ArrayList;

// // Chỉ map vào /products để tránh vòng lặp forward khi forward tới index.jsp
// @WebServlet(name = "ProductsServletCh9Ex2", urlPatterns = {"/chuong9p2/products"})
// public class chuong9p2_ProductsServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//         HttpSession session = request.getSession();
//         @SuppressWarnings("unchecked")
//         ArrayList<chuong9p2_Product> products = (ArrayList<chuong9p2_Product>) session.getAttribute("products");
//         if (products == null || products.isEmpty()) {
//             String path = getServletContext().getRealPath("/baitap_jsp/products.txt");
//             products = chuong9p2_ProductIO.getProducts(path);
//             session.setAttribute("products", products);
//         }

//         // Forward tới trang index trong thư mục chương 9_ex2
//     String url = "/baitap_jsp/chuong9p2_index.jsp";
//         getServletContext()
//                 .getRequestDispatcher(url)
//                 .forward(request, response);
//     }
// }
