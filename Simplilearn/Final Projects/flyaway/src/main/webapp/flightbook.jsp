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
	Flight#Source &emsp; Destination &emsp; Flight_date&emsp; Available_seats&emsp; Price&emsp; Select
	<c:forEach var="flight" items="${flightList}" varStatus="loop">
	    	<form action="validateflight" method="POST">
	    	<c:out value= "${flight.id}"/>&emsp;&emsp;
	    	<c:out value= "${flight.source}"/>&emsp;&emsp;
	    	<c:out value= "${flight.destination}"/>&emsp;&emsp;
	    	<c:out value= "${flight.date}"/>&emsp;&emsp;
	    	<c:out value= "${flight.seats}"/>&emsp;&emsp;
	    	<c:out value= "${flight.price}"/>&emsp;&emsp;
	    	<c:set var="index" value="${loop.count}" />
	    	<input type="hidden" value="${flight.id}" name="selection">
	    	<input type="submit" value="Book it!">
	    	</form>	    
	</c:forEach>
	</div>
</body>
</html>