<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.dto.Flight" %>
<%@ page import="com.DAO.FlightDaoImpl" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>FlyAway - flight booking</title>
    <link rel="stylesheet" type="text/css" href="index.css" media="all" />
</head>
<body>
    <div>
		<table class="banner">
		    <tr>
		        <th width=40%><img src="https://freepngimg.com/thumb/airplane/26315-7-airplane-transparent.png" width="240px" /></th>
		        <th width="20%">
		            <h1>FlyAway</h1>
		        </th>
		    </tr>
		</table>
	</div>
	<div>
	<p><form action=flightservlet method="POST"><input type="hidden" name="submittion" value="listAll"><input type=submit name="option1" value="List all flights"></form>
	<p><form action=flightservlet method="POST"><input type="hidden" name="submittion" value="listSources"><input type=submit name="option2" value="List all sources and destinations"></form>
	<p><form action=flightservlet method="POST"><input type="hidden" name="submittion" value="listAirlines"><input type=submit name="option3" value="List all airlines"></form>
	<br>
	<a href="/flyaway/passwordChange.jsp">Change password</a>
	</div>
</body>
</html>