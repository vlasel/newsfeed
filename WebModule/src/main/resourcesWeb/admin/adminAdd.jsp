<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add new page</title>
	
	<!-- tinyMCE -->
	<script type="text/javascript" src="../tinymce/tinymce.min.js"></script>
	<script type="text/javascript">
		tinymce.init({
		selector: "textarea"
		});
	</script>
	
	<style type="text/css">
		span.reqFill {
			color: #FF0000;
		}
	</style>
</head>


<!-- ####################### body ############################# -->
<body>
	<h3>
		Add news 
		<br>to category with id="<c:out value="${param.id }"></c:out>"
	</h3>
<p><b>Enter page data (* - is required):</b></p>

<form action="adminController" method="post">
	<input type="hidden" name="operation" value="addnewswrite">
	<%-- <input type="hidden" name="idcat" value="<c:out value="${param.id }"></c:out>"> --%>
	<input type="hidden" name="author" value="<c:out value="${sessionScope.userData.name }"></c:out>&nbsp;<c:out value="${sessionScope.userData.surname }"></c:out>">

	<table border="0">
	
		<tr>
			<td>Категория:</td>
			<td>
				<select size="1" name="idcat">
					<c:forEach var="category" items="${ requestScope.categoryList }">
					<option value="<c:out value="${ category.id }"></c:out>"><c:out value="${ category.name }"></c:out></option>
					</c:forEach>
				</select>
			</td>
		</tr>
		
		<tr><td>Название:</td><td><input name="name"><span class="reqFill">*</span></td></tr>
		<tr><td>Описание :</td><td><input name="annotation"><span class="reqFill">*</span></td></tr>
		<tr><td>Автор:</td><td><input disabled value="<c:out value="${sessionScope.userData.name }"></c:out>&nbsp;<c:out value="${sessionScope.userData.surname }"></c:out>"></td></tr>
		<tr><td>Date:</td><td><input name="date" value='<c:out value="${ requestScope.date }"></c:out>'></td></tr>
		<tr><td>Time:</td><td><input name="time" value='<c:out value="${ requestScope.time }"></c:out>'></td></tr>
		
	</table>
	<br>
	News text:
	<p>
	<textarea rows="15" cols="40" name="maintext"></textarea>
	</p>
	<input type="submit" value="Submit">
</form>

</body>
</html>