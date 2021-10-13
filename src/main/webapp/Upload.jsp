<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book Details</title>
</head>
<body class="bg-light">
<%if(session.getAttribute("authorized")==null){
		String redirectURL = "http://localhost:8080/authentication/Logout.jsp";
	    response.sendRedirect(redirectURL);
	}
	else if(session.getAttribute("authorized").equals("false")){
		String redirectURL = "http://localhost:8080/authentication/Logout.jsp";
	    response.sendRedirect(redirectURL);
	}
	%>
	<jsp:include page="Header.jsp" />
	<div class="container">
	<br>
	<fieldset class="border p-2">
		<legend class="w-auto medium">Add BookDetails</legend>
		<div class="text-center">
			<form class=" m-5 p-5" action="upload" method="post">
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="code">Code
					</label>
					<div class="col-sm-10">
						<input type="text" name="code" id="code"
							placeholder="code" class="form-control" required>
					</div>
				</div>
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="name">Name
					</label>
					<div class="col-sm-10">
						<input type="text" name="name" id="name"
							placeholder="name" class="form-control" required>
					</div>
				</div>
				
				
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="author">Author
					</label>
					<div class="col-sm-10">
						<input type="text" name="author" id="author"
							placeholder="Select" class="form-control" required>
					</div>
				</div>
				
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="doc">Date 
					</label>
					<div class="col-sm-10">
						<input type="date" name="doc" id="doc"
							placeholder="doc" class="form-control" required>
					</div>
				</div>
				
				<br /> 
				<input class="btn btn-primary col-sm-4 p-2 m-2" type="submit"
					value="Upload">
				<a class="btn btn-danger col-sm-4 p-2 m-2"	href="homepage">Cancel</a>
			</form>
		</div>
		</fieldset>
	</div>
	<br><br>
	<jsp:include page="Footer.jsp" />
</body>
</html>