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
    <title>查询车票信息</title>
</head>
<body>
    <div align="center"><h2>车票信息如下</h2></div>
    <br>
    <div align="center"><a href="/admin/UpdateTicket">新增车票</a></div><br>
<table border="1" align="center">
    <thead>
    <tr><th>价格</th><th>总票数</th><th>已售</th><th>剩余票数</th><th>操作</th></tr>
    </thead>
    <c:forEach items="${ticket }" var="t">
        <tr>
            <th>${t.price}</th>
            <th>${t.total}</th>
            <th>${t.sold}</th>
            <th>${t.last}</th>
            <th>
                <a href="/admin/UpdateTicket?price=${t.price}">编辑</a>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
