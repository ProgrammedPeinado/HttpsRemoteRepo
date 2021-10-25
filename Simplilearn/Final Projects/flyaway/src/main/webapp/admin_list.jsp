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