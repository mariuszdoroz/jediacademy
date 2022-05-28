<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>register page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>

<body>
<%@ include file="menu.jsp" %>
<br>
<h1>Edit User!</h1>
<br>
<form:form method="post"
           modelAttribute="user" action="/dashboard/user/edit">
    <form:hidden path="id"/>
    User Name: <form:input type="text" path="username" /><br>
    Email: <form:input type="email" path="email"/><br>
    New password: <form:input type="password" path="password" /><br>
    <input type="submit" value="update"><br>
</form:form>
</body>
</html>