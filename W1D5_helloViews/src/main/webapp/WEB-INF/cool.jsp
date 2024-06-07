<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>this is the cool page!!! </h2>
	<a href="/">home</a>
	<hr />
	${names.size() }
	<div>
		<ul>
		<c:forEach items="${names }" var="name">
			<li>${name }</li>		
		</c:forEach>
		</ul>
	</div>
	<p>the number is ${number }</p>
</body>
</html>