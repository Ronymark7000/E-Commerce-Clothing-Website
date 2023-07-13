<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Sign Up | By Code Info</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/style.css"/>
  </head>
  
  <body>
    <div class="login-box">
      <h1>Login</h1>
      <!-- the below code takes the email and password of the user. -->
      <form action="${pageContext.request.contextPath}/Login" method="post">
        <label>Email</label>
        <input type="email"  name="Email" placeholder="" />
        
        <label>Password</label>
        <input type="password" name="Password" placeholder="" />
        
        <input type="submit" style="margin-top: 1.001rem;"  value="Submit" />
      </form>
      
    </div>
    <!-- if the user does not register than below button redirect the webpage to  Register page -->
    <p class="para-2">
      Create an new account? <a href="${pageContext.request.contextPath}/Pages/Register.jsp">Sign Up Here</a>
      <br>
    	<br>
    	<!-- the user can directly visti the home page fro the below button -->
    	Home page Click me !!! <a href="${pageContext.request.contextPath}/Pages/NotHomepage.jsp">Home Page</a>
    </p>
    
    
  </body>
</html>
