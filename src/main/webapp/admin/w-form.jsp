<%--
  Created by IntelliJ IDEA.
  User: GeekLe
  Date: 2017/6/5
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增 & 编辑</title>
</head>
<body>
<br><br><br>
<fieldset style="width:300px;margin:0px auto">
    <legend align="center">新增 & 修改线路信息</legend><br>
    <form action="/admin/saveWiring" method="post">
        请输入始发站：<input type="text" name="wiring.start" value="${admin.start}">
        <br><br>
        请输入终点站：<input type="text" name="wiring.destination" value="${admin.destination}">
        <br><br>
        发车时间：<input type="datetime" name="wiring.time" value="${admin.time}">
        <br><br>
        所需时间：<input type="text" name="wiring.stime" value="${admin.stime}">
        <br><br>
        汽车类型：<input type="text" name="wiring.class" value="${admin.class}">
        <br><br>
        <div align="center"><input type="submit" value="Submit"></div>
    </form>
</fieldset>
</body>
</html>
