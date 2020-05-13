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
</body>
</html>