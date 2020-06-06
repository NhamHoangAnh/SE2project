<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guest Province</title>
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
	<table class="table table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Confirmed</th>
						<th>Death</th>
						<th>Recovered</th>
						<th>Under Treatment</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
				    <%-- c:forEach => basic iteration tag --%>
					<c:forEach var="p" items="${allProvinces}">
						<tr>
						    <%-- c:out => for expressions --%>
						    <td><c:out value="${p.pId}" /></td>
							<td><c:out value="${p.name}" /></td>
							<td><c:out value="${p.confirmed}" /></td>
							<td><c:out value="${p.deaths}" /></td>
							<td><c:out value="${p.recovered}" /></td>
							<td><c:out value="${p.underTreatment}" /></td>
							<td><c:out value="${p.date}" /></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	<footer class="footer">
		<h4>SE2Project</h4>
		<p>Powered by .me</p>
 	</footer>
</body>
</html>