<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/11
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>user</title>
</head>
<body>
    <c:out value="${ user.userid }"></c:out>
    <c:out value="${ user.info }"></c:out>
</body>
</html>
