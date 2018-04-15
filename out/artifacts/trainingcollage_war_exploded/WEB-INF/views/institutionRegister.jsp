<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/15
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>机构注册</title>
</head>
<body>
    <form method="post" action="institutionRegister">
        password:<input type="password" name="password"><br>
        repeat password:<input type="password" name="repeatpassword"><br>
        info:<input type="text" name="info"><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
