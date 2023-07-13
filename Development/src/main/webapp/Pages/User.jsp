<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
	 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/User.css"/>
</head>
<body>
	<h1>Welcome Back, </h1>
	 <sql:setDataSource var="dbConnection" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/coursework" user="root" password="" />
	<c:forEach var="register" items="${register.rows}">
	<div class="user-info">
		<!-- taking user information formt he current logged in session form the database -->
		<img class="profile-pic" src="john.png" alt="Profile Picture">
		<p><span>First Name:</span> <c:out value="${register.FirstName}" /></p>
		<p><span>Last Name:</span> <c:out value="${register.LastName}" /></p>
		<p><span>Number</span> <c:out value="${register.Number}" /></p>
		<p><span>Email:</span><c:out value="${register.Email}" /></p>
		<p><span>Phone:</span> <c:out value="${register.Number}" /></p>
		<p><span>User Type:</span> User</p>
	</div>
	</c:forEach>
	<a href="${pageContext.request.contextPath}/Pages/UpdateUser.jsp"><button >Edit Details</button></a>

	<a href="${pageContext.request.contextPath}/Pages/Login.jsp"><button>Logout</button> </a>

	<script src="java.js"></script>
</body>
</html>

