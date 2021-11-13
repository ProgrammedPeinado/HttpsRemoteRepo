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
		<p>If you are already a registered user then you don't need to fill out this form again.</p>
		<form method="POST" action="addNewUser">
		<table>
		<tr><td>Firstname:</td><td><input type="text" value="" name="firstname"></td></tr>
		<tr><td>Lastname:</td><td><input type="text" value="" name="lastname"></td></tr>
		<tr><td>Phone number:</td><td><input type="text" value="" name="phoneNumber"></td></tr>
		<tr><td>Email:</td><td><input type="text" value="" name="email"></td></tr>
		<tr><td></td><td><input type="submit" value="Submit registration"></td></tr>
		</table>
		
		</form>
	</div>
</body>
</html>