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

<title>User page</title>
	<style>
		 a.edit { color: #FFA500; font: 80% sans-serif; }
		a.delete { color: #FF0000; font: 80% sans-serif; }
		a.add { color: #008000; font: 80% sans-serif; }
		span.menu {font: bold 100% serif;}
		span.info {font: 90% serif;}
		dd.annot {font: 90% serif; font-style: italic;}
	</style>
</head>

<body>

<table border="1" width="100%" cellpadding="3">

<tr><td colspan="2">

    <table border="0" width="100%">
        <tr>
            <td width="200"><img alt="tomcat.png" src="images/tomcat.png"></td>
            <td align="center"><h2>  User's page</h2></td>

        </tr>

    </table>

</td>

<td width="300">
<!--_________________ user and auth ______________________  -->
<p>
<c:if test="${ empty sessionScope.userData }">
	<a href="Auth">&gt;&gt;Authorize to Admin's mode</a>
</c:if>
<c:if test="${!empty sessionScope.userData }">
	Hello, <c:out value="${ sessionScope.userData.name }"></c:out>&nbsp;<c:out value="${ sessionScope.userData.surname }"></c:out>!
	<br>You login: <c:out value="${ sessionScope.userData.email }"></c:out>
	<form action="Auth" method="post">
		<input type="hidden" name="operation" value="logout">
		<input type="submit" value="Logout">
	</form>
	<p>
	<a href="admin/adminController">&gt;&gt;go to Admin mode</a>
	</p>
</c:if>
</p>
<!--______________________________________________________  -->



</td>
</tr>


<tr>

<!--___________________ Left - Menu  _________________________________-->
<td width="300" valign ="top">


Выберите дату:
<br>
<form>
<select size="1" name="Выберите дату">
	<option value="22.03.2014">22.03.2014</option>
	<option value="23.03.2014">22.03.2014</option>
</select>
<input type="submit" value=Применить>
</form>

<h3>Категории новостей:</h3>
<a href="SiteController">Все новости</a>
<ul>
	<c:forEach var="menuSection" items="${ requestScope.menu }">
	<li>
		<a href="SiteController?viewby=category&id=<c:out value="${ menuSection.id }"></c:out>"><c:out value="${ menuSection.value }"></c:out></a>
	</li>
	</c:forEach>
	
</ul>
</td>
<!--_________________________________________________________-->





<!--_______________________ Right - Main View ____________________________ -->
<td colspan="2" valign="top">




<c:if test="${ param.viewby == 'onenews' }">
<p>
<a href="SiteController">&lt;&lt; к списку новостей</a>
</p>

<c:forEach var="newsdata" items="${ requestScope.newsList }">
	<h2 align="center"><c:out value="${ newsdata.name }" escapeXml="false"></c:out></h2>
				<span class="info">
				
				<c:out value="${ newsdata.date }"></c:out>-<c:out value="${ newsdata.time }"></c:out>
				&ensp;- Автор: &nbsp;<c:out value="${ newsdata.author }"></c:out>
				
				</span>
				
				<c:out value="${ newsdata.maintext }" escapeXml="false"></c:out>
</c:forEach>
</c:if>


<c:if test="${ param.viewby != 'onenews' }">
<h3 align="center">Список новостей</h3>
<dl>
<c:forEach var="newsdata" items="${ requestScope.newsList }">
			<dt>
				<span class="info">
				<c:out value="${ newsdata.date }"></c:out>&ndash;<c:out value="${ newsdata.time }"></c:out>
				</span>
				<a href="SiteController?viewby=onenews&id=<c:out value="${ newsdata.id }"></c:out>">
					<c:out value="${ newsdata.name }"></c:out></a>
				<span class="info">
					&ensp; - Автор: &nbsp;<c:out value="${ newsdata.author }"></c:out>
				</span>
			</dt>
			<dd class="annot">
				&emsp;&emsp;&emsp;&emsp;&ensp;<c:out value="${ newsdata.annotation }"></c:out>
			</dd>
</c:forEach>
</dl>
</c:if>



</td>
</tr>
</table>

</body>
</html>