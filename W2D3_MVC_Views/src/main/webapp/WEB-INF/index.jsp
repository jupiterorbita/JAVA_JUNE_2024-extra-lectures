<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
	<h1>Hello</h1>
	
	
	<c:out value="${tripList }"/>
	<hr />
	
	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>location</th>
				<th>planner</th>
				<th>trip length</th>
				<th>ACTIONS</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="trip" items="${tripList }">
					<tr>
						<td>${trip.id }</td>
						<td>
						<a href="/trips/${trip.id }"> ${trip.location} </a>
						
						</td>
						<td>${trip.owner }</td>
						<td>${trip.tripDuration }</td>
						<td>---</td>
					</tr>
				</c:forEach>
			</tbody>

	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
</div>
</body>
</html>