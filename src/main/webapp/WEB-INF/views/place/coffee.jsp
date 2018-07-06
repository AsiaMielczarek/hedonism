<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 19.06.18
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cafes & confectioneries in ${city}</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>

<%@ include file="../../fragments/headerhello.jsp" %>

<div class="inside">
    <a id="join">If you want to drink awesome coffee and eat some sweets in ${city}, go to...</a><br><br>
    <ul>
        <c:forEach items="${coffeePlaces}" var="c">
            <li> <a class="list" href="/${c.city}/${c.type.name}/${c.name}"><c:out value="${c.name}"/></a> </li>
        </c:forEach>
        <li> <a class="list" href="/${city}/coffee&sweet/${randomPlace.name}">I don't know - CHOOSE FOR ME</a></li>
    </ul>
</div>

<%@ include file="../../fragments/footer.jsp" %>

</body>
</html>
