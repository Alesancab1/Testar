<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilos.css">
<title>Search results</title>
</head>
<body>
	<fieldset id="Youtube">
	<legend>Youtube search for <c:out value="${param.searchQuery}"/></legend>
	<c:forEach items="${requestScope.videos}" var="item">
		<iframe width="640" height="360" src="https://www.youtube.com/embed/<c:out value="${item.id.videoId}"/>"></iframe>
	</c:forEach>
</fieldset>






	
		</form>
    <form id="logForm" action="spotifyGetSongController" method="post">
        <div class="col-12 col-md4">
            <button type="submit" name="searchQuery" value="${param.searchQuery}"
            class="btn btn-block btn-lg btn-primary">Escucha la banda sonora</button>
        </div>
</form>

	<h1>Busca tiendas de videojuegos en tu ciudad</h1>
		<div id="searchDiv">
			<form id="searchForm" action="GmapsController" method="post">
				<input type="text" name="searchQuery" required /> <input
					type="submit" name="searchBtn" title="search" value="search">
			</form>
		</div>

		
		
<p>Trailer</p>
				<c:forEach items="${requestScope.videos}" var="item">
					<iframe id="ytplayer" type="text/html" width="420" height="205"
						src="https://www.youtube.com/embed/${item.id.videoId}"
						frameborder="0" allowfullscreen></iframe>
					<form method="post" action="/CommentController">
						<div class="card">
							<div class="card-body">
								<input type='hidden' name='videoId' value="<c:out value="${item.id.videoId}"/>" /> 
								<input type='hidden' name='MOVId' value="<c:out value="${requestScope.movies.id}"/>" /> 
								<input type='hidden' name='channelId' value="<c:out value="${item.snippet.channelId}"/>" /> 
								<input type="text" name="comentarios" class="form-control" placeholder="Escribe tu comentario aqui"></input>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Comentar</button>
					</form>
				</c:forEach>





<fieldset id="RAWG">
<legend>RAWG search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.game}" var="videogame">
	<span><c:out value="${videogame}"/></span><br/>
</c:forEach>
</fieldset>





</body>
</html>

