<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: biyinghao
  Date: 2018/4/23
  Time: 下午12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>gamesList</title>
</head>
<body>
<c:forEach var="game" items="${games}">
    <c:out value="${game.gameName}"/>
    <c:out value="${game.user}"/>
</c:forEach>
</body>
</html>
