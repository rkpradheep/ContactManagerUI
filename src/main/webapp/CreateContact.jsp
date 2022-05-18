<%--
  Created by IntelliJ IDEA.
  User: pradheep-pt5419
  Date: 09/05/22
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Contact</title>
</head>
<body>
<form method="post" action="CreateContact">
    Contact Name <input type="text" name="name"/><br/><br/>
    Contact Type <input type="text" name="type"/><br/><br/>
    Website <input type="text" name="website"/><br/><br/>
    Credit Limit <input type="text"  name="creditLimit"/><br/><br/><br/>
    <b>Billing Address : </b><br/><br/>
    Attention <input type="text" name="attention"/><br/><br/>
    Address <input type="text" name="address"/><br/><br/>
    State <input type="text" name="state"/><br/><br/>
    Country <input type="text" name="country"/><br/><br/>
    Phone <input type="text" name="phone"/><br/><br/><br/>
    <b>Contact Person : </b><br/><br/><br/>
    Name <input type="text" name="cpName"/><br/><br/>
    Email <input type="text" name="cpEmail"/><br/><br/>
    Phone <input type="text" name="cpPhone"/><br/><br/>
    Primary <input type="checkbox" name="primary"/><br/><br/><br/>
    <input type="submit" value="Create"/>

</form>
</body>
</html>
