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
		<table>
		<c:forEach var="entry" items="${shoes}">
			<tr>
			<td>${entry.key}</td><td>${entry.value.shoe_name}</td><td>${entry.value.thumbnail}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>