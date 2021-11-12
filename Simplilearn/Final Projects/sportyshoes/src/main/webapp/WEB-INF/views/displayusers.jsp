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
<div>
		<table>
		<tr>
			<c:forTokens items="${props}" delims="," var="prop">
				<td><h2><c:out value="${prop}"></c:out></h2></td>
			</c:forTokens>
		</tr>
		<c:forEach var="object" items="${List}" varStatus="loop">
			<tr>
				<c:forTokens items="${props}" delims="," var="prop">
				<td>${object[prop]}</td>
				</c:forTokens>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>