<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Province Form Edit</title>
</head>
<body>
    <div align="center">
    	<form action="" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Province
                </h2>
            </caption>
                <c:if test="${p != null}">
                    <input type="hidden" name="ePId" value="<c:out value='${p.pId}' />" />
                </c:if>           
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="eName" size="45"
                            value="<c:out value='${p.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Confirmed: </th>
                <td>
                    <input type="number" name="eConfirmed" size="45"
                            value="<c:out value='${p.confirmed}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Deaths: </th>
                <td>
                    <input type="number" name="eDeaths" size="45"
                            value="<c:out value='${p.deaths}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Recovered: </th>
                <td>
                    <input type="number" name="eRecovered" size="45"
                            value="<c:out value='${p.recovered}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>underTreatment: </th>
                <td>
                    <input type="number" name="eUnderTreatment" size="45"
                            value="<c:out value='${p.underTreatment}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>date: </th>
                <td>
                    <input type="String" name="eDate" size="45"
                            value="<c:out value='${p.date}' />"
                    />
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
</body>
</html>