<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/16
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"  %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>用户ID</th>
            <th>消费金额</th>
            <th>是否是会员</th>
            <th>会员等级</th>
            <th>基本信息</th>
            <th>卡号</th>
            <th>积分</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="item">
            <tr>
                <td>${item.userid}</td>
                <td>${item.totalConsumption}</td>
                <td><c:choose>
                    <c:when test="${item.VIP==true}">是</c:when>
                    <c:otherwise>否</c:otherwise>
                </c:choose></td>
                <td>${item.viplevel}</td>
                <td>${item.info}</td>
                <td>${item.accountid}</td>
                <td>${item.point}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
