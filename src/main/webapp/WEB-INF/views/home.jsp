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
    <title>my</title>
</head>
<body>
    <sf:form method="POST" modelAttribute="login">
        userid:<sf:input path="loginid"></sf:input>
        password:<sf:password path="password"></sf:password>
        role:<sf:select path="role" >
        <sf:option value = "user">用户</sf:option>
        <sf:option value = "insitution">机构</sf:option>
        <sf:option value = "manager">管理员</sf:option>
            </sf:select>
        <input type="submit" value="登录">
    </sf:form>

    <a href="register">注册</a>
</body>
</html>
