<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h2>Passenger information</h2>
	<form action="validatepassenger" method="POST">
	<p>Firstname: <input type="text" name="firstname"value="Firstname"></p>
	<p>Lastname: <input type="text" name="lastname" value="Lastname"></p>
	<p>Purchased seats: <input type="text" name="seats" value="Number of seats purchased"></p>
	<input type="hidden" value="${selection}" name="submission"/>
	<p><input type="submit" value="Submit form" /></p>
	</form>
	</div>
</body>
</html>