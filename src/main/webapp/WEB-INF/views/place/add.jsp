<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 18.06.18
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new place</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>

<%@ include file="../../fragments/header.jsp" %>

<c:choose>
    <c:when test="${empty user}">

    </c:when>
    <c:otherwise>

    <div class="inside">
        <a id="join">Great! <br> Let's add new hedonism place:</a>

        <form:form modelAttribute="place" method="POST">
            name:<br> <form:input path="name"/><br><form:errors path="name" element="div" cssClass="error"/>
            city:<br> <form:input path="city"/><br><form:errors path="city" element="div" cssClass="error"/>
            address:<br> <form:input path="address"/><br><form:errors path="address" element="div" cssClass="error"/>
            website:<br> <form:input path="website"/><br>
            about:<br> <form:textarea path="description"/><br>
            photo source: <br> <form:input path="imageSrc" /> <br>
            type:<br> <form:select path="type.id" items="${types}" itemLabel="name" itemValue="id"/><br>
            categories:<br> <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id"/><br><br>
            <input type="image" src="/resources/elements/send.jpg"/>
        </form:form>
    </div>
    </c:otherwise>
</c:choose>

<%@ include file="../../fragments/footer.jsp" %>

</body>
</html>
