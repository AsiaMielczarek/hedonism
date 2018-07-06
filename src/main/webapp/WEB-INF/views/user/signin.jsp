<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 16.06.18
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>

<body>

<%@ include file="../../fragments/headersign.jsp" %>

    <div class="inside">

        <form:form modelAttribute="user" method="POST">
            Your email: <br> <form:input path="email"/><br><form:errors path="email" element="div" cssClass="error"/>
            Your password: <br> <form:password path="password"/><br><form:errors path="password" element="div" cssClass="error"/> <br>
            <input type="image" src="/resources/elements/send.jpg"/>
        </form:form>

        <br><br>
        <a id="join">Join to Gang of Hedonists!</a><br>
        <a href="/signup"><img src="/resources/elements/sign up.jpg" alt="Sign up" /></a>
    </div>

<%@ include file="../../fragments/footer.jsp" %>
</body>
</html>
