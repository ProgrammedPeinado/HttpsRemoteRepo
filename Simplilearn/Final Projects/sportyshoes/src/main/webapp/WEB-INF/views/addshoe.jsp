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
	<h1>Add new shoe:</h1>
	<form action="/addShoe">
	Shoe's name: <input type="text" name="name" value=""><br>
	Shoe's category: <input type="text" name="tag" value=""><br>
	Shoe's thumbnail: <input type="text" name="thumbnail" value=""><br>
	<input type="hidden" name="submission" value="add">
	<input type="submit" value="Submit inputs">
	</form>
	</div>
</body>
</html>