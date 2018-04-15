<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/15
  Time: 17:15
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
    机构ID：<c:out value="${institution.id}"></c:out><br>
    基本信息：<c:out value="${institution.info}"></c:out><br>
    <a href="/institution/changeInfo">修改信息</a><br>
    <a href="/institution/course">课程列表</a><br>
    <a href="/institution/publishCourse">发布课程</a><br>
    <form action="/institution/offline">
        用户ID：<input type="text" name="userid"><br>
        课程ID：<input type="text" name="courseid"><br>
        班级类型：<select name="classType">
            <option value="big">大班</option>
            <option value="small">小班</option></select>
        <input type="submit" value="线下缴费">
    </form>
    <a href="/institution/record">登记成绩</a><br>
    <a href="/institution/order">订单详情</a><br>
    <a href="/institution/logout">注销</a><br>

</body>
</html>
