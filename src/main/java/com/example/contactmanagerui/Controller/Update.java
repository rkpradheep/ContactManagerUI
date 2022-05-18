package com.example.contactmanagerui.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Update", value = "/Update")
public class Update extends HttpServlet {

    Connection con;
    PreparedStatement st;
    ResultSet rs;

    public void ConnectToMysqlDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContactManager?autoReconnect=true&useSSL=false", "root", "12345678");

    }
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                ConnectToMysqlDB();
                int id= Integer.parseInt(request.getParameter("id"));
                st = con.prepareStatement("Update Contacts set name=?,type=?,website=?,creditLimit=? where id=?");
                st.setString(1,request.getParameter("name"));
                st.setString(2,request.getParameter("type"));
                st.setString(3,request.getParameter("website"));
                st.setInt(4,Integer.parseInt(request.getParameter("creditLimit")));
                st.setInt(5,id);
                st.executeUpdate();


                    st = con.prepareStatement("Update Addresses set attention=?,address=?,state=?,country=?,phone=? where contactId=? and addressType='BillingAddress'");
                    st.setString(1, request.getParameter("attention"));
                    st.setString(2, request.getParameter("address"));
                    st.setString(3, request.getParameter("state"));
                    st.setString(4, request.getParameter("country"));
                    st.setString(5,request.getParameter("phone"));
                    st.setInt(6,id);
                    st.executeUpdate();


                st = con.prepareStatement("Update ContactPersons set name=?,email=?,phone=?,isPrimary=? where contactId=?");
                st.setString(1, request.getParameter("cpName"));
                st.setString(2, request.getParameter("cpEmail"));
                st.setString(3, request.getParameter("cpPhone"));
                boolean isPrimary=request.getParameter("primary")==null?false:true;
                st.setBoolean(4, isPrimary);
                st.setInt(5, id);
                st.executeUpdate();

               request.setAttribute("status","contact has been updated successfully");

        }
        catch (Exception e){
                e.printStackTrace();
                request.setAttribute("status",e.getMessage());
    }
        finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            RequestDispatcher requestDispatcher=request.getRequestDispatcher("Response.jsp");
            requestDispatcher.forward(request,response);

    }
}
