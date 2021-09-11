<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration</title>
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
<body>
<h2 align="center">Register</h2>
<form action="register.do">
<div class="center">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<td>User Id</td>
		<td><input type="text" name="user_id"></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="text" name="password"></td>
	</tr>
	<tr>
		<td>City</td>
		<td><input type="text" name="city"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>Contact Number</td>
		<td><input type="text" name="contact_no"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="Register"><input type="reset"
			value="Clear"></td>
	</tr>
</table>
</div>
</form>

</body>
</html>