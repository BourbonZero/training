<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/16
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有订单</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>订单编号</th>
        <th>用户编号</th>
        <th>课程编号</th>
        <th>课程名</th>
        <th>班级类型</th>
        <th>订单状态</th>
        <th>价格</th>
        <th>折扣</th>
        <th>应付款</th>
        <th>实付款</th>
        <th>获得收入</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="item">
        <tr>
            <td>${item.orderid}</td>
            <td>${item.userid}</td>
            <td>${item.courseid}</td>
            <td>${item.courseName}</td>
            <td>${item.classType}</td>
            <td>${item.state}</td>
            <td>${item.price}</td>
            <td>${item.discount}</td>
            <td>${item.consumption}</td>
            <td>${item.actualConsumption}</td>
            <td>${item.institutionIncome}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
