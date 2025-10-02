package controller;

import model.chuong6p1_User;
import dao.chuong6p1_UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "EmailListServletCh6p1", urlPatterns = {"/chuong6p1/emailList"})
public class chuong6p1_EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    String url = "/baitap_jsp/chuong6p1_index.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/baitap_jsp/chuong6p1_index.jsp";    // the "join" page
        } 
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // store data in User object
            chuong6p1_User user = new chuong6p1_User(firstName, lastName, email);

            // validate the parameters
            String message;
            if (firstName == null || lastName == null || email == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill out all three text boxes.";
                url = "/baitap_jsp/chuong6p1_index.jsp";
            } 
            else {
                message = null;
                url = "/baitap_jsp/chuong6p1_thanks.jsp";
                chuong6p1_UserDB.insert(user);

                // Lấy tháng và năm hiện tại
                java.time.LocalDate today = java.time.LocalDate.now();
                String monthName = today.getMonth().name(); // trả về dạng "SEPTEMBER"
                int currentYear = today.getYear();

                // Chuyển monthName thành chữ hoa đầu
                String formattedMonth = monthName.substring(0, 1) + monthName.substring(1).toLowerCase();

                // Set vào request
                request.setAttribute("currentYear", currentYear);
                request.setAttribute("monthName", formattedMonth);
            }
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }    
}