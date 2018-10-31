
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
${user.username}
<form action = "/sakura/skipRegister.do">
    <input type="submit" value="注册">
</form>
<form action="/sakura/skipLogin.do">
    <input type="submit" value="登录">
</form>
<form action="/sakura/login.do">
    <input type="submit" value="提交">
</form>

${user.username}
<form action="/sakura/loginout.do">
    <input type="submit" value="退出登录">
</form>

<a href="WEB-INF/views/IM.jsp">通讯</a>
</body>
</html>
