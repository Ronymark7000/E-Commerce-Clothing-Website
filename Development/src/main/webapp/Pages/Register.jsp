<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Sign Up | By Code Info</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/style.css"/>
  </head>
  
  <body>
    <div class="signup-box">
      <h1>Sign Up</h1>
      <h4>It's free and only takes a minute</h4>
      
     <!--  The following code acquries all the required data from the user -->
     
      <form method ="post" action ="${pageContext.request.contextPath}/Register" id ="one_1" enctype="multipart/form-data">
       
        <label>First Name</label>
        <input type="text"  name="FirstName" placeholder="" />
        
        <label>Last Name</label>
        <input type="text" name="LastName" placeholder="" />
        
        <label>Phone number</label>
        <input type="number" name="Number" required placeholder="Phone number"/>
        
        <label>Email</label>
        <input class="input" type="email" name="Email" placeholder="Email" required>
        
        <label>Password</label>
        <input type="password" name="Password" placeholder="" />
        
        <label>Role</label>
        <input type="text" name="Role" placeholder="" />
        
        <label for="image">Profile Picture</label>
        <input type="file" name="Image" accept="image/*" required>
        
        <!-- this input is a button which helps to submit the value to the database. -->

        <input type="submit" style="margin-top: 1.899rem;" class="button" value="Submit">
        
     	</form>
      	
      	<p>By clicking the Sign Up button,you agree to our <br />
        <a href="#">Terms and Condition</a> and <a href="#">Policy Privacy</a>
      	</p>
    </div>
    
    	<!-- this button leads to the login page -->
    	<p class="para-2">
      	Already have an account? <a href="${pageContext.request.contextPath}/Pages/Login.jsp">Login here</a>
    	</p>
    
  </body>
</html>