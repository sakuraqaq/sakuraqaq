<%--
  Created by IntelliJ IDEA.
  User: biyinghao
  Date: 2018/7/5
  Time: 下午3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="/sakura/login.do" , method="post">
    请输入用户名：<input type="text" name="username">
    请输入密码：<input type="password" name="password">
    请输入验证码：<input type="text" name="code">
    <input type="submit" value="登录">
</form>

<form action="/loginout.do">
    <input type="submit" value="退出登录">
</form>

</body>
</html>
