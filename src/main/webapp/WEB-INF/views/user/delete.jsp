<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 20.06.18
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete profile</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>

<%@ include file="../../fragments/header.jsp" %>

<div class="inside">
    <h3>Are you sure ?</h3>
    <br><br><br>
    <a>I don't want be Hedonist anymore...</a> - <button onClick="javascript:location.href='/you/delete/${user.id}'">delete</button><br><br>
    <a>No! It was mistake!</a> - <button onClick="javascript:location.href='/you'">go back</button>
</div>

<%@ include file="../../fragments/footer.jsp" %>

</body>
</html>
