<%@ page import="com.example.contactmanagerui.Model.Contact" %>
<%@ page import="com.example.contactmanagerui.Model.Address" %>
<%@ page import="com.example.contactmanagerui.Model.ContactPerson" %><%--
  Created by IntelliJ IDEA.
  User: pradheep-pt5419
  Date: 09/05/22
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Info</title>
</head>
<body>
<form action="/DisplayContact" method="get">
    Contact Id <input type="text" name="id"/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
