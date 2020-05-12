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
						<th>Delete</th>
						<th>Delete Part 2</th>
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
							<td>
								<a href="${pageContext.request.contextPath}/delete?id=<c:out value='${p.pId}' />">Delete</a>
							</td>
							
					</c:forEach>
				</tbody>
			</table>
</body>
</html>