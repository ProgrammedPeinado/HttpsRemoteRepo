<%@page import="org.hibernate.internal.build.AllowSysOut"%>
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
	<h2>Please revise the details of your flight below</h2>
	<br>
	
	<table>
	<tr><th>Flight #</th><th>Source</th><th>Destination</th><th>Flight date</th><th>Available seats</th><th>Select</th>
		<c:set var="properties">id,source,destination,date,seats</c:set>
		<tr><c:forTokens var="prop" delims="," items="${properties}">
		<th><c:out value="${flight[prop]}"/></th>		                             
		</c:forTokens></tr>
	</table>
	<p><a href="confirmation">Confirm Payment</a></p>
	<br><br>

	</div>
</body>
</html>