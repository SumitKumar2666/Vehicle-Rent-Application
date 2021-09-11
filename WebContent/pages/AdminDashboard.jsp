<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
function openAddDiscForm() {
	  document.getElementById("formAddDiscount").style.display = "block";
	  document.getElementById("adddiscbtn").style.display = "none";
	  document.getElementById("op1").style.display = "none";
	  document.getElementById("op2").style.display = "none";
	  document.getElementById("op4").style.display = "none";
	  document.getElementById("op5").style.display = "none";
	}
function closeAddDiscForm() {
	  document.getElementById("formAddDiscount").style.display = "none";
	  document.getElementById("adddiscbtn").style.display = "block";
	  document.getElementById("op1").style.display = "block";
	  document.getElementById("op2").style.display = "block";
	  document.getElementById("op4").style.display = "block";
	  document.getElementById("op5").style.display = "block";
	}
function openAddVehForm() {
	  document.getElementById("formAddVehicle").style.display = "block";
	  document.getElementById("addvehbtn").style.display = "none";
	  document.getElementById("op2").style.display = "none";
	  document.getElementById("op3").style.display = "none";
	  document.getElementById("op4").style.display = "none";
	  document.getElementById("op5").style.display = "none";
	}
function closeAddVehForm() {
	  document.getElementById("formAddVehicle").style.display = "none";
	  document.getElementById("addvehbtn").style.display = "block";
	  document.getElementById("op2").style.display = "block";
	  document.getElementById("op3").style.display = "block";
	  document.getElementById("op4").style.display = "block";
	  document.getElementById("op5").style.display = "block";
	}
function openViewFeedbackForm() {
	  document.getElementById("formViewFeedback").style.display = "block";
	  document.getElementById("viewfeedbackbtn").style.display = "none";
	  document.getElementById("op1").style.display = "none";
	  document.getElementById("op2").style.display = "none";
	  document.getElementById("op3").style.display = "none";
	  document.getElementById("op4").style.display = "none";
	}
function closeViewFeedbackForm() {
	  document.getElementById("formViewFeedback").style.display = "none";
	  document.getElementById("viewfeedbackbtn").style.display = "block";
	  document.getElementById("op1").style.display = "block";
	  document.getElementById("op2").style.display = "block";
	  document.getElementById("op3").style.display = "block";
	  document.getElementById("op4").style.display = "block";
	}

</script>
<style>
body {
background-color: powderblue;
background-image: url('../pictures/dashboard.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
.center1 {
  margin: 0;
  position: absolute;
  top: 30%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.center2 {
  margin: 0;
  position: absolute;
  top: 40%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.center3 {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.center4 {
  margin: 0;
  position: absolute;
  top: 60%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.center5 {
  margin: 0;
  position: absolute;
  top: 70%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
.bottomleft {

margin: 0;
  position: absolute;
  top: 90%;
  left: 10%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);

}
.container { 
  height: 200px;
  position: relative;
  border: 3px solid green; 
}
/* Add styles to the form container */
.form-container {
  max-width: 1000px;
  padding: 100px;
  
  background-color: white;
}
/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: center;
  
  border: 3px solid #f1f1f1;
  z-index: 9;
}
.glow {
  font-size: 30px;
  color: #FF7F50;
  text-align: center;
  animation: glow 1s ease-in-out infinite alternate;
}
@-webkit-keyframes glow {
  from {
    text-shadow: 0 0 10px black, 0 0 20px #fff, 0 0 30px #e60073, 0 0 40px #e60073, 0 0 50px #e60073, 0 0 60px #e60073, 0 0 70px #e60073;
  }
  
  to {
    text-shadow: 0 0 20px #fff, 0 0 30px #ff4da6, 0 0 40px #ff4da6, 0 0 50px #ff4da6, 0 0 60px #ff4da6, 0 0 70px #ff4da6, 0 0 80px #ff4da6;
  }
}
</style>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>

<meta charset='utf-8'>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<h2 align="center" class="glow">Welcome to Admin Dashboard</h2><hr>

	<table>
	
	<tr>
		<td colspan="2">
			<c:if test="${requestScope.adminmsg!=null}">
			<font color="green">${requestScope.adminmsg}</font>
			</c:if>
			
			
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${requestScope.erradminmsg!=null}">
			<font color="red">${requestScope.erradminmsg}</font>
			</c:if>
			
			
		</td>
	</tr>
	</table>
	
	
	<div class="center1" id="op1">
		<div id="box">
		<button type="button" class="btn btn-primary" id="addvehbtn" onclick="openAddVehForm()">Add Vehicle</button>
     	     	
     	<div class="form-popup" id="formAddVehicle">
    	<form action="addVehicle.do" class="form-container">
   
    		<input type="text" placeholder="Enter Vehicle Type" name="vehicleType" required><br><br>

      		<input type="text" placeholder="Enter Vehicle Name" name="vehicleName" required><br><br>
 	   		
 	   		<input type="text" placeholder="Enter Booking Price" name="bookingPrice" required><br><br>
 	   		
 	   		<input type="text" placeholder="Enter Vehicle Number" name="vehicleNumber" required><br><br>
 	   		
 	   		<p><input type="submit" value="Add Vehicle" /></p>
      		
      		<button type="button" class="btn cancel" onclick="closeAddVehForm()">Cancel</button>
      		
    	</form>
    	</div>
		</div>
	</div> 
	<div class="center2" id="op2">
		
		<a href="viewvehicles.do">
			<button type="button" class="btn btn-primary"> View Vehicles </button>
		</a>
	</div>

	<div class="center3" id="op3">
		<div id="box">
		<button type="button" class="btn btn-primary" id="adddiscbtn" onclick="openAddDiscForm()">Add Discount</button>
     	     	
     	<div class="form-popup" id="formAddDiscount">
    	<form action="adddiscount.do" class="form-container">
    		<label for="vehno"><b>Vehicle Number</b></label>
    		<input type="text" placeholder="Enter VehicleNo" name="vehicleNum" required>

    		<label for="disc"><b>Discount</b></label>
 	   		<input type="text" placeholder="Enter Discount Val" name="discount" required>
      		
      		<p><input type="submit" value="Add Discount" /></p>
      		<button type="button" class="btn cancel" onclick="closeAddDiscForm()">Cancel</button>
      		
    	</form>
    	</div>
		</div>
		
	</div>
	
	<div class="center4" id="op4">
		<a href="viewbookings.do">
		<button type="button" class="btn btn-primary"> View Bookings </button>
		</a>
	</div>
	
	<div class="center5" id="op5">
		<div id="box">
		<button type="button" class="btn btn-primary" id="viewfeedbackbtn" onclick="openViewFeedbackForm()">View Feedback</button>
     	     	
     	<div class="form-popup" id="formViewFeedback">
    	<form action="viewfeedback.do" class="form-container">
    		<label for="vehno"><b>Vehicle Number</b></label>
    		<input type="text" placeholder="Enter VehicleNo" name="vehicleNumb" required>
      		
      		<p><input type="submit" value="View Feedback" /></p>
      		<button type="button" class="btn cancel" onclick="closeViewFeedbackForm()">Cancel</button>
      		
    	</form>
    	</div></div></div>
    <div class="bottomleft">
		<br><br>
		<a href="Homepage.jsp">
			<button type="button"> Homepage </button>
		</a>
	</div>
</body>
</html>