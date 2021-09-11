<%@page import="com.ntt.domain.VehicleDetails"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
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
</head>
<body>
<div class="center">
<div>
		<%
		ArrayList al = (ArrayList) request.getAttribute("feed");

		%>
		<p align="center">
		<table border="1px" class="table table-bordered">
			<thead>
				<tr><%
				VehicleDetails vehD = (VehicleDetails) al.get(0);
				 %>	<th>Feedback for Vehicle Number <%=vehD.getVehicleNumber()%> is:</th>
					
				</tr>
			</thead>

			
			<%for (int i = 0; i < al.size(); i++) {%>
			
			<tr>
				<%
				VehicleDetails vehDD = (VehicleDetails) al.get(i);
				%>
				<td><%=vehDD.getVehicleFeedback()%></td>
				
				
			</tr>
			<%}%>

		</table>
		<p>
		<br><br>
		<a href="AdminDashboard.jsp">
			<button type="button" class="btn btn-primary btn-lg"> Dashboard </button>
		</a>
	</div>
</div>

</body>
</html>