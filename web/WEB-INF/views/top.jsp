
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<center>
    <h1>课程后台管理系统 <span style="font-size:14px;">你好,<%=username%></span></h1>
</center>
</body>
</html>
