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
    <legend align="center">新增 & 修改汽车信息</legend><br>
    <form action="/admin/saveCar" method="post">
        请输入类型：<input type="text" name="car.class" value="${admin.class}">
        <br><br>
        请输入价格：<input type="text" name="car.price" value="${admin.price}">
        <br><br>
        最大载客量：<input type="text" name="car.max" value="${admin.max}">
        <br><br>
        <div align="center"><input type="submit" value="Submit"></div>
    </form>
</fieldset>
</body>
</html>
