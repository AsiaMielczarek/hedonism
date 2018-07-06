<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 20.06.18
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit profile</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>

<%@ include file="../../fragments/header.jsp" %>

<c:choose>
    <c:when test="${empty user}">

    </c:when>
    <c:otherwise>

    <div class="inside">
        <a id="join">Let's change something!</a>
        <br><br>
        <form method="POST">
            New name:<br> <input type="text" name="name"/><br>
            New password:<br><input type="password" name="password"/><br><br>
            <input type="image" src="/resources/elements/send.jpg"/>
        </form>

    </div>
    </c:otherwise>
</c:choose>

<%@ include file="../../fragments/footer.jsp" %>

</body>
</html>
