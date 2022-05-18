<%@ page import="com.example.contactmanagerui.Model.Contact" %>
<%@ page import="com.example.contactmanagerui.Model.Address" %>
<%@ page import="com.example.contactmanagerui.Model.ContactPerson" %><%--
  Created by IntelliJ IDEA.
  User: pradheep-pt5419
  Date: 09/05/22
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Contact</title>
</head>
<body>

<%Contact contact=(Contact) request.getAttribute("contact"); %>

<%Address address=contact.getBilling_address(); %>

<%ContactPerson contactPerson=contact.getContact_persons(); %>

<form method="post" action="/Update" >
     <input type="text" name="id" value=<%=contact.getId()%> style="display:none" /><br/><br/>
    Contact Name <input type="text" name="name" value=<%=contact.getName()%> /><br/><br/>
    Contact Type <input type="text" name="type"value=<%=contact.getType()%> /><br/><br/>
    Website <input type="text" name="website" value=<%=contact.getWebsite()%> /><br/><br/>
    Credit Limit <input type="text"  name="creditLimit" value=<%=contact.getCreditLimit()%> /><br/><br/><br/>
    <b>Billing Address : </b><br/><br/>
    Attention <input type="text" name="attention" value=<%=address.getAttention()%> /><br/><br/>
    Address <input type="text" name="address" value=<%=address.getAddress()%> /><br/><br/>
    State <input type="text" name="state" value=<%=address.getState()%> /><br/><br/>
    Country <input type="text" name="country" value=<%=address.getCountry()%> /><br/><br/>
    Phone <input type="text" name="phone" value=<%=address.getPhone()%> /><br/><br/><br/>
    <b>Contact Person : </b><br/><br/><br/>
    Name <input type="text" name="cpName" value=<%=contactPerson.getName()%> /><br/><br/>
    Email <input type="text" name="cpEmail" value=<%=contactPerson.getEmail()%> /><br/><br/>
    Phone <input type="text" name="cpPhone" value=<%=contactPerson.getPhone()%> /><br/><br/>
    Primary <input type="checkbox" name="primary" checked=<%=contactPerson.isPrimary()%> /><br/><br/><br/>
    <input type="submit" value="Update"/>

</form>
</body>
</html>
