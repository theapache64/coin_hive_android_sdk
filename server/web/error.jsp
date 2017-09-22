<%--
  Created by IntelliJ IDEA.
  User: theapache64
  Date: 22/9/17
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Error</h1>
        <hr>
        <h4><%=request.getParameter("error")%>
        </h4>
    </div>
</div>
</body>
</html>
