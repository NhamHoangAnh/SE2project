<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>All Countries</title>
</head>
<body>
	
	<h3><a href="${pageContext.request.contextPath}/AllCountries?insert=1">Add A New Country Statistics</a></h3>
	
	<table class="table table-bordered">
				<thead>
					<tr>
						<th>Country</th>
						<th>New Confirmed</th>
						<th>Total Confirmed</th>
						<th>New Death</th>
						<th>Total Deaths</th>
						<th>New Recovered</th>
						<th>Total Recovered</th>
						<th>Date</th>
						<th>Country Code</th>
						<th>Delete and Edit</th>
					</tr>
				</thead>
				<tbody>
				    <%-- c:forEach => basic iteration tag --%>
					<c:forEach var="Country" items="${c}">
						<tr>
						    <%-- c:out => for expressions --%>
							<td><c:out value="${Country.country}" /></td>
							<td><c:out value="${Country.newConfirmed}" /></td>
							<td><c:out value="${Country.totalConfirmed}" /></td>
							<td><c:out value="${Country.newDeaths}" /></td>
							<td><c:out value="${Country.totalDeaths}" /></td>
							<td><c:out value="${Country.newRecovered}" /></td>
							<td><c:out value="${Country.totalRecovered}" /></td>
							<td><c:out value="${Country.date}" /></td>
							<td><c:out value="${Country.countryCode}" /></td>
							<td>
								<a href="${pageContext.request.contextPath}/AllCountries?delId=<c:out value='${Country.cId}' />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath}/AllCountries?editId=<c:out value='${Country.cId}' />">Edit</a>
							</td>
					</c:forEach>
				</tbody>
			</table>
			
</body>
</html>