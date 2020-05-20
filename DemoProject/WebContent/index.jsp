<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
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
</body>
</html>