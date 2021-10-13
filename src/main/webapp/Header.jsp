<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<header>
	<nav class="navbar navbar-expand-sm bg-secondary navbar-dark">
	<br><br>
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="navbar-brand" href="#">LIBRARY MANAGEMENT</a></li>

			<%
				if (session.getAttribute("authorized") == "true") {
			%>
			<li class="nav-item "><a class="nav-link" href="homepage">HOME</a></li>
			
			<%
				}
			%>
		</ul>
		<ul class="navbar-nav">
			<%
				if (session.getAttribute("authorized") == "true") {
			%>
			<li class="nav-item "><a class="nav-link" href="Logout.jsp">Logout</a>
			</li>
			<%
				}
			%>
			<%
				if (session.getAttribute("authorized") != "true") {
			%>
			
			<li class="nav-item "><a class="nav-link" href="Login">Login</a>
			</li>
			<%
				}
			%>
		</ul>
		<br><br>
	</nav>
	
</header>
</body>
</html>