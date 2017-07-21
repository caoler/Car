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
    <title>查询线路信息</title>
</head>
<body>
<div align="center"><h2>线路信息如下</h2></div>
<table border="1" align="center">
    <thead>
    <tr><th>出发地</th><th>目的地</th><th>发车时间</th><th>所需时间</th><th>汽车类型</th></tr>
    </thead>
    <c:forEach items="${wiring }" var="w">
        <tr>
            <th>${w.start}</th>
            <th>${w.destination}</th>
            <th>${w.time}</th>
            <th>${w.stime}</th>
            <th>${w.class}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
