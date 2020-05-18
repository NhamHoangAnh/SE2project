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
	<div>
		<h3>World Statistics</h3>
		<div>Total Confirmed: ${world.totalConfirmed}</div>
		<div>New Confirmed: ${world.newConfirmed}</div>
		<div>Total Deaths: ${world.totalDeaths}</div>
		<div>New Deaths: ${world.newDeaths}</div>
		<div>Total Recovered: ${world.totalRecovered}</div>
		<div>New Recovered: ${world.newRecovered}</div>
	</div>
	<h3> <a href="${pageContext.request.contextPath}/AllCountries ">Go to Country Statistics</a> </h3>
	<div>
		<h3>VietNam Statistics</h3>
		<div>Total Confirmed: ${vn.totalConfirmed}</div>
		<div>New Confirmed: ${vn.newConfirmed}</div>
		<div>Total Deaths: ${vn.totalDeaths}</div>
		<div>New Deaths: ${vn.newDeaths}</div>
		<div>Total Recovered: ${vn.totalRecovered}</div>
		<div>New Recovered: ${vn.newRecovered}</div>
	</div>
	<h3> <a href="${pageContext.request.contextPath}/provinces ">Go to VietNam's provinces Statistics</a> </h3>
	<div>Date: ${world.date}</div>
</body>
</html>