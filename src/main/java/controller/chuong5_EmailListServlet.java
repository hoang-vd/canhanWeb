package controller;

import model.chuong5_User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "EmailListServletCh5", urlPatterns = {"/chuong5/emailList"})
public class chuong5_EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    String url = "/baitap_jsp/chuong5_index.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        if (action.equals("join")) {
            url = "/baitap_jsp/chuong5_index.html";    // the "join" page
        } else if (action.equals("add") || action.equals("")) {

            // Get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String heardFrom = request.getParameter("heardFrom");
            String contactVia = request.getParameter("contactVia");

            boolean wantsUpdates = request.getParameter("wantsUpdates") != null;
            boolean emailOK = request.getParameter("emailOK") != null;

            // Create User object
            chuong5_User user = new chuong5_User(firstName, lastName, email, dob, heardFrom, wantsUpdates, emailOK, contactVia);

            // Set User object in request
            request.setAttribute("user", user);

            url = "/baitap_jsp/chuong5_thanks.jsp";   // forward to thanks page
        }

        // forward request and response
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
