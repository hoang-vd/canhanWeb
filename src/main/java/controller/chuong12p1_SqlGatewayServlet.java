package controller;

import dao.chuong12p1_ConnectionPool;
import util.chuong12p1_SQLUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "SqlGatewayServletCh12Ex1", urlPatterns = {"/chuong12p1/sqlGateway"})
public class chuong12p1_SqlGatewayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Hiển thị trang index (nếu truy cập GET trực tiếp) giữ lại câu SQL trước đó nếu có
    String url = "/baitap_jsp/chuong12p1_index.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    // get a connection
        chuong12p1_ConnectionPool pool = chuong12p1_ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String sqlStatement = request.getParameter("sqlStatement");
        String sqlResult = "";
        try {
            // create a statement
            Statement statement = connection.createStatement();

            // parse the SQL string
            sqlStatement = sqlStatement.trim();
            if (sqlStatement.length() >= 6) {
                String sqlType = sqlStatement.substring(0, 6);
                if (sqlType.equalsIgnoreCase("select")) {
                    // create the HTML for the result set
                    ResultSet resultSet
                            = statement.executeQuery(sqlStatement);
                    sqlResult = chuong12p1_SQLUtil.getHtmlTable(resultSet);
                    resultSet.close();
                } else {
                    int i = statement.executeUpdate(sqlStatement);
                    if (i == 0) { // a DDL statement
                        sqlResult = 
                                "<p>The statement executed successfully.</p>";
                    } else { // an INSERT, UPDATE, or DELETE statement
                        sqlResult = 
                                "<p>The statement executed successfully.<br>"
                                + i + " row(s) affected.</p>";
                    }
                }
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            sqlResult = "<p>Error executing the SQL statement: <br>"
                    + e.getMessage() + "</p>";
        } finally {
            pool.freeConnection(connection);
        }

        HttpSession session = request.getSession();
        session.setAttribute("sqlResult", sqlResult);
        session.setAttribute("sqlStatement", sqlStatement);

    // Forward trở lại trang index trong thư mục chương 12
    String url = "/baitap_jsp/chuong12p1_index.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}