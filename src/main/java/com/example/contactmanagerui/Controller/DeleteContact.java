package com.example.contactmanagerui.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DeleteContact", value = "/DeleteContact")
public class DeleteContact extends HttpServlet {
    Connection con;
    PreparedStatement st;
    ResultSet rs;

    public void ConnectToMysqlDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContactManager?autoReconnect=true&useSSL=false", "root", "12345678");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id=Integer.parseInt(request.getParameter("id"));
            ConnectToMysqlDB();
            st = con.prepareStatement("Delete from  Contacts where id=?");
            st.setInt(1, id);

            if(st.executeUpdate()==1)
                request.setAttribute("status","contact deleted successfully");

            else
                request.setAttribute("status","contact doesn't exist");
        } catch (Exception e) {
            request.setAttribute("status",e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("Response.jsp");
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
