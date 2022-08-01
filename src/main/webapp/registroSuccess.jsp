<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Usuario añadido - Testar</title>
</head>
<body>
<main>
	<h3>¡Bienvenido <c:out value="${nickname}"/>! tu usuario se ha creado correctamente</h3><br>
</main>
<footer>
  	<br><br><br>
  	<a class="btn btn-light" href="index.html">Busca tus juegos</a>
  	<img id="sonic" src="images/sonic.png" alt="logo">
  </footer>
</body>
</html>