<%--
  Created by IntelliJ IDEA.
  User: GeekLe
  Date: 2017/6/14
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<br><br><br>
<div align="center"><h2>欢迎使用长途汽车管理系统</h2></div><br>

<fieldset style="width:300px;margin:0px auto">
    <legend align="center">用户登录</legend><br>
    <form action="ulogin" method="post">
        &nbsp;&nbsp;ID：&nbsp;<input type="text" name="user.id"/><br><br>
        &nbsp;&nbsp;密码：<input type="password" name="user.password"><br><br>
        <div align="center">${UnameErrMsg }${PwdErrMsg }</div>
        <br>
        <div align="center"><input type="submit" value="提交">&nbsp;&nbsp;&nbsp;<a href="regist.jsp">去注册</a></div>
    </form>
</fieldset>

</body>
</html>
