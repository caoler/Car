<%--
  Created by IntelliJ IDEA.
  User: GeekLe
  Date: 2017/6/1
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<br><br><br>
<div align="center"><h2>管理员登录界面</h2></div><br>

    <fieldset style="width:300px;margin:0px auto">
        <legend align="center">管理员登录</legend><br>
        <form action="<%=request.getContextPath()%>/login/loginAdmin" method="post">
            &nbsp;&nbsp;ID：&nbsp;<input type="text" name="admin.id"/><br><br>
            &nbsp;&nbsp;密码：<input type="password" name="admin.password"><br><br>
            <div align="center">${UnameErrMsg }${PwdErrMsg }</div>
            <br>
            <div align="center"><input type="submit" value="提交"></div>
        </form>
    </fieldset>

</body>
</html>
