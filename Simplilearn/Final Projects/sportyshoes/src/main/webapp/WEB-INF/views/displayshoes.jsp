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
	<h1>Shoe selection</h1>
		<table>
		<c:forEach var="entry" items="${shoes}">
			<tr>
			<td>Category: ${entry.key}</td>
			<c:forEach var="value" items="${entry.value}">
			<tr>
				<td>Model: ${value.shoe_name}</td>
				<td><img src="/images/${value.thumbnail}" height=200px	width=200px></td>
			<tr>
			</c:forEach>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>