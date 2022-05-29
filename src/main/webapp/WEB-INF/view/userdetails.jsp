<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User details</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>

<body
<%@ include file="menu.jsp" %>
<br>
Jedi Details!
<br>
<sec:authorize access="isAuthenticated()">
    user id: ${user.id}
    <br>
    user username: ${user.username}
    <br>
    user email: ${user.email}
    <br>
    user role: ${user.role.name}
    <br>
    <c:forEach items="${user.achievements}" var="achi">
        <img src="${achi.img}" title="${achi.name}">
    </c:forEach>
    <br>
</sec:authorize>

</body>
</html>