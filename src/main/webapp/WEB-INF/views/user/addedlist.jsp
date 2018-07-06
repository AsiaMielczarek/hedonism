<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 20.06.18
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Places added by You</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>

<%@ include file="../../fragments/header.jsp" %>

<c:choose>
    <c:when test="${empty user}">

    </c:when>
    <c:otherwise>

        <div class="inside">

            <div>
                <a href="/add"> <img src="/resources/elements/newplace.jpg" alt="Add new place" /> </a>
                <a href="/you"> <img src="/resources/elements/you.jpg" alt="You" /> </a>
                    <%--<a href="/you/loved'"> <img src="/resources/elements/sign in.jpg" alt="Sign in" /> </a>--%>
            </div>
            <br><br>

        <div>
            Added by you:
            <ul>
                <c:forEach items="${places}" var="p">
                    <li>
                        <a href="/${p.city}/${p.type.name}/${p.name}"> ${p.name} / ${p.city}</a><br>
                        <button onClick="javascript:location.href='../edit/${p.name}'">edit</button>
                        <button onClick="javascript:location.href='../delete/${p.name}'">delete</button>
                    </li>
                </c:forEach>
            </ul>
        </div>
        </div>

    </c:otherwise>
</c:choose>

<%@ include file="../../fragments/footer.jsp" %>
</body>
</html>
