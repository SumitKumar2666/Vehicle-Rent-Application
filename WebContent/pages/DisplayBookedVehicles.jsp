<%@page import="com.ntt.domain.VehicleDetails"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booked Vehicles</title>
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
		ArrayList al = (ArrayList) request.getAttribute("property");
		%>
		<p align="center">
		<table border="1px" class="table table-bordered">
			<thead>
				<tr>
					<th>Vehicle Type</th>
					<th>Vehicle Name</th>
					<th>Booking Price</th>
					<th>Vehicle Number</th>
					<th>Discount</th>
					
					
				</tr>
			</thead>

			
			<%for (int i = 0; i < al.size(); i++) {%>
			
			<tr>
				<%
				VehicleDetails vehD = (VehicleDetails) al.get(i);
				%>
				<td><%=vehD.getVehicleType()%></td>
				<td><%=vehD.getVehicleName()%></td>
				<td><%=vehD.getVehicleBPrice()%></td>
				<td><%=vehD.getVehicleNumber()%></td>
				<td><%=vehD.getVehicleDiscount()%></td>
				
				
			</tr>
			<%}%>

		</table>
		<p>
		<br><br>
		<a href="CustomerDashboard.jsp">
			<button type="button" class="btn btn-primary btn-lg"> Dashboard </button>
		</a>
	</div>
</div>

</body>
</html>