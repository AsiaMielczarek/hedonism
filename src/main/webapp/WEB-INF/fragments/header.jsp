<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 21.06.18
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<c:choose>
    <c:when test="${empty user}">
        <div class="container">
            <div class="row">
                <div class="col-8">
                    <br><br>
                    <a href="/"> <img src="/resources/elements/home.jpg" alt="Hedonism home" /> </a>
                </div>
                <div class="col-4">
                    <br><br><br><br><br>
                    <a href="/signin"> <img src="/resources/elements/sign in.jpg" alt="Sign in" /> </a>
                    <a href="/signup"> <img src="/resources/elements/sign up.jpg" alt="Sign up" /> </a>
                </div>
            </div>
        </div>

        <p class="emptyuser">Hi! If you want go there, firstly - sign in !</p>
    </c:when>
    <c:otherwise>
        <div class="container">
            <div class="row">
                <div class="col-8">
                    <br><br>
                    <a href="/"> <img src="/resources/elements/home.jpg" alt="Hedonism home" /> </a>
                </div>
                <div class="col-4">
                    <br><br><br><br><br>
                    <a href="/you"> <img src="/resources/elements/user panel.jpg" alt="You" /> </a>
                    <a href="/logout"> <img src="/resources/elements/log out.jpg" alt="Log out" /> </a>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>

</body>
</html>
