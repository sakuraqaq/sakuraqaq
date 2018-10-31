<%--
  Created by IntelliJ IDEA.
  User: biyinghao
  Date: 2018/7/5
  Time: 下午2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/sakura/register.do" method="post">
请输入用户名：<input type="text" name="username"><br>
请输入密码 ：<input type="password" name="password"><br>
请输入邮箱 ：<input type="email" name="email"><br>
请输入验证码：<input type="text" name="code"><br>
<input type="submit" value="提交">
</form>
</body>
</html>
