<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 21.06.18
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${place.name}</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<%@ include file="../../fragments/headerhello.jsp" %>

<c:choose>
    <c:when test="${empty user}">


           <div class="w-50 p-3" style="float: left">
                <div class="mx-auto" style="width: 400px"  >
                    <img src="${place.imageSrc}" width="300px"/>
                </div>
           </div>
           <div class="w-50 p-3" style="float: left">
               <div class="inside">
                    <p class="place">
                        <a class="delete">${place.name}</a> <img src="../../resources/elements/mini.jpg"> <br>
                        <a class="describe">where:</a> ${place.address} / ${place.city}  <br>
                        <a class="describe">website:</a> <a href="//${place.website}">${place.website}</a> <br>
                        <a class="describe">about:</a> ${place.description} <br>
                        <a class="describe"> recommended for:</a> <c:forEach items="${place.categories}" var="c">
                        <c:out value="${c.name}"/> /
                         </c:forEach>  <br>
                        <br>
                        <br>
                        <a class="describe"> hedonists rate:</a> ${rating} <br>
                        <a class="describe">hedonist's comments:</a> <br>
                        <c:forEach items="${comments}" var="c">
                            @<c:out value="${c.user.name}"/> - <c:out value="${c.comment}"/><br>
                        </c:forEach> </a>

                        <br><br>
                        <a class="user">If you want rate or comment, firstly - sign in !</a>
                    </p>
                </div>
           </div>

    </c:when>
    <c:otherwise>
        <div class="w-50 p-3" style="float: left">
            <div class="mx-auto" style="width: 400px"  >
                <img src="${place.imageSrc}" width="300px"/>
            </div>
        </div>
        <div class="w-50 p-3" style="float: left">
        <div class="inside">
            <div class="place">
                <a class="delete">${place.name}</a> <img src="../../resources/elements/mini.jpg"> <br>
                <a class="describe">where:</a> ${place.address} / ${place.city}  <br>
                <a class="describe">website:</a> <a href="//${place.website}">${place.website}</a> <br>
                <a class="describe">about:</a> ${place.description} <br>
                <a class="describe"> recommended for:</a> <c:forEach items="${place.categories}" var="c">
                                                              <c:out value="${c.name}"/> /
                                                          </c:forEach>  <br>
                <br>
                <br>
                <a class="describe"> hedonists rate:</a> ${rating} <br>
                <a class="describe">hedonist's comments:</a> <br>
                <c:forEach items="${comments}" var="c">
                    @<c:out value="${c.user.name}"/> - <c:out value="${c.comment}"/><br>
                </c:forEach> </a>


                <br><br>
                <a class="user">We're waiting for your opinion !</a><br><br>
                <form method="post">
                <input type="number" name="rate" min="0.5" max="10.0" step="0.5" placeholder="  rate" width="80"/> / 10.0 <br><br>
                <input type="text" name="comment" maxlength="140" placeholder="  comment" width="80"/> <br><br>
                <input type="image" src="/resources/elements/send.jpg"/>
            </form>
            </div>
        </div>
        </div>
    </c:otherwise>
</c:choose>

<%@ include file="../../fragments/footer.jsp" %>
</body>
</html>
