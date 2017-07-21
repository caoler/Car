<%--
  Created by IntelliJ IDEA.
  User: GeekLe
  Date: 2017/6/1
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询修改汽车信息</title>
</head>
<body>
<div align="center"><h2>汽车信息如下</h2></div>
<br>
<div align="center"><a href="/admin/UpdateCar">新增汽车</a></div><br>
<table border="1" align="center">
    <thead>
    <th>类型</th><th>价格</th><th>最大乘客量</th><th>操作</th></tr>
    </thead>
    <c:forEach items="${car }" var="c">
        <tr>
            <th>${c.class}</th>
            <th>${c.price}</th>
            <th>${c.max}</th>
            <th>
                <a href="/admin/UpdateCar?class=${c.class}">编辑</a>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
