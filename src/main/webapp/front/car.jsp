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
    <title>查询汽车信息</title>
</head>
<body>
<div align="center"><h2>汽车信息如下</h2></div>
<table border="1" align="center">
    <thead>
    <tr><th>类型</th><th>价格</th><th>最大乘客量</th></tr>
    </thead>
    <c:forEach items="${car }" var="c">
        <tr>
            <th>${c.class}</th>
            <th>${c.price}</th>
            <th>${c.max}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
