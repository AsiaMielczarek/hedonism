<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 19.06.18
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>What's next...</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">

</head>
<body>

<%@ include file="../../fragments/headerhello.jsp" %>


<div class="inside" id="types">

    <a class="delete"> ${city} ! Let's see what's next...</a>
    <br><br>
    <a href="${city}/breakfast"> <img src="/resources/elements/breakfast.jpg" alt="Breakfast"/></a>
    <a href="${city}/dinner&supper"> <img src="/resources/elements/dinner.jpg" alt="Dinner&Supper"/></a>
    <a href="${city}/coffee&sweet"> <img src="/resources/elements/coffee.jpg" alt="Coffee&Sweets"/></a>
</div>


<%@ include file="../../fragments/footer.jsp" %>


</body>
</html>
