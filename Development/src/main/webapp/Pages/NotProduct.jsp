<%@page import="Controller.stateManagement.Session"%>
<%@page import="Controller.Dbconnection.Connections"%>
<%@page import="Model.product"%>
<%@page import="java.util.*"%>
<%@page import="Resources.MyConstants"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/Product.css" />
</head>
<body>
	<header>
		<!-- Consist of a search bar, filter drop box and title of the webpage along with go back and register button -->
		<h1>Product Store</h1>
		<br> 
		<form class="search-bar" action = "Product.jsp">
		<input type="text" name= "ProductName" id="search" placeholder="Search products..."> 
		<input type="submit" value="Search" />
        </form>
		
			<a href="${pageContext.request.contextPath}/Pages/Home.jsp">
			<button style="float: left; font-size: 30px;">Back</button>
			</a>
		
			<a href="${pageContext.request.contextPath}/Pages/Register.jsp">
			<button style="float: right; font-size: 30px;">Register Now</button>
			</a>

		<div class="small-container">
			<br>
			<div class="row row-2">

				<!-- <select>
					<option value="">Default Shorting</option>
					<option value="">Short by price</option>
					<option value="">Short by popularity</option>
					<option value="">Short by sale</option>
				</select> -->
				
				<!-- code to sort the product page with few given options -->
				<sql:setDataSource var="dbConnection" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/coursework" user="root" password="" />
				
				<sql:query var="highPrice" dataSource="${dbConnection}">
					SELECT * FROM product ORDER BY Price DESC;
				</sql:query>

				<c:set var="sortOption" value="${param.sortBy}" />
				<%-- <c:set var="searchTerm" value="${param.searchTerm}"/> --%>

				<sql:query var="product" dataSource="${dbConnection}">
					<c:choose>

						<c:when test="${sortOption == 'highPrice'}">
						SELECT * FROM product ORDER BY Price DESC;
						</c:when>
						
						<c:when test="${sortOption == 'Nike'}">
						SELECT * FROM product WHERE Brand = 'Nike';
						</c:when>

						<c:when test="${sortOption == 'KTM'}">
						SELECT * FROM product WHERE Brand = 'KTM';
						</c:when>

						<c:when test="${sortOption == 'PumaSE'}">
						SELECT * FROM product WHERE Brand = 'PumaSE';
						</c:when>
						
						<c:when test="${sortOption == 'Filla'}">
						SELECT * FROM product WHERE Brand = 'Filla';
						</c:when>
					
						<c:otherwise>
						SELECT * FROM product;
						</c:otherwise>
					
					</c:choose>
				</sql:query>
				
				
				<select onchange="location = this.value;">
					<option value="?sortBy=default"${sortOption=='default' ? 'selected' : ''}>Default</option>
					
					<option value="?sortBy=highPrice"${sortOption=='highPrice' ? 'selected' : ''}>Price</option>

					<option value="?sortBy=Nike" ${sortOption=='Nike' ? 'selected' : ''}>Brand-Nike</option>

					<option value="?sortBy=KTM"${sortOption=='KTM' ? 'selected' : ''}>Brand- KTM</option>

					<option value="?sortBy=PumaSE"${sortOption=='PumaSE' ? 'selected' : ''}>Brand- PumaSE</option>

					<option value="?sortBy=Filla"${sortOption=='Filla' ? 'selected' : ''}>Brand- Filla</option>
				</select>
			</div>
		</div>

	</header>
	<main>
			<!-- Code for search button -->
			<% String ProductName = request.getParameter("ProductName");%>
      			<!-- Database Connection using taglib directive -->
				<sql:setDataSource var="dbConnection" driver="com.mysql.jdbc.Driver"
					url="jdbc:mysql://localhost:3306/coursework" user="root"
					password="" />
				<sql:query var="products" dataSource="${dbConnection}">
          		SELECT * FROM product WHERE ProductName LIKE "%<%= ProductName %>%";
          		</sql:query>

		<!-- Database Connection using taglib directive -->
		<%-- <sql:setDataSource var="dbConnection" driver="com.mysql.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/coursework" user="root" password="" /> --%>
		<sql:query var="products" dataSource="${dbConnection}">
              SELECT  ProductName, Brand, Stock, Price, Image FROM product;
          </sql:query>
			
			<!-- Taking data from prodcut database -->
			<c:forEach var="product" items="${products.rows}">
			<div class="product-card">

				<img src="../Images/ProductImage/${product.image}" alt="Image">

				<h3>${product.ProductName}</h3>
				<br>
				<h3>Price: ${product.Price}</h3>
				<p>Brand: ${product.Brand}</p>
				<a href="${pageContext.request.contextPath}/Pages/Register.jsp">
				<button >Register to Buy</button>
				</a>
				


			</div>


		</c:forEach>

	</main>

</body>
</html>

