<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User registration</title>
	<link rel="stylesheet" type="text/css" href="/style/style.css" media="all" />
</head>
<body>
	<div class="sidenav">
		<img src="/images/Sport_shoe.jpg" height=200px	width=200px>
		<a href="/home">Home</a>
		<a href="/addUser">User registration</a>
		<a href="/getShoes">Shoes!</a>
	</div>

<div class="content">
<h1>Search output:</h1>
<table>	
<tr><td>Firstname</td><td>Lastname</td><td>Phone</td><td>Email</td></tr>
<tr><td>${user.firstname}</td><td>${user.lastname}</td><td>${user.phoneNumber}</td><td>${user.email}</td></tr>
</table>
</div>
</body>
</html>