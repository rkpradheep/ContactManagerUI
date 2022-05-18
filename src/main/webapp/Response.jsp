<%--
  Created by IntelliJ IDEA.
  User: pradheep-pt5419
  Date: 09/05/22
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status</title>
</head>
<body>
<%=request.getAttribute("status")%>
<script>
    setTimeout(()=>{location.href="index.jsp"},2000);
</script>
</body>
</html>
