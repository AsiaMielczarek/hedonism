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
    <title>Sign up</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>

<%@ include file="../../fragments/headersign.jsp" %>
    <div class="inside">

        <a id="join">Great! You want to be One of Hedonists!</a>
        <br><br>
        <div class="form">
        <form:form modelAttribute="user" method="POST">
           <form:hidden path="id"/>
           Your name: <br><form:input path="name"/><br><form:errors path="name" element="div" cssClass="error"/>
           Your email: <br><form:input path="email"/><br><form:errors path="email" element="div" cssClass="error"/>
           Your password: <br><form:password path="password"/><br><form:errors path="password" element="div" cssClass="error"/>
           <%--Categories: <br><form:select path="categories" items="${categories}" itemLabel="name" itemValue="id"/>--%>
            <br><br>
            <input type="image" src="/resources/elements/send.jpg"/>
        </form:form>
        </div>
    </div>
<%@ include file="../../fragments/footer.jsp" %>
</body>
</html>
