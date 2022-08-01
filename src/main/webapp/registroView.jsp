<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Registro - Testar</title>
</head>

<body>
	<div class="container jumbotron">
		<h3>
			<c:out value="${message}" />
		</h3>
		<h2>¡Registrate ya y empieza a disfrutar de todas las ventajas!</h2>
	</div>
	<main class="container">
		<div id="searchDiv">
			<form id="registroForm" action="UsuarioController" method="post">
				<input type="text" name="nickname" placeholder="Nombre de usuario"
					required /> <br> <br> <input type="password" name="pass"
					placeholder="Contraseña" required /> <br> <br> <input
					type="submit" name="registro" title="registro" value="REGISTRARSE"
					class="button">
			</form>
		</div>
	</main>
</body>

<footer>
	<br> <br> <br>
	<hr>
	<a class="btn btn-light" href="index.html">Página Principal</a>
</footer>
</html>