<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<FORM action="${pageContext.request.contextPath}/delProduct" method="post">

	<input type ="hidden" name ="method" value = "update">

	Delete

	

	<div class="label">Product Name:</div>

	<div class="control"><input type="text" name="Product_Name" id="Email"/></div>

	
	

	
	<div id="login_footer">
	
	<script type="text/javascript">

	function closewindow() {

	window.close()

	}

	</script>

	<label>
	<br>

	<input type="submit" value="Delete" />

	</label>

	</div>

</form>

</body>
</html>







