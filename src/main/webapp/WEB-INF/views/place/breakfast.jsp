<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 19.06.18
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Breakfast's places in ${city}</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>

<%@ include file="../../fragments/headerhello.jsp" %>

<div class="inside">
       <a id="join">If you want to eat awesome breakfast in ${city}, go to...</a><br><br>
       <ul>
          <c:forEach items="${breakfastPlaces}" var="b">
             <li> <a class="list" href="/${b.city}/${b.type.name}/${b.name}"><c:out value="${b.name}"/></a> </li>
          </c:forEach>
           <li> <a class="list" href="/${city}/breakfast/${randomPlace.name}">I don't know - CHOOSE FOR ME</a></li>
       </ul>
</div>

<%@ include file="../../fragments/footer.jsp" %>

</body>
</html>
