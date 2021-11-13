<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin login</title>
	<link rel="stylesheet" type="text/css" href="/style/style.css" media="all" />
</head>
<body>
	<div class="sidenav">
		<img src="/images/Sport_shoe.jpg" height=200px	width=200px>
		<a href="/home">Home</a>
		<a href="/addUser">User registration</a>
		<a href="/getShoes">Shoes!</a>
	</div>
	<div class ="content">
	<h1>Admin login</h1>
	<form action="/authenticate" method="POST">
	Username: <input type="text" name="user" value=""><br>
	Password: <input type="password" name="pass" value="">
	<input type="submit" value="Submit form" />	
	</form>
	</div>
</body>
</html>