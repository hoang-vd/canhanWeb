package controller;

import javax.servlet.annotation.WebServlet;

import model.chuong13ex2_User;
import dao.chuong13ex2_UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "chuong13ex2UsersServlet", urlPatterns = {"/chuong13ex2/users", "/chuong13ex2/userAdmin"})
public class chuong13ex2_UsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

    String url = "/baitap_jsp/chuong13ex2_index.jsp"; // default list page
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "display_users";  // default action
        }
        // accept legacy alias list_users
        if ("list_users".equals(action)) {
            action = "display_users";
        }
        
        // perform action and set URL to appropriate page
        if (action.equals("display_users")) {
            List<chuong13ex2_User> users = chuong13ex2_UserDB.selectUsers();
            request.setAttribute("users", users);
            url = "/baitap_jsp/chuong13ex2_index.jsp";
        }
        else if (action.equals("display_user")) {
            String email = request.getParameter("email");
            chuong13ex2_User user = chuong13ex2_UserDB.selectUser(email);
            if (user == null) {
                // If user not found, reload list
                List<chuong13ex2_User> users = chuong13ex2_UserDB.selectUsers();
                request.setAttribute("users", users);
                url = "/baitap_jsp/chuong13ex2_index.jsp";
            } else {
                session.setAttribute("user", user);
                url = "/baitap_jsp/chuong13ex2_user.jsp";
            }
        }
        else if (action.equals("update_user")) {
            chuong13ex2_User user = (chuong13ex2_User) session.getAttribute("user");
            if (user != null) {
                // email not editable
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                user.setFirstName(firstName);
                user.setLastName(lastName);
                chuong13ex2_UserDB.update(user);
            }
            // Clear session user to avoid stale data
            session.removeAttribute("user");
            List<chuong13ex2_User> users = chuong13ex2_UserDB.selectUsers();
            request.setAttribute("users", users);
            url = "/baitap_jsp/chuong13ex2_index.jsp";
        }
        else if (action.equals("delete_user")) {
            String email = request.getParameter("email");
            if (email != null && !email.isEmpty()) {
                chuong13ex2_User user = chuong13ex2_UserDB.selectUser(email);
                if (user != null) {
                    chuong13ex2_UserDB.delete(user);
                }
            }
            List<chuong13ex2_User> users = chuong13ex2_UserDB.selectUsers();
            request.setAttribute("users", users);
            url = "/baitap_jsp/chuong13ex2_index.jsp";
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