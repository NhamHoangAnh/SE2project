<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello SE2Project</h1>
	<form method=GET action="Country">
	Country Name:
	<input type = "text" name = "countryName">
	<input type=submit>
	</form>
	<div>
		<h3>Country Statistics</h3>
		<div>Country: ${c.country}</div>
		<div>New Confirmed: ${c.newConfirmed}</div>
		<div>Total Confirmed: ${c.totalConfirmed}</div>
		<div>New Deaths: ${c.newDeaths}</div>
		<div>Total Deaths: ${c.totalDeaths}</div>
		<div>New Recovered: ${c.newRecovered}</div>
		<div>Total Recovered: ${c.totalRecovered}</div>
		<div>Date: ${c.date}</div>
		<div>Country Code: ${c.countryCode}</div>
	</div>
</body>
</html>