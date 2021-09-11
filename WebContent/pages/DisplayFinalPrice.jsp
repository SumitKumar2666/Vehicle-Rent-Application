<%@page import="com.ntt.domain.VehicleDetails"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Final Price</title>
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
		ArrayList al = (ArrayList) request.getAttribute("viewFinalPriceData");

		%>
		<p>
		<%
			VehicleDetails vehD = (VehicleDetails) al.get(0);
		 %>
		Final price for vehicle number <%=vehD.getVehicleNumber()%>:
		</p>
		<p align="center">
		<table border="1px" class="table table-bordered">
			<thead>
				<tr>
					<th>Vehicle Number</th>
					<th>Vehicle Price</th>
					<th>Discount</th>
					<th>Final Price</th>
					
				</tr>
			</thead>

			
			<%for (int i = 0; i < al.size(); i++) {%>
			
			<tr>
				<%
				VehicleDetails vehhD = (VehicleDetails) al.get(i);
				
				%>
				<%double vehBPrice = vehhD.getVehicleBPrice();
					  double vehDisc = vehhD.getVehicleBPrice();
					  double vehFPrice = vehBPrice-vehDisc;
				%>
				<%
					double finalPrice =0;
					for(Object vDet: al) {
					String vNum = ((VehicleDetails) vDet).getVehicleNumber();
					double vBookingPrice = ((VehicleDetails) vDet).getVehicleBPrice();
					double vDisc = ((VehicleDetails) vDet).getVehicleDiscount();
					finalPrice = vBookingPrice - vDisc;
					
				} %>
				<td><%=vehhD.getVehicleNumber()%></td>
				<td><%=vehhD.getVehicleBPrice()%></td>
				<td><%=vehhD.getVehicleDiscount()%></td>
				<td><%=finalPrice%>
				<td>
				
			</tr>
			<%}%>

		</table>
		<p>
	</div>
</div>

</body>
</html>