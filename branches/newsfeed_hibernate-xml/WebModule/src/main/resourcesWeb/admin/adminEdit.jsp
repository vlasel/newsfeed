<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Edit page</title>
	
	<!-- tinyMCE -->
	<script type="text/javascript" src="../tinymce/tinymce.min.js"></script>
	<script type="text/javascript">
		tinymce.init({
		selector: "textarea.visedit"
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
		Edit page 
		<br>with id="<c:out value="${param.id }"></c:out>"
	</h3>
<p><b>Enter page data (* - is required):</b></p>

<form action="adminController" method="post">
	<input type="hidden" name="operation" value="editnewswrite">
	<input type="hidden" name="id" value='<c:out value="${ requestScope.newsdata.id }"></c:out>'>

	<table border="0">
		
		
		<tr><td>Категория:</td>
			<td>
				<select size="1" name="idcat">
					<c:forEach var="category" items="${ requestScope.categoryList }">
					<option 
						<c:if test="${ requestScope.newsdata.idcat  ==  category.id }">
							selected
						</c:if>
					value="<c:out value="${ category.id }"></c:out>"><c:out value="${ category.name }"></c:out></option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr><td>News Name:</td><td><input name="name" value='<c:out value="${ requestScope.newsdata.name }"></c:out>'><span class="reqFill">*</span></td></tr>
		<tr><td>Автор:</td><td><input name="author" value='<c:out value="${ requestScope.newsdata.author }"></c:out>'></td></tr>
		<tr><td>Date:</td><td><input name="date" value='<c:out value="${ requestScope.newsdata.date }"></c:out>'></td></tr>
		<tr><td>Time:</td><td><input name="time" value='<c:out value="${ requestScope.newsdata.time }"></c:out>'></td></tr>
		<tr><td>Annotation :</td><td><input name="annotation" value='<c:out value="${ requestScope.newsdata.annotation }"></c:out>'><span class="reqFill">*</span></td></tr>
			
	</table>
	
	<br>
	maintext:
	<p>
	<textarea class="visedit" rows="15" cols="40" name="maintext" ><c:out value="${ requestScope.newsdata.maintext }"></c:out></textarea>
	</p>
	<input type="submit" value="Save">
</form>

</body>
</html>