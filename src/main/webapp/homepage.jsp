<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Books Listing</title>
<style>
table {
	overflow-y: auto;
	height: 50vh; 
}
thead th {
	position: sticky;
	top: 0;
}
</style>
</head>
<body class="bg-light">
<%if(session.getAttribute("authorized")==null){
		String redirectURL = "http://localhost:8080/authentication/logout.jsp";
	    response.sendRedirect(redirectURL);
	}
	else if(session.getAttribute("authorized").equals("false")){
		String redirectURL = "http://localhost:8080/authentication/logout.jsp";
	    response.sendRedirect(redirectURL);
	}
	%>
	
	<jsp:include page="Header.jsp" />
	<div class="container">
	<br>
	<fieldset class="border p-2">
		<legend class="w-auto medium">Books Listing</legend>
  			
				<form class="text-right" action="download" method=GET>
					<input class="btn btn-secondary col-sm-3 p-2 m-2" type="submit" value="Download Books" />
				</form>
				<form class="text-right" action="upload" method=GET>
					<input class="btn btn-secondary col-sm-3 p-2 m-2" type="submit" value="Add Book" />
				</form>

		    <div class="m-2 p-4">
			<table class=" table table-striped table-hover">
				<thead class="thead-light">
					<tr>
						<th>Book Code</th>
						<th>Book Name</th>
						<th>Author</th>
						<th>Date Added</th>
						<th colspan="2">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookDtos}" var="book">
						<tr>
							<td>${book.getCode()}</td>
							<td>${book.getName()}</td>
							<td>${book.getAuthor()}</td>
							<td>${book.getDoc()}</td>
							<td>
								<form action="edit" method="get">
									<input type="hidden" name="code" value="${book.getCode()}">
									<input class="btn btn-primary" type="submit" value="Update">
								</form>
							</td>
							<td>
								<form action="delete" method="get">
									<input type="hidden" name="code" value="${book.getCode()}">
									<input class="btn btn-danger" type="submit" value="Delete">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
	</fieldset>
	</div>
	<br><br>
	<jsp:include page="Footer.jsp" />
</body>
</html>