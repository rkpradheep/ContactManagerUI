package com.example.contactmanagerui.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "CreateContact", value = "/CreateContact")
public class CreateContact extends HttpServlet {
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
            st=con.prepareStatement("insert into Contacts(name,type,website,creditLimit) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            st.setString(1,request.getParameter("name"));
            st.setString(2,request.getParameter("type"));
            st.setString(3,request.getParameter("website"));
            st.setInt(4,Integer.parseInt(request.getParameter("creditLimit")));
            st.executeUpdate();
            rs=st.getGeneratedKeys();
            int contactId=0;
            if(rs.next()) {
                contactId=rs.getInt(1);
                request.setAttribute("id",contactId);
            }

                st = con.prepareStatement("insert into Addresses(attention,address,state,country,phone,contactId,addressType) values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                st.setString(1, request.getParameter("attention"));
                st.setString(2, request.getParameter("address"));
                st.setString(3, request.getParameter("state"));
                st.setString(4, request.getParameter("country"));
                st.setString(5,request.getParameter("phone"));
                st.setInt(6,contactId );
                st.setString(7, "BillingAddress");
                st.executeUpdate();
                rs=st.getGeneratedKeys();



                st = con.prepareStatement("insert into ContactPersons(name,email,phone,isPrimary,contactId) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                st.setString(1, request.getParameter("cpName"));
                st.setString(2, request.getParameter("cpEmail"));
                st.setString(3, request.getParameter("cpPhone"));
                boolean isPrimary=request.getParameter("primary")==null?false:true;
                st.setBoolean(4, isPrimary);
                st.setInt(5, contactId);
                st.executeUpdate();
            request.setAttribute("status","Contact Created Successfully with id "+contactId);


        }
        catch (Exception e){
            e.printStackTrace();
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
}
