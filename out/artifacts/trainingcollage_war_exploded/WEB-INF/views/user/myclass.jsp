<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/15
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的课程</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>课程ID</th>
                <th>课程名</th>
                <th>得分</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${myclasses}" var="item">
            <tr>
                <td>${item.courseid}</td>
                <td>${item.courseName}</td>
                <td>${item.score}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
