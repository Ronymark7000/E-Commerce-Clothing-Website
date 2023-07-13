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

	Change updates

	<div id="form_val">

	<div class="label">Product Name:</div>

	<div class="control"><input type="text" name="Product_Name" id="Email"/></div>

	<div id="form_val">

	<div class="label">Product Price:</div>

	<div class="control"><input type="number" name="price" id="Email"/></div>
	
	<div class="label">Product Stock:</div>

	<div class="control"><input type="text" name="stock" id="Email"/></div>

	<div id="msgbox"></div>

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

	<input type="submit" value="Update" />

	</label>

	</div>

</form>

</body>
</html>







