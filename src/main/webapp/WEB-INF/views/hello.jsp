<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 16.06.18
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hedonism</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>

<%@ include file="../fragments/headerhello.jsp" %>

<div class="inside">
    <a id="join">Choose the City You want to eat...</a><br><br>

    <form method="post">
        <input type="text" name="city"/><br>
        <input type="image" src="/resources/elements/localisation.jpg"/>
    </form>
</div>

<%@ include file="../fragments/footer.jsp" %>


</body>
</html>
