<%@page import="Controller.stateManagement.Session"%>
<%@page import="Controller.Dbconnection.Connections"%>
<%@page import= "Model.product" %>
<%@page import="java.util.*"%>
<%@page import="Resources.MyConstants"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Admin Page - Add Product</title>
 <!--  CSS for admin page -->
  <style>
    body {
      background-color: #2089e6;
    }
    
    .center-box {
      /* margin-top: 300px; */
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .form-box {
     /*  padding: 30px;  */
      margin:auto;
      background-color: #f2f2f2;
      border-radius: 10px;
    }
    form{
    margin-left:220px;
    }
    form label {
      display: block;
      margin-bottom: 10px;
    }

    img{
    width:150px;
    height:150px;
    }
  </style>
</head>
<body>
  <nav>
  
  	<!-- Add product part for admin -->
    
    <button onclick="location.href='login.html'" style="position: absolute; top: 20px; right: 20px;">Logout</button>
  </nav>
  <div class="center-box">
    <div class="form-box"><br>
    <br>
    <br>
      <h1 align=center>Add Product</h1>
      <form  method ="post" action ="${pageContext.request.contextPath}/Product" method="post" enctype = 'multipart/form-data'>
        <label>Product Name:</label>
        <input type="text" name="ProductName"><br><br>

        <label>Brand Name:</label>
        <input type="text" name="Brand"><br><br>

        <label>Stock:</label>
        <input type="number" name="Stock"><br><br>

        <label>Price:</label>
        <input type="number" name="Price"><br><br>

        <label for="image">Image:</label>
        <input type="file" name="Image"><br><br>

        <div class="add-button">
          <input type="submit" value="Add">
        </div>
      </form>
      
      <br><hr><br>
      
      <!-- View Product page section for admin -->
      
      <h2 align=center>View Products</h2>
      
      <sql:setDataSource var="dbConnection" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/coursework" user="root" password="" />
      
      <sql:query var="products" dataSource="${dbConnection}">
       		SELECT  ProductName, Brand, Stock, Price, Image FROM product;
      </sql:query>
      <!-- Displaying from the database -->
      	<table>
			<thead>
				<tr>
					<th>Name--------</th>
		            <th>Brand--------</th>
		            <th>Price--------</th>
		            <th>Stock--------</th>
		            <th>Product Image</th>
		            <th>Edit</th>
		            <th>Delete</th>
				</tr>
			</thead>
			
			<c:forEach var="product" items="${products.rows}">
						
			<tbody>
				<tr>					
					<td><c:out value="${product.ProductName}" /></td>
					<td><c:out value="${product.Brand}" /></td>
					<td><c:out value="${product.Price}" /></td>
					<td><c:out value="${product.Stock}" /></td>
					
					<td><img src="<%=request.getContextPath()%>/Images/ProductImage/${product.Image}" alt="ProductImage" /></td>
					
		            <td>
		            <a href="${pageContext.request.contextPath}/Pages/EditProduct.jsp">
		            <button onclick="editProduct(2)">Edit</button>
		            </a>
		            </td>
		            <td>
		             <a href="${pageContext.request.contextPath}/Pages/DeleteProduct.jsp">
		            <button class="del" onclick="deleteProduct(2)">Delete</button>
		            </a>
		            </td>
				
				</tr>
			</tbody>
	</c:forEach>
		</table>
      
      
      <!-- Displaying from the database -->
      
      <hr />
      <h2 align=center>View Orders</h2>
      <sql:setDataSource var="dbConnection" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/coursework" user="root" password="" />
      
      <sql:query var="cart" dataSource="${dbConnection}">
       		SELECT  cart_id, Email, Product_Name FROM cart;
      </sql:query>
      <table>
        <thead>
          <tr>
            <th>Cart ID</th>
            <th>Email</th>
            <th>Product_Name</th>
          </tr>
        </thead>
        
        <c:forEach var="cart" items="${cart.rows}">
        
        <tbody>
          <tr>
            <td><c:out value="${cart.cart_id}" /></td>
            <td> <c:out value="${cart.Email}" /></td>
            <td><c:out value="${cart.Product_Name}" /> </td>

          </tr>
          
        </tbody>
        </c:forEach>
          
         
        </tbody>
    </table>
      </div>
  </div>
</body>
</html>