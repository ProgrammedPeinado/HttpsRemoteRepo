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
	<form action="AdminServlet" method="POST">
	Username: <input type="text" name="user" value="username">
	Password: <input type="text" name="pass" value="password">
	<input type="submit" value="Submit form" />	
	</form>
	</div>
	<%
    if(request.getAttribute("loginResult") != null && request.getAttribute("loginResult") == "true"){
	%>
 	<p style="color:red"> Login Failed. Please try again. </p>
	<%
	}	
	%>
	<br><br><a href="/flyaway">Book a flight and register as passenger</a>
</body>
</html>