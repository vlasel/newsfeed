<%-- 
<%@page import="java.util.Iterator"%>
<%@page import="data.PageData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DbPagesDAO"%>
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Admin page</title>
	<style>
		/* a.edit { color: #FFA500; font: 80% sans-serif; }
		a.delete { color: #FF0000; font: 80% sans-serif; }
		a.add { color: #008000; font: 80% sans-serif; } */
		span.menu {font: bold 100% serif;}
		span.info {font: 90% serif;}
		div.head {font: bold 130% serif;}
	</style>
</head>

<body>

<table border="1" width="100%">

<tr><td colspan="2">

    <table border="0" width="100%">
        <tr>
            <td width="200"><img alt="tomcat.png" src="../images/tomcat.png"></td>
            <td align="center"><h2>  Admin's page</h2></td>

        </tr>

    </table>

</td>

<td width="300">
<!--_________________ user and auth ______________________  -->
<p>
<c:if test="${ empty sessionScope.userData }">
	<a href="../Auth">&gt;&gt;Authorize to Admin's mode</a>
</c:if>
<c:if test="${!empty sessionScope.userData }">
	Hello, <c:out value="${ sessionScope.userData.name }"></c:out>&nbsp;<c:out value="${ sessionScope.userData.surname }"></c:out>!
	<br>You login: <c:out value="${ sessionScope.userData.email }"></c:out>
	<form action="../Auth" method="post">
		<input type="hidden" name="operation" value="logout">
		<input type="submit" value="Logout">
	</form>
</c:if>
</p>
<!--______________________________________________________  -->

<a href="../SiteController">&gt;&gt;go to user mode</a>

</td>
</tr>


<tr>
<td width="300">



Выберите дату:
<br>
<form action="">
<select size="1" name="Выберите дату">
	<option value="add">1</option>
	<option value="substract">2</option>
	<option value="multiply">3</option>
</select>

<input type="submit" value="Выбрать">
</form>

<h3>Категории новостей:</h3>
<a href="adminController">Все новости</a>
<ul>
	<c:forEach var="menuSection" items="${ requestScope.menu }">
	<li>
		<a href="adminController?viewby=category&id=<c:out value="${ menuSection.id }"></c:out>"><c:out value="${ menuSection.value }"></c:out></a>
	</li>
	</c:forEach>
	
</ul>
</td>







<td colspan="2" valign="top">
<h3 align="center">Список новостей</h3>

<a href="adminController?operation=addnews">
				[Добавить новость]</a>

<ul>
<c:forEach var="newsdata" items="${ requestScope.listNews }">
			<li>
				<span class="info">
				<c:out value="${ newsdata.date }"></c:out>--<c:out value="${ newsdata.time }"></c:out>
				</span>
				<a href="adminController?operation=editnews&id=<c:out value="${ newsdata.id }"></c:out>">
					<c:out value="${ newsdata.name }"></c:out></a>
				<span class="info"> &ensp;- Автор: &nbsp;<c:out value="${ newsdata.author }"></c:out></span>
			</li>
</c:forEach>
</ul>



</td>
</tr>
</table>

</body>
</html>