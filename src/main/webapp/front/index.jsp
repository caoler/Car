<%--
  Created by IntelliJ IDEA.
  User: GeekLe
  Date: 2017/6/1
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>长途汽车信息管理系统</title>
</head>
<body>
    <div align="center"><h1>欢迎使用长途汽车信息管理系统</h1></div>
    <br><br><br>
    <fieldset style="width:300px;margin:0px auto">
        <legend align="center">选择你的操作</legend>
        <ul>
            <li><a href="/front/QueryWiring" target="_blank">查询线路信息</a> </li>
            <li><a href="/front/QueryCar" target="_blank">查询汽车信息</a> </li>
            <li><a href="/front/QueryTicket" target="_blank">查询车票信息</a> </li>
        </ul>
    </fieldset>
<br>
    <div align="center"><a href="/login/login.jsp">管理员用户登录</a></div>
</body>
</html>
