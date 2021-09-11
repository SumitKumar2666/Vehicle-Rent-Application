<%@page import="com.ntt.domain.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successful Registration</title>
</head>
<style>
.center {
  margin: 0;
  position: absolute;
  top: 30%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
<body>
<div class="center">
<font color="green" size="20">${requestScope.success }</font>
<h3>Welcome ${requestScope.details.uid }</h3>
<h4>Please note your password for further use:
${requestScope.details.upassword }</h4>


<span><a href="Homepage.jsp">Click here </a> for Homepage</span>
</div>

</body>
</html>