<%@page import="com.entity.User"%>
<%@page import="com.entity.BookDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Bookdaoimpl"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOKS: index</title>
<%@include file="all-component/allCss.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/b.jpg");
	height: 60vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
}

.crd.ho:hover {
	background-color: #ffccd9;
}
</style>
</head>
<body style="background-color: #ccffff">
<%
User u=(User)session.getAttribute("userobj");

%>


	<%@include file="all-component/navbar.jsp"%>
	<div class="container-fluid back-img">
		<h2 class="text-left">CODING BOOK STORE</h2>
	</div>


	<!-- Start new book -->

	<div class="container">
		<h3 class="text-center">ALL BOOKS</h3>
		<div class="row">
			<%
			Bookdaoimpl dao = new Bookdaoimpl(DBconnect.getCon());
			List<BookDtls> list = dao.getNewBook();
			for (BookDtls b : list) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-3">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhotoName()%>"
							style="width: 100pxx; height: 150px">
						<p><%=b.getBookName()%></p>
						<p><%=b.getAuthor()%></p>
						<p>
							Categories:<%=b.getBookCategory()%></p>
						<div class="row">
						
						<%
						if( u == null)
							{%>
							
							<a href="login.jsp" class="btn btn-danger btn-sm ml-2">Add Cart</a>
							<%
							} else{
							%>
							<a href="cart?bid=<%=b.getBookId()%>&&uid=<%=u.getId()%>" class="btn btn-danger btn-sm ml-2">Add Cart</a>
							<%
							}
							%>
							
							 <a href="view_books.jsp?bid=<%=b.getBookId()
								%>" class="btn btn-success btn-sm ml-1">View Details</a>
								
								 <a href=" " class="btn btn-danger btn-sm ml-1"><%=b.getPrice()%>
								<i class="fas fa-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>






	<!--  <div class="text-center mt-2">
		<a href="" class="btn btn-danger btn-sm text-white">View All</a>
	</div>
	</div>-->
	<!-- End new book -->



	<%@include file="all-component/footer.jsp"%>
</body>
</html>