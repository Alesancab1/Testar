<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<title><c:out value="${param.searchQuery}" /> - Testar</title>
</head>
<body>
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<fieldset id="Spotify">
				<legend>
					Spotify search for
					<c:out value="${param.searchQuery}" />
				</legend>
				<c:forEach items="${requestScope.song}" var="item">
					<iframe
						src="https://open.spotify.com/embed/album/<c:out value="${item.id}"/>"
						width="300" height="380" data-mce-fragment="1"> </iframe>
				</c:forEach>
			</fieldset>
			<a class="btn btn-light" href="/index.html">Volver al inicio</a>
		</div>
		<div class="col-3"></div>
	</div>
</body>
</html>