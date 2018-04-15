<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/15
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <form method="post" action="userRegister">
        userid: <input type="text" name = "userid"><br>
        password:<input type="password" name = "password"><br>
        repeat password:<input type="password" name = "repeatpassword"><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
