<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Auth page</title>
</head>
<body>

<h2 align="center">Entrance to Admin's page</h2>

<div align="center">

<p>
<c:out value="${ requestScope.loginFailedMsg }"></c:out>
</p>

<!--_______________ Login ____________________ -->
<p>
<c:if test="${ empty sessionScope.userData }">
<form action="Auth" method="post">
	<input type="hidden" name="operation" value="login">
	<table>
		<tr><td>Login (e-mail):</td><td><input type="email" autocomplete="on" name="email"></td></tr>
		<tr><td>Password:</td><td><input type="password" name="pass"></td></tr>
	</table>
	<input type="submit" value="Login">
</form>
</c:if>
</p>

<!--_______________ Logout ___________________-->
<p>
<c:if test="${ !empty sessionScope.userData }">
	Dear <c:out value="${ sessionScope.userData.name }"></c:out>
	&nbsp;<c:out value="${ sessionScope.userData.surname }"></c:out> 
	,<br> now you are logged in.
	<form action="Auth">
		<input type="hidden" name="operation" value="logout">
		<input type="submit" value="Logout">
	</form>
</c:if>
</p>

</div>

</body>
</html>