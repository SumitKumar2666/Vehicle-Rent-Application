<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
body {
  background-image: url('../pictures/login.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
.center {
  margin: 0;
  position: absolute;
  top: 30%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
</head>
<script>
function myFunction() {
  var x = document.getElementById("pass");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
<body>

<form action="login.do" method="post">
<div class="center">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	
		<td>User Id</td>
		<td><input type="text" name="user_id"></td>
	
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" id="pass"></td>
	</tr>
	<!-- An element to toggle between password visibility -->
	<tr>
		<td><input type="checkbox" onclick="myFunction()">Show Password</td>
	</tr>
	
	
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="Login"><input type="reset" value="Clear"></td>
	</tr>
	
</table>
</div>
</form>


</body>
</html>