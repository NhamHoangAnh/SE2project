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
						<th>Test</th>
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
								<form action="delete" method="post">
									<input type="hidden" name="deleteId" value="" />
        							<input type="submit" name="delete_province" value="DeleteByPost" />
    							</form>
    							<a href="/delete?pId=<c:out value= '' />">DeleteByHref</a>
							</td>
					
							<td>HoangANh</td>
							
					</c:forEach>
				</tbody>
			</table>
</body>
</html>