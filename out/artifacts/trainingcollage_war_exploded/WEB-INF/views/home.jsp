<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/9
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form method="post" action="/login">
        userid: <input type="text" name = "userid">
        password:<input type="password" name = "password">
        role: <select name="role">
            <option value="user">用户</option>
            <option value = "institution">机构</option>
            <option value = "manager">管理员</option>
        </select>
        <input type="submit" value="登录">
    </form>

    <a href="userRegister">用户注册</a><br>
    <a href="institutionRegister">机构注册</a>
</body>
</html>
