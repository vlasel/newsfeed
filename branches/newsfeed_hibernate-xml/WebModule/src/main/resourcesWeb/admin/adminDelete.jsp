<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Delete page</title>
	
	<style type="text/css">
		span.reqFill { color: #FF0000; }
		span.menu {font: bold 100% serif;}
	</style>
</head>


<!-- ####################### body ############################# -->
<body>
	<h3>
		Delete page 
		<br>with id="<c:out value="${param.id }"></c:out>"
	</h3>

<p><b>Are you sure to delete page and (if present below) all subpages?</b></p>

<form action="adminController" method="post">
	<input type="hidden" name="operation" value="deletewrite">
	<input type="hidden" name="id" value='<c:out value="${param.id}"></c:out>'>

	
	<table border="1">
	<tr><td align="left">
	<ul>
		<li>
			<span class="menu">
			<c:out value="${requestScope.menuSection.value}"></c:out>
			</span>
			<ul>
			<c:forEach var="menuSubsection" items="${ requestScope.menuSection.subsectionsList }">
				<li>
					<span class="menu">
					<c:out value="${ menuSubsection.value }"></c:out>
					</span>
				</li>
			</c:forEach>
			</ul>
		</li>
	</ul>
	</td></tr>
	</table>
	
	<input type="submit" value="Yes, Delete">
</form>

</body>
</html>