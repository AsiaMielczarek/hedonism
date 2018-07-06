<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 20.06.18
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hi ${user.name}!</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>

<%@ include file="../../fragments/header.jsp" %>

<c:choose>
    <c:when test="${empty user}">

    </c:when>
    <c:otherwise>

    <div class="inside">
        <h3>Hello, ${user.name} !</h3>

        <div>
            <a href="/add"> <img src="/resources/elements/newplace.jpg" alt="Add new place" /> </a>
            <a href="/you/added"> <img src="/resources/elements/added.jpg" alt="Added by You" /> </a>
            <%--<a href="/you/loved'"> <img src="/resources/elements/sign in.jpg" alt="Sign in" /> </a>--%>
        </div>
        <br><br>
        <div>
            <a href="/you/edit">Edit profile</a> or <a href="/you/delete">Delete profile</a>
        </div>
    </div>

    </c:otherwise>
</c:choose>

<%@ include file="../../fragments/footer.jsp" %>

</body>
</html>
