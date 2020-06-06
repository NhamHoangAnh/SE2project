<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country Insert Form</title>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style type="text/css">
	h1, h3 {
		text-align: center;
		font-family: roboto condensed,sans-serif;
	}
	div{
		text-align: center;
		font-family: roboto condensed,sans-serif;
	}
</style>
</head>
<body>
	<h1>COVID-19 Coronavirus Pandemic</h1>
	<div style="font-size:13px; color:#999; margin-top:5px; text-align:center">
		Date: ${world.date}
	</div>
	
	<form method=GET action="Country">
	Country Name:
	<input type = "text" name = "countryName">
	<input type=submit>
	</form>
	<div>
		<h3>Country Statistics</h3>
		<div id="maincounter-wrap" style="margin-top:15px">
			Country: ${c.country}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			New Confirmed: ${c.newConfirmed}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			Total Confirmed: ${c.totalConfirmed}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			New Deaths: ${c.newDeaths}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			Total Deaths: ${c.totalDeaths}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			New Recovered: ${c.newRecovered}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			Total Recovered: ${c.totalRecovered}
		</div>
		
		<div style="font-size:13px; color:#999; margin-top:5px; text-align:center">
		Date: ${c.date}
		</div>
		
		<div class="text-info">Country Code: ${c.countryCode}</div>
	</div>
	<footer class="footer">
		<h4>SE2Project</h4>
		<p>Powered by .me</p>
 	</footer>
</body>
</html>