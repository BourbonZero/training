<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/15
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>绑定帐户</title>
</head>
<body>
    <form action="/user/account">
        卡号：<input type="text" name="accountid"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="确认绑定">
    </form>
</body>
</html>
