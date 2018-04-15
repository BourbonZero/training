<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/15
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有课程</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>课程名</th>
                <th>机构ID</th>
                <th>基本信息</th>
                <th>周数</th>
                <th>课次/周</th>
                <th>大班人数</th>
                <th>大班价格</th>
                <th>小班人数</th>
                <th>小班价格</th>
                <th>开始时间</th>
                <th>预订</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses}" var="item">
            <tr>
                <td>${item.courseid}</td>
                <td>${item.coursename}</td>
                <td>${item.institutionid}</td>
                <td>${item.info}</td>
                <td>${item.weekNum}</td>
                <td>${item.classesPerWeek}</td>
                <td>${item.bigClassCurrentNum}/${item.bigClassNum}</td>
                <td>${item.bigClassPrice}</td>
                <td>${item.smallClassCurrentNum}/${item.smallClassNum}</td>
                <td>${item.smallClassPrice}</td>
                <td>${item.beginTime}</td>
                <td><form action="/user/submit/${item.courseid}">
                    <select name="classType">
                        <option value="big">大班</option>
                        <option value="small">小班</option></select>
                    <input type="submit" value="预订">
                </form> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
