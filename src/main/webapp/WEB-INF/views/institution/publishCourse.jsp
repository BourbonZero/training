<%--
  Created by IntelliJ IDEA.
  User: Bourbon
  Date: 2018/4/15
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布课程</title>
</head>
<body>
    <form action="/institution/addCourse" method="post">
        课程名：<input type="text" name="courseName"><br>
        备注：<input type="text" name="info"><br>
        周数：<input type="number" name="weekNum"><br>
        课次/周：<input type="number" name="classesPerWeek"><br>
        大班总人数：<input type="number" name="bigClassNum"><br>
        大班价格：<input type="number" name="bigClassPrice"><br>
        小班总人数：<input type="number" name="smallClassNum"><br>
        小班价格：<input type="number" name="smallClassPrice"><br>
        开课时间：<input type="date" name="beginTime"><br>
        <input type="submit" value="发布课程">
    </form>
</body>
</html>
