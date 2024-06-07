<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>hello views</h1>
	<hr />
	<a href="/cool">go to the cool page</a>
	<h3>the name is <c:out value="${name}"/> </h3>
	<p> <c:out value="${name }"/>'s age is <c:out value="${age }"/> </p>
	<hr />
	<p> ${ name }'s age is ${ age }</p>
</body>
</html>