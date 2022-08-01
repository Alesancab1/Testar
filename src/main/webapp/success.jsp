<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
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
<title>Resultados de la búsqueda de <c:out
		value="${param.searchQuery}" /> - Testar
</title>
</head>
<body class="d-flex flex-column h-100">

	<!-- NAV BAR -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="index.html">Inicio</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="info.html">Información</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="documentacion.html">Documentación</a></li>
				<li class="nav-item"><a class="nav-link" href="contacto.html">Contacto</a>
				</li>
			</ul>
		</div>
	</nav>

	<!-- ROW 1 -->
	<div class="row">
		<div class="col-2"></div>

		<!-- COL YT -->
		<div class="col-4">
			<!-- VIDEO YT -->
			<c:forEach items="${requestScope.videos}" var="item">
				<iframe width="640" height="360"
					src="https://www.youtube.com/embed/<c:out value="${item.id.videoId}"/>"></iframe>
			</c:forEach>
		</div>

		<!-- COL RAWG -->
		<div class="col-4">
			<div class="white-box">
				<fieldset class="border p-2">
					<legend class="w-auto">
						<c:out value="${param.searchQuery}" />
					</legend>
					<c:forEach items="${requestScope.game}" var="videogame">
						<c:out value="${videogame}" escapeXml="false" />
					</c:forEach>
				</fieldset>
			</div>
		</div>
		<div class="col-2"></div>
	</div>

	<!-- ROW 2 -->
	<div class="row">
		<div class="col-2"></div>
		
		<!-- COMENTARIO YT -->
		<div class="col-4">
			<c:forEach items="${requestScope.videos}" var="item">
				<form method="post" action="/CommentController">
					<div class="card">
						<div class="card-body">
							<input type='hidden' name='videoId'
								value="<c:out value="${item.id.videoId}"/>" /> <input
								type='hidden' name='MOVId'
								value="<c:out value="${requestScope.movies.id}"/>" /> <input
								type='hidden' name='channelId'
								value="<c:out value="${item.snippet.channelId}"/>" /> <input
								type="text" name="comentarios" class="form-control"
								placeholder="Escribe tu comentario aqui"></input>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Comentar</button>
				</form>
			</c:forEach>
		</div>

		<!-- COL SPOTIFY -->
		<div class="col-4">
			<form id="logForm" action="spotifyGetSongController" method="post">
				<div>
					<button type="submit" name="searchQuery"
						value="${param.searchQuery}"
						class="btn btn-primary">Escucha la banda
						sonora</button>
				</div>
			</form>
		</div>
		<div class="col-2"></div>
	</div>

	<div class="row">
		<div class="col-2"></div>
		
		<!-- COL GMAPS -->
		<div class="col-8" align="center">
			<h1>Busca tiendas de videojuegos en tu ciudad</h1>
			<div id="searchDiv">
				<form id="searchForm" action="GmapsController" method="post">
					<input type="text" name="searchQuery" required /> <input
						type="submit" name="searchBtn" title="search" value="search">
				</form>
			</div>
		</div>

		<div class="col-2"></div>
	</div>

</body>
</html>

