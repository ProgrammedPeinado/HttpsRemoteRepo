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
	<h1>Update Shoe</h1>
	<p>We use tags to organize shoes so be mindful of what tag are you updating the shoe to.</p>
	<form action="/updateShoe">
	Specify the shoe's id <input type="text" name="id" value=""><br>
	Specify the new tag for the shoe <input type="text" name="tag" value=""><br>
	<input type="submit" value="Submit changes">
	</form>
	</div>
</body>
</html>