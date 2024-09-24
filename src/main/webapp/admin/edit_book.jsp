<%@page import="com.entity.BookDtls"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.dao.Bookdaoimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Add Books</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Edit Books</h4>


						<%
						int id = Integer.parseInt(request.getParameter("id"));
						Bookdaoimpl dao = new Bookdaoimpl(DBconnect.getCon());
						BookDtls b = dao.getBookById(id);
						%>

						<form action="../editbook" method="post" >
							<input type="hidden" name="id" value="<%=b.getBookId()%>">

							<div class="form-group">
								<label for="exampleInputEmail">Book Name</label><input
									name="bname" type="text" class="form-control"
									id="exampleInputEmail" aria-describedby="emailHelp"
									value="<%=b.getBookName()%>">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail">Author Name</label><input
									name="author" type="text" class="form-control"
									id="exampleInputEmail" aria-describedby="emailHelp"
									value="<%=b.getAuthor()%>">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail">price</label><input name="price"
									type="number" class="form-control" id="exampleInputEmail"
									aria-describedby="emailHelp" value="<%=b.getPrice()%>">

							</div>
					</div>
					<div class="form-group">
						<label for="inputState">Book Status</label> <select
							id="inputState" name="status" class="form-control">

							<%
							if("Active".equals(b.getStatus())) {
							%>
							<option value="Active">Active</option>
							<option value="Inactive">Inactive</option>
 							<%
							} else {
							%>
							<option value="Inactive">Inactive</option>
							<option value="Active">Active</option>
							<%
							}
							%>


						</select>
					</div>
					<button type="submit" class="btn btn-primary">Update</button>
				</form>

			</div>
		</div>
	</div>
	</div>
	</div>

	<div style="margin-top: 130px;">
		<%@include file="footer.jsp"%></div>
</body>
</html>