<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MY WOSA PASAL</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/Home.css"/>
	<!-- CSS for not home page -->
	<style>
        #products {
            display: flex;
            justify-content: space-between;
        }

        .product {
            display: inline-block;
            width: 30%;
            text-align: center;
        }

        .product img {
            width: 100%;
            height: auto;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <header>
        <h1>MY WOSA PASAL</h1>
        <nav>
            <ul>
            <!-- Links for all the navigation bar -->
                <li><a href="${pageContext.request.contextPath}/Pages/Home.jsp">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/Pages/Product.jsp">Product</a></li>
                <li><a href="${pageContext.request.contextPath}/Pages/AddToCart.jsp">Add Cart</a></li>
                <li><a href="${pageContext.request.contextPath}/Pages/User.jsp">Profile</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section id="hero" style="background-color: #35b1c4;">
        	<!-- Welcome part of the webpage -->
            <h2>Welcome to our store!</h2>
            <p>Shop the latest fashion trends with us!</p>
            <!-- this redirects the page to  -->
            <a href="#" class="btn">View Shop</a>
        </section>

		<!-- This is a short brief of the product available -->
        <section id="products">
            <h2>Featured Products</h2>
            <div class="product">
                <img src="${pageContext.request.contextPath}/Images/product1.png" alt="Deerhunter Jacket">
                <h3>Deerhunter T-shirt</h3>
                <p>Only Deerhunter T-shirt in Nepal.</p>
                <a href="${pageContext.request.contextPath}/Pages/Product.jsp" class="btn">View Shop</a>
            </div>

            <div class="product">
                <img src="${pageContext.request.contextPath}/Images/product2.png" alt="Blue Hunter T-shirt">
                <h3>Blue Hunter T-shirt</h3>
                <p>Only Blue Hunter T-shirt in Nepal.</p>
                <a href="${pageContext.request.contextPath}/Pages/Product.jsp" class="btn">View Shop</a>
            </div>
            <div class="product">
                <img src="${pageContext.request.contextPath}/Images/product1.png" alt="Corduroy Shirt">
                <h3>Cotton Corduroy Shirt</h3>
                <p>100% Corduroy Shirt Available Now.</p>
                <a href="${pageContext.request.contextPath}/Pages/Product.jsp" class="btn">View Shop</a>
            </div>
        </section>
    </main>

    <footer>
        <p>&copy; 2023 MY WOSA PASAL. All Rights Reserved.</p>
    </footer>
</body>
</html>



