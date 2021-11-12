<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		
		<h1>User registration</h1>
		<form method="POST" action="addNewUser">
		Firstname:<input type="text" value="" name="firstname"><br>
		Lastname:<input type="text" value="" name="lastname"><br>
		Phone number:<input type="text" value="" name="phoneNumber"><br>
		Email:<input type="text" value="" name="email"><br>
		<input type="submit" value="Submit registration">
		</form>
		
	</div>
</body>
</html>