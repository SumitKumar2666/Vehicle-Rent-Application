<%@page import="com.ntt.domain.VehicleDetails"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
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
		ArrayList al = (ArrayList) request.getAttribute("searchvehData");

		%>
		<p>
		<%
			VehicleDetails vehD = (VehicleDetails) al.get(0);
		 %>
		Following are the matches with vehicle number <%=vehD.getVehicleNumber()%>:
		</p>
		<p align="center">
		<table border="1px" class="table table-bordered">
			<thead>
				<tr>
					<th>Vehicle Type</th>
					<th>Vehicle Name</th>
					<th>Booking Price</th>
					<th>Vehicle Number</th>
					<th>Discount</th>
					<th>Feedback</th>
					
				</tr>
			</thead>

			
			<%for (int i = 0; i < al.size(); i++) {%>
			
			<tr>
				<%
				VehicleDetails vehhD = (VehicleDetails) al.get(i);
				%>
				<td><%=vehhD.getVehicleType()%></td>
				<td><%=vehhD.getVehicleName()%></td>
				<td><%=vehhD.getVehicleBPrice()%></td>
				<td><%=vehhD.getVehicleNumber()%></td>
				<td><%=vehhD.getVehicleDiscount()%></td>
				<td><%=vehhD.getVehicleFeedback()%></td>
				
			</tr>
			<%}%>

		</table>
		<p>
		<br><br>
		<a href="CustomerDashboard.jsp">
			<button type="button" class="btn btn-primary btn-lg"> Dashboard </button>
		</a>
	</div>


</body>
</html>