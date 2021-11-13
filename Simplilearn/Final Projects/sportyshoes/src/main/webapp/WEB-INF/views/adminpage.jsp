<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin Page</title>
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
	<h1>Adminstrator tools</h1>
	
	<h2>Product Management tools</h2>
	<form action="/addShoePage"><input type="submit" name="submission" value="Add Product"></form>
	<form action="/updateShoePage"><input type="submit" name="submission" value="Update Product"></form>
	<form action="/deleteShoePage"><input type="submit" name="submission" value="Delete Product"></form>
	<br>
	<h2>User Management tools</h2>
	<form action="/listUsers"><input type="submit" name="submission" value="List signed up users"></form>
	<form action="/searchUserPage"><input type="submit" name="submission" value="Search user by id"></form>
	<br>
	<h2>Transaction Management tools</h2>
	<form action="/getTransactions"><input type="submit" name="reports" value="See purchase reports"></form>
	<h2>Admin profile management</h2>
	<form action="/adminPassChangePage"><input type="submit" name="pass" value="Change password"></form>
	</div>
	
</body>
</html>