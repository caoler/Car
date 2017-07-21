<%--
  Created by IntelliJ IDEA.
  User: GeekLe
  Date: 2017/6/5
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增 & 编辑</title>
</head>
<body>
<br><br><br>
<fieldset style="width:300px;margin:0px auto">
    <legend align="center">新增 & 修改车票信息</legend><br>
    <form action="/admin/save" method="post">
        请输入价格：&nbsp;<input type="text" name="admin.price" value="${admin.price}">
        <br><br>
        请输入总票数：<input type="text" name="admin.total" value="${admin.total}">
        <br><br>
        已售票数：&nbsp;&nbsp;<input type="text" name="admin.sold" value="${admin.sold}">
        <br><br>
        剩余票数：&nbsp;&nbsp;<input type="text" name="admin.last" value="${admin.last}">
        <br><br>
        <div align="center"><input type="submit" value="Submit"></div>
    </form>
</fieldset>
</body>
</html>
