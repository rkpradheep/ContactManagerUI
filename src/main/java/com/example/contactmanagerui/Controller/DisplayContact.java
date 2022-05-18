package com.example.contactmanagerui.Controller;

import com.example.contactmanagerui.Model.Address;
import com.example.contactmanagerui.Model.Contact;
import com.example.contactmanagerui.Model.ContactPerson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DisplayContact", value = "/DisplayContact")
public class DisplayContact extends HttpServlet {

    Connection con;
    PreparedStatement st;
    ResultSet rs;

    public void ConnectToMysqlDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContactManager?autoReconnect=true&useSSL=false", "root", "12345678");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id=Integer.parseInt(request.getParameter("id"));
        Contact contact=new Contact();
        try {
            ConnectToMysqlDB();
            st=con.prepareStatement("Select * from Contacts contacts where id=?");
            st.setInt(1,id);
            rs=st.executeQuery();
            if(rs.next()) {
                contact.setId(id);
                contact.setName(rs.getString("name"));
                contact.setCreditLimit(rs.getInt("creditLimit"));
                contact.setWebsite(rs.getString("website"));
                contact.setType(rs.getString("type"));
                st = con.prepareStatement("Select * from Addresses contacts where contactId=?");
                st.setInt(1, id);
                rs = st.executeQuery();
                if (rs.next()) {
                    Address address = new Address();
                    address.setId(rs.getInt("id"));
                    address.setAttention(rs.getString("attention"));
                    address.setCountry(rs.getString("country"));
                    address.setState(rs.getString("state"));
                    address.setAddress(rs.getString("address"));
                    address.setPhone(rs.getString("phone"));
                    if (rs.getString("addressType").equals("BillingAddress")) {
                        contact.setBilling_address(address);
                    }
                }
                st = con.prepareStatement("Select count(*) from ContactPersons where contactId=?");
                st.setInt(1, id);
                rs = st.executeQuery();
                if (rs.next()) {
                    int size = rs.getInt(1);
                    st = con.prepareStatement("Select * from ContactPersons where contactId=?");
                    st.setInt(1, id);
                    rs = st.executeQuery();
                    ContactPerson contactPerson = new ContactPerson();

                    if (rs.next()) {
                        contactPerson.setId(rs.getInt("id"));
                        contactPerson.setName(rs.getString("name"));
                        contactPerson.setEmail(rs.getString("email"));
                        contactPerson.setPhone(rs.getString("phone"));
                        contactPerson.setPrimary(rs.getBoolean("isPrimary"));
                        contact.setContact_persons(contactPerson);

                    }


                }
                request.setAttribute("contact",contact);
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("Display.jsp");
                requestDispatcher.forward(request,response);
            }
            else
            {
                request.setAttribute("status","requested contact doesn't exist");

            }
        }
        catch (Exception e){
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
