<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Logout</title>
</head>
<body class="bg-light">
	<jsp:include page="Header.jsp" />
	<br/>
	<div class="container">
	<%
		session.removeAttribute("authorized");
		session.removeAttribute("error");
		String redirectURL = "http://localhost:8080/authentication/login";
	    response.sendRedirect(redirectURL); 
	%>
	<p>You Have Logged Out Successfully
	<a href="login"> Login here </a></p>
</div>
<br><br>
	<jsp:include page="Footer.jsp" />
</body>
</html>