<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Search results</title>
</head>
<body>






	<div class="row">
	<div class="col-2"></div>
		<div class="col-4 white-box">
			<fieldset id="gmaps">
				<legend>
					Google Maps search for
					<c:out value="${param.searchQuery}" />
				</legend>
				<c:forEach items="${requestScope.stores}" var="store">
					<span>Store: <c:out value="${store.name}" /></span>
					<br />
				</c:forEach>
			</fieldset>
		</div>
		<div class="col-4">
			<iframe width="600" height="450" frameborder="0" style="border: 0"
				src="https://www.google.com/maps/embed/v1/search?q=tiendas%20de%20videojuegos%20en%20+<c:out value="${param.searchQuery}"/>+&key=AIzaSyC0JboOruGnrEAATZF-3o0IDonw1fKwxEg"
				allowfullscreen></iframe>
		</div>
		<div class="col-2"></div>
	</div>
</body>
</html>