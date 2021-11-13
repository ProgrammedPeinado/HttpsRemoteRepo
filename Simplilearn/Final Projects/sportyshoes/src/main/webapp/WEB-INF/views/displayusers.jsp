<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin tools</title>
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
	<h1>List of current signed up users</h1>
		<table>
		<tr><td><h2>Firstname</h2></td><td><h2>Lastname</h2></td><td><h2>Email</h2></td></tr>
		
			<c:forEach items="${users}" var="prop">
				<tr><td><c:out value="${prop.firstname}"></c:out></td><td><c:out value="${prop.lastname}"></c:out></td><td><c:out value="${prop.email}"></c:out></td></tr>
			</c:forEach>
		
		</table>
	</div>
</body>
</html>