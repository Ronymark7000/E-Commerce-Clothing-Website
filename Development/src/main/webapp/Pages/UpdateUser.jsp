<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

<style type="text/css">

.head{

background-color: #080710;

}

.head title{

font-size: 32px;

font-weight: 500;

line-height: 42px;

text-align: center;

}

body{

background-color: #080710;

}

.one{

width: 430px;

height: 520px;

position: absolute;

transform: translate(-50%,-50%);

left: 50%;

top: 50%;

}

.one .headings{

height: 200px;

width: 200px;

position: absolute;

border-radius: 50%;

}

.shape:first-child{

background: linear-gradient(

#1845ad,

#23a2f6

);

left: -80px;

top: -80px;

}

.shape:last-child{

background: linear-gradient(

to right,

#ff512f,

#f09819

);

right: -30px;

bottom: -80px;

}

form{

height: 520px;

width: 400px;

background-color: rgba(255,255,255,0.13);

position: absolute;

transform: translate(-50%,-50%);

top: 50%;

left: 50%;

border-radius: 10px;

backdrop-filter: blur(10px);

border: 2px solid rgba(255,255,255,0.1);

box-shadow: 0 0 40px rgba(8,7,16,0.6);

padding: 50px 35px;

}

form *{

font-family: 'Poppins',sans-serif;

color: #ffffff;

letter-spacing: 0.5px;

outline: none;

border: none;

}

form label{

font-size: 32px;

font-weight: 500;

line-height: 42px;

text-align: center;

}

label{

display: block;

margin-top: 30px;

font-size: 16px;

font-weight: 500;

}

input{

display: block;

height: 50px;

width: 100%;

background-color: rgba(255,255,255,0.07);

border-radius: 3px;

padding: 0 10px;

margin-top: 8px;

font-size: 14px;

font-weight: 300;

}

::placeholder{

color: #e5e5e5;

}

button{

margin-top: 50px;

width: 100%;

background-color: #ffffff;

color: #080710;

padding: 15px 0;

font-size: 18px;

font-weight: 600;

border-radius: 5px;

cursor: pointer;

}

#login_header

{

font-size: 20.5 em;

text-align:center;

}

</style>

</head>

<body>

<FORM action="${pageContext.request.contextPath}/UpdateUser" method="post">

<input type ="hidden" name ="method" value = "update">

<div id="login_box">

<div id="login_header">

Change updates

</div>

<div id="form_val">

<div class="label">First Name:</div>

<div class="control"><input type="text" name="FirstName" id="Email"/></div>


<div class="label">Last Name:</div>

<div class="control"><input type="text" name="LastName" id="Email"/></div>


<div class="label">Number:</div>

<div class="control"><input type="text" name="Number" id="Email"/></div>


<div class="label">Email:</div>

<div class="control"><input type="text" name="Email" id="Email"/></div>


<div class="label">Password:</div>

<div class="control"><input type="password" name="newPassword" id="Password"/></div>

</div>

<div id="msgbox"></div>

</div>

<div id="login_footer">

<script type="text/javascript">

function closewindow() {

window.close()

}

</script>

<label>
<a href="${pageContext.request.contextPath}/Pages/Home.jsp" >

<input type="submit" value="Update" />
</a>

</label>

</div>



</FORM>

</body>

</html>