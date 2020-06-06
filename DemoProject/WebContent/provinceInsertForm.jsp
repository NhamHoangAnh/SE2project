<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Province Insert Form</title>
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
</style>
</head>
<body>
	<h1>COVID-19 Coronavirus Pandemic</h1>
	<div style="font-size:13px; color:#999; margin-top:5px; text-align:center">
		Date: ${world.date}
	</div>
    <div align="center">
    	<form action="" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Province
                </h2>
            </caption>           
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="iName" size="45" />
                </td>
            </tr>
            <tr>
                <th>Confirmed: </th>
                <td>
                    <input type="number" name="iConfirmed" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Deaths: </th>
                <td>
                    <input type="number" name="iDeaths" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Recovered: </th>
                <td>
                    <input type="number" name="iRecovered" size="45" />
                </td>
            </tr>
            <tr>
                <th>underTreatment: </th>
                <td>
                    <input type="number" name="iUnderTreatment" size="45"/>
                </td>
            </tr>
            <tr>
                <th>date: </th>
                <td>
                    <input type="String" name="iDate" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div> 
    <footer class="footer">
		<h4>SE2Project</h4>
		<p>Powered by .me</p>
 	</footer>  
</body>
</html>