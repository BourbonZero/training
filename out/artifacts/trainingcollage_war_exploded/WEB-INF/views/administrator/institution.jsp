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
    <title>机构信息</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>机构编号</th>
            <th>机构信息</th>
            <th>申请状态</th>
            <th>是否通过</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${institutions}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.info}</td>
                <td>
                    <c:choose>
                        <c:when test="${item.permission==true}">是</c:when>
                        <c:otherwise>否</c:otherwise>
                    </c:choose>
                </td>
                <td><c:if test="${item.permission==false}">
                    <a href="/administrator/check/${item.id}">确认通过</a>
                </c:if> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
