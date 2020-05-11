<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function alertName(){
alert("Nham Gia Hoang Anh: " + ${world.totalConfirmed});
} 
</script> 

</head>
<body>
	<h1>Hello SE2Project</h1>
	<div>
		<h3>World Statistics</h3>
		<div>Total Confirmed: ${world.totalConfirmed}</div>
		<div>New Confirmed: ${world.newConfirmed}</div>
		<div>Total Deaths: ${world.totalDeaths}</div>
		<div>New Deaths: ${world.newDeaths}</div>
		<div>Total Recovered: ${world.totalRecovered}</div>
		<div>New Recovered: ${world.newRecovered}</div>
	</div>
	<input type="submit" name="Submit" value="Click Me" onclick="alertName()">
</body>
</html>