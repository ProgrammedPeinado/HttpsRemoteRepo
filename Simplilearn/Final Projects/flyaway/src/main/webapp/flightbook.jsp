<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


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
		
		<tr><th>Flight #</th><th>Source</th><th>Destination</th><th>Flight date</th><th>Available seats</th><th>Select</th>
		<c:forEach var="flight" items="${flightList}" varStatus="loop">
		    <tr>
		    	<td><c:out value= "${flight.id}"/></td>
		    	<td><c:out value= "${flight.source}"/></td>
		    	<td><c:out value= "${flight.destination}"/></td>
		    </tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>