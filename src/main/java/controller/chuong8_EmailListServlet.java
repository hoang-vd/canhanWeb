package controller;

import model.chuong8_User;
import dao.chuong8_UserDB;
import dao.chuong8_UserIO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "EmailListServletCh8", urlPatterns = {"/chuong8/emailList"})
public class chuong8_EmailListServlet extends HttpServlet
{    
    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
    String url = "/baitap_jsp/chuong8_index.jsp";
        if (action.equals("join")) {
            url = "/baitap_jsp/chuong8_index.jsp";    // the "join" page
        }
        else if (action.equals("add")) {                
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // store data in User object and save User object in database
            chuong8_User user = new chuong8_User(firstName, lastName, email);
            chuong8_UserDB.insert(user);
            
            // set User object in request object and set URL
            session.setAttribute("user", user);
            @SuppressWarnings("unchecked")
            ArrayList<chuong8_User> users = (ArrayList<chuong8_User>) session.getAttribute("users");
            if (users == null) {
                users = new ArrayList<>();
            }
            users.add(user);
            session.setAttribute("users", users);
            url = "/baitap_jsp/chuong8_thanks.jsp";   // the "thanks" page
        }
        
        // create the Date object and store it in the request
        Date currentDate = new Date();
        request.setAttribute("currentDate", currentDate);

        // create users list and store it in the session
    String path = getServletContext().getRealPath("/baitap_jsp/chuong8_EmailList.txt");
        ArrayList<chuong8_User> users = chuong8_UserIO.getUsers(path);
        session.setAttribute("users", users);

        // forward request and response objects to specified URL
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