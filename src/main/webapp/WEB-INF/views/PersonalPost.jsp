<%--
  Created by IntelliJ IDEA.
  User: biyinghao
  Date: 2018/5/15
  Time: 上午12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PersonalPost</title>
</head>
<body>

贴主：${post.postUser}<br>
标题：${post.postTitle}<br>
内容：${post.postText}<br>
赞:${post.postZan}<br>
<form action="/replyPost.do" method="get">
    请写下您的回复内容:
    <input type="text" name="text_neirong"><br>
    <input type="hidden" name="text_user" value="${username}"><br>
    <input type="hidden" name="text_PostN" value="${post.postNumber}"><br>
    <input type="submit" value="回复">
</form>
回复:
<c:forEach var="reply" items="${replys}">
   <c:out value="${reply.text_user}"/>回复你:<br>
    <c:out value="${reply.text_neirong}"/><br>
    ---------------------------------------<br>
    <a href="/deleteReply/${reply.text_id}/${reply.text_PostN}/${reply.text_user}">删除</a>
</c:forEach>

</body>
</html>
