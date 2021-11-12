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

<form action="/passwordChange" method="POST">
Enter old password: <input type="password" name="oldpass" value="Old Password"><br>
Enter new password: <input type="password" name="newpass" value="New Password"><br>
<input type="hidden" name="admin" value="${admin} }">
<input type="submit" value="Submit Changes">
</form>
</body>
</html>