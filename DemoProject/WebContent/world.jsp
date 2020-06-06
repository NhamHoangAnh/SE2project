<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style type="text/css">
div{
	text-align: center;
}
h1, h3 {
	text-align: center;
	font-family: roboto condensed,sans-serif;
}
maincounter-wrap{
	margin: auto;
	text-align: center;
	padding-top: 20px
}
maincounter-wrap h3 {
	font-family: roboto condensed,sans-serif;
	font-weight: 300;
	font-size: 40px;
	color: #555;
	margin: 0
}
</style>
<script type="text/javascript">

function alertName(){
alert("Nham Gia Hoang Anh: " + ${world.totalConfirmed});
} 
</script> 

</head>
<body>
	<h1>COVID-19 Coronavirus Pandemic</h1>
	<div style="font-size:13px; color:#999; margin-top:5px; text-align:center">
		Date: ${world.date}
	</div>
	<div>
		<div id="maincounter-wrap" style="margin-top:15px">
			<h3>World Statistics</h3>	
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			Total Confirmed: ${world.totalConfirmed}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			New Confirmed: ${world.newConfirmed}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			Total Deaths: ${world.totalDeaths}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			New Deaths: ${world.newDeaths}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			Total Recovered: ${world.totalRecovered}
		</div>
		<div id="maincounter-wrap" style="margin-top:15px">
			New Recovered: ${world.newRecovered}
		</div>
	</div>
	<input type="submit" name="Submit" value="Click Me" onclick="alertName()">
	<footer class="footer">
		<h4>SE2Project</h4>
		<p>Powered by .me</p>
 	</footer>
</body>
</html>