<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style type="text/css">
	h1 {
		text-align: center;
		font-family: roboto condensed,sans-serif;
	}
	div {
		text-align: center;
	}
</style>
</head>
<body>
	<h1>COVID-19 Coronavirus Pandemic</h1>
	<div style="font-size:13px; color:#999; margin-top:5px; text-align:center">
		Date: ${world.date}
	</div>
	<div class = "jumbotron adminLogin">
		<h1>Admin Login</h1>
		<form method="GET" action = "">
			<h2> UserName: </h2>
			<input type = "text" name="userName" size="45" />
			<h2> PassWord: </h2>
			<input type = "text" name="password" size="45" />
			<br>
			<br>
			<input type="submit" value="Login" />
		</form>
		<h3><a href="${pageContext.request.contextPath}/guestHomePage ">Login as Guest</a></h3>
	</div>
	<footer class="footer">
		<h4>SE2Project</h4>
		<p>Powered by .me</p>
 	</footer>
</body>
</html>