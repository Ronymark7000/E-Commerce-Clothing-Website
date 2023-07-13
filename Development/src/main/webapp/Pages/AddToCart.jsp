<%@page import="Controller.Dbconnection.Connections" %>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add to Cart Page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/Cart.css"/>
</head>
<body>

	<!-- taking product data from the database and displayin it in the current webpage -->
	<a href="${pageContext.request.contextPath}/Pages/Home.jsp"> 
    	<button style="float: left; font-size: 30px;">Back</button>
    </a>
	<h1>Add to Cart Page</h1>
	<div class="product">
		<img src="product1.jpg" alt="Product Image">
		<h2>Product Name</h2>
		<p>Description of the product.</p>
		<p>Price: $19.99</p>
		<button onclick="showMessage()">Checkout</button>

<!-- JavaScript for checkout -->
<script>
function showMessage() {
  alert("Thank you for your purchase!");
}
</script>
	</div>

</body>
</html>


