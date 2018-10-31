<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: biyinghao
  Date: 2018/4/22
  Time: 下午11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这里是发贴专用区</title>
</head>
<body>
${user.username}
${users.id}
${users.address}
${users.birthday}
${users.sex}
${users.username}<br>
帖子：
<c:forEach var="post" items="${posts}">
    发帖人：<c:out value="${post.postUser}"/><br>
    帖子标题：<a href="/writeView/${post.postNumber}/${users.username}"> <c:out value="${post.postTitle}"/></a><br>
    帖子内容：<c:out value="${post.postText}"/><br>
    赞：<c:out value="${post.postZan}"/>
    <form action="/deletePost.do" method="post">
        <input type="hidden" name="PostNumber" value="${post.postNumber}">
        <input type="hidden" name="username" value="${users.username}">
        <input type="hidden" name="userId" value="${users.id}">
        <input type="submit" value="删除">
    </form>
    ---------------------------------------<br>
</c:forEach>


<form action="/writePost.do" method="post">
    <%--使用隐藏域存储生成的token--%>
    <%--
        <input type="hidden" name="token" value="<%=session.getAttribute("token") %>">
    --%>
    <%--使用EL表达式取出存储在session中的token--%>
    <input type="hidden" name="token" value="${token}"/>
    请输入您帖子的标题
     <input type="text" name="title">
    请输入您想要发表的帖子
    <input type="text" name="text">
    <input type="hidden" name="username" value="${users.username}">
    <input type="hidden" name="userId" value="${users.id}">
    <input type="submit" value="发表">
</form>



</body>
</html>
