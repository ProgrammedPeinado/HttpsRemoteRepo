<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>FlyAway - flight booking</title>
    <link rel="stylesheet" type="text/css" href="index.css" media="all" />
</head>
<body>
    <div>
		<table class="banner">
		    <tr>
		        <th width=40%><img src="https://freepngimg.com/thumb/airplane/26315-7-airplane-transparent.png" width="240px" /></th>
		        <th width="20%">
		            <h1>FlyAway</h1>
		        </th>
		    </tr>
		</table>
	</div>
	<div>
	<table>
		<c:forEach var="flight" items="${flightList}">
		    <tr><c:forEach var="details" items="${flight}" >
		        <th><c:out value="${details}"/></th>		                             
		        </c:forEach>
		        <th><input href="checkout" type="submit" value="Book it!"/><br></th>
		    </tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>