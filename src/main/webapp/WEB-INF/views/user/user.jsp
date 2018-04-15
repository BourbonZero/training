<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/11
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>用户</title>
</head>
<body>
    用户ID：<c:out value="${user.userid}"></c:out><br>
    VIP：<c:choose>
        <c:when test="${user.VIP==true}">是  <a href="/user/cancelVIP">取消会员</a></c:when>
        <c:otherwise>否</c:otherwise>
    </c:choose><br>
    VIP等级：<c:out value="${user.viplevel}"></c:out><br>
    基本信息：<c:out value="${user.info}"></c:out>  <a href="/user/changeInfo">修改基本信息</a> <br>
    卡号：<c:choose>
        <c:when test="${user.accountid == null}">暂无<a href="/user/setAccount">设置卡号</a><br></c:when>
        <c:otherwise><c:out value="${user.accountid}"></c:out><br></c:otherwise>
    </c:choose>
    消费金额：<c:out value="${user.totalConsumption}"></c:out><br>
    积分：<c:out value="${user.point}"></c:out>  <a href="/user/exchangePoint">积分兑换</a><br>

    <a href="/user/order">查看订单</a><br>
    <a href="/user/course">所有课程</a><br>
    <a href="/user/myclass">我的课程</a><br>
    <a href="/user/logout">注销</a>
</body>
</html>