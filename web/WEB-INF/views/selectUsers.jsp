<%@ page import="com.mooc.Entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>管理员查询</title>
</head>

<body>
<center>
    <h1>管理员查询</h1>
    <hr>
    <div>

    </div>
    <table cellspacing="0px" cellpadding="0px" border="1px" width="600px">
        <thead>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>类型</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.role}
            </td>
            <td><a href="/DeleteUser?username=${user.username}">删除</a></td>
        </tr>
    </c:forEach>
        </tbody>
    </table>
</center>
</body>
</html>