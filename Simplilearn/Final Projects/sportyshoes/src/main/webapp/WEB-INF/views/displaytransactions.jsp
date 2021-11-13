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
	<h1>List of transactions</h1>
		<table>
		<tr><td><h2>Buyer ID</h2></td><td><h2>Product ID</h2></td><td><h2>Category</h2></td><td><h2>Transaction date</h2></td></tr>
		
			<c:forEach items="${transactions}" var="prop">
				<tr><td><c:out value="${prop.buyer_id}"></c:out></td><td><c:out value="${prop.product_id}"></c:out></td><td><c:out value="${prop.category}"></c:out></td><td><c:out value="${prop.transaction_date}"></c:out></td></tr>
			</c:forEach>
		
		</table>
	</div>
</body>
</html>