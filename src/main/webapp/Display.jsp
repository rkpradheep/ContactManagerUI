<%@ page import="com.example.contactmanagerui.Model.Contact" %>
<%@ page import="com.example.contactmanagerui.Model.Address" %>
<%@ page import="com.example.contactmanagerui.Model.ContactPerson" %><%--
  Created by IntelliJ IDEA.
  User: pradheep-pt5419
  Date: 09/05/22
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%Contact contact=(Contact) request.getAttribute("contact");%>
<%="Contact Name : "+contact.getName()%><br/><br/>
<%="Contact Type : "+contact.getType()%><br/><br/>
<%="Website :  "+contact.getWebsite()%><br/><br/>
<%="Credit Limit : "+contact.getCreditLimit()%><br/><br/><br/>
<%Address address=contact.getBilling_address();%>
<b>Billing Address : </b><br/><br/>
<%="Attention :  "+address.getAttention()%><br/><br/>
<%="Address :  "+address.getAddress()%><br/><br/>
<%="Country :  "+address.getCountry()%><br/><br/>
<%="Phone :  "+address.getPhone()%><br/><br/><br/>
<%ContactPerson contactPerson=contact.getContact_persons();%>
<b>Contact Person : </b><br/><br/><br/>
<%="Name :  "+contactPerson.getName()%><br/><br/>
<%="Email :  "+contactPerson.getEmail()%><br/><br/>
<%="Phone :  "+contactPerson.getPhone()%><br/><br/>
<%="Primary :  "+contactPerson.isPrimary()%><br/><br/><br/>
</body>
</html>
