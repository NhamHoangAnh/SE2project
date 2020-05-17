<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h3><a href="${pageContext.request.contextPath}/provinces?insert=1">Add A New Province Statistics</a></h3>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
    	<form action="" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Country
                </h2>
            </caption>>           
            <tr>
                <th>Country: </th>
                <td>
                    <input type="text" name="iCountry" size="45"/>
                </td>
            </tr>
            <tr>
                <th>New Confirmed: </th>
                <td>
                    <input type="number" name="iNewConfirmed" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Total Confirmed </th>
                <td>
                    <input type="number" name="iTotalConfirmed" size="45" />
                </td>
            </tr>
            <tr>
                <th>New Death: </th>
                <td>
                    <input type="number" name="iNewDeaths" size="45" />
                </td>
            </tr>
            <tr>
                <th>Total Deaths: </th>
                <td>
                    <input type="number" name="iTotalDeaths" size="45" />
                </td>
            </tr>
            
            <tr>
                <th>New Recovered: </th>
                <td>
                    <input type="number" name="iNewRecovered" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Total Recovered: </th>
                <td>
                    <input type="number" name="iTotalRecovered" size="45"/>
                </td>
            </tr>
            
            <tr>
                <th>date: </th>
                <td>
                    <input type="text" name="iDate" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Country Code: </th>
                <td>
                    <input type="text" name="iCountryCode" size="45"/>
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