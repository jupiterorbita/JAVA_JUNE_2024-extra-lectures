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
	<h1>EDIT ${oneTrip.location }</h1>
	
	<form:form action="/trips/${oneTrip.id }/edit" method="POST" modelAttribute="oneTrip">
		<input type="hidden" name="_method" value="put">
		<div>
			<form:label path="location">location</form:label>
			<form:input path="location" class="form-control"/>
			<form:errors path="location" style="color:red"/>
		</div>
		<div>
			<form:label path="tripDuration">tripDuration</form:label>
			<form:input type="number" step="1" path="tripDuration" class="form-control" />
			<form:errors path="tripDuration" class="err"/>
		</div>
		<div>
			<form:label path="description">description</form:label>
			<form:textarea path="description" class="form-control"/>
			<form:errors path="description" class="err"/>
		</div>
		<div>
			<form:label path="owner">owner</form:label>
			<form:input path="owner" class="form-control"/>
			<form:errors path="owner" class="err"/>
		</div>
		
		<p></p>
		<input type="submit" value="create!" class="btn btn-primary" />
	
	</form:form>
</div>
</body>
</html>