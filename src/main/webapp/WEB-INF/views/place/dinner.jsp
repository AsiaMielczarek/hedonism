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
    <title>Restaurants in ${city}</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>

<%@ include file="../../fragments/headerhello.jsp" %>

<div class="inside">
    <a id="join">If you want to eat awesome dinner / supper in in ${city}, go to...</a><br><br>
    <ul>
        <c:forEach items="${dinnerPlaces}" var="d">
            <li> <a class="list" href="/${d.city}/${d.type.name}/${d.name}"><c:out value="${d.name}"/></a> </li>
        </c:forEach>
        <li> <a class="list" href="/${city}/dinner&supper/${randomPlace.name}">I don't know - CHOOSE FOR ME</a></li>
    </ul>
</div>

<%@ include file="../../fragments/footer.jsp" %>

</body>
</html>
