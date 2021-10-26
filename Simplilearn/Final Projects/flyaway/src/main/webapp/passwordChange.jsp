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
	<h2>Admin password change</h2>
	</div>
	<div>
	<form action="passwordchange" method="POST">
	Enter old password: <input type="password" name="oldpass" value="Old Password"><br>
	Enter new password: <input type="password" name="newpass" value="New Password"><br>
	
	<input type="submit" value="Submit Changes">
	</form>
	</div>
	<%
    if(request.getAttribute("loginResult") != null && "true".equals(request.getAttribute("loginResult").toString()))
    {
	%>
 	<p style="color:red"> Login Failed. Please try again. </p>
	<%
	}	
	%>
	<br><br><a href="/flyaway">Book a flight and register as passenger</a>
	</div>
</body>
</html>