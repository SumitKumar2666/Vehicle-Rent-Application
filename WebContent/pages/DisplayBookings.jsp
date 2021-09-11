<%@page import="com.ntt.domain.BookingDetails"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Bookings</title>
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
		ArrayList alist = (ArrayList) request.getAttribute("bookingdata");
		%>
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

			
			<%for (int i = 0; i < alist.size(); i++) {%>
			
			<tr>
				<%
				BookingDetails bookD = (BookingDetails) alist.get(i);
				%>
				<td><%=bookD.getVehicleNumber()%></td>
				<td><%=bookD.getVehiclePrice()%></td>
				<td><%=bookD.getDiscount()%></td>
				<td><%=bookD.getFinalPrice()%></td>
				
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