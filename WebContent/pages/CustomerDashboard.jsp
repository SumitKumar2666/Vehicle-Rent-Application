<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Dashboard</title>
<meta charset='utf-8'>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script>

function openSearchVehicleForm() {
	  document.getElementById("formSearchVehicle").style.display = "block";
	  document.getElementById("searchvehiclebtn").style.display = "none";
	  document.getElementById("op2").style.display = "none";
	  document.getElementById("op3").style.display = "none";
	  document.getElementById("op4").style.display = "none";
	  document.getElementById("op5").style.display = "none";
	  document.getElementById("op6").style.display = "none";
	}
function closeSearchVehicleForm() {
	  document.getElementById("formSearchVehicle").style.display = "none";
	  document.getElementById("searchvehiclebtn").style.display = "block";
	  document.getElementById("op2").style.display = "block";
	  document.getElementById("op3").style.display = "block";
	  document.getElementById("op4").style.display = "block";
	  document.getElementById("op5").style.display = "block";
	  document.getElementById("op6").style.display = "block";
	}
function openViewDiscountForm() {
	  document.getElementById("formViewDiscount").style.display = "block";
	  document.getElementById("viewdiscountbtn").style.display = "none";
	  document.getElementById("op1").style.display = "none";
	  document.getElementById("op2").style.display = "none";
	  document.getElementById("op4").style.display = "none";
	  document.getElementById("op5").style.display = "none";
	  document.getElementById("op6").style.display = "none";
	}
function closeViewDiscountForm() {
	  document.getElementById("formViewDiscount").style.display = "none";
	  document.getElementById("viewdiscountbtn").style.display = "block";
	  document.getElementById("op1").style.display = "block";
	  document.getElementById("op2").style.display = "block";
	  document.getElementById("op4").style.display = "block";
	  document.getElementById("op5").style.display = "block";
	  document.getElementById("op6").style.display = "block";
	}

function openViewFinalPriceForm() {
	  document.getElementById("formViewFinalPrice").style.display = "block";
	  document.getElementById("finalpricebtn").style.display = "none";
	  document.getElementById("op1").style.display = "none";
	  document.getElementById("op2").style.display = "none";
	  document.getElementById("op3").style.display = "none";
	  document.getElementById("op5").style.display = "none";
	  document.getElementById("op6").style.display = "none";
	}
function closeViewFinalPriceForm() {
	  document.getElementById("formViewFinalPrice").style.display = "none";
	  document.getElementById("finalpricebtn").style.display = "block";
	  document.getElementById("op1").style.display = "block";
	  document.getElementById("op2").style.display = "block";
	  document.getElementById("op3").style.display = "block";
	  document.getElementById("op5").style.display = "block";
	  document.getElementById("op6").style.display = "block";
	}

function openSelectAndBookForm() {
	  document.getElementById("formVehicleBook").style.display = "block";
	  document.getElementById("vehiclebookbtn").style.display = "none";
	  document.getElementById("op1").style.display = "none";
	  document.getElementById("op2").style.display = "none";
	  document.getElementById("op3").style.display = "none";
	  document.getElementById("op4").style.display = "none";
	  document.getElementById("op6").style.display = "none";
	}
function closeSelectAndBookForm() {
	  document.getElementById("formVehicleBook").style.display = "none";
	  document.getElementById("vehiclebookbtn").style.display = "block";
	  document.getElementById("op1").style.display = "block";
	  document.getElementById("op2").style.display = "block";
	  document.getElementById("op3").style.display = "block";
	  document.getElementById("op4").style.display = "block";
	  document.getElementById("op6").style.display = "block";
	}

function openProvideFeedbackForm() {
	  document.getElementById("formProvideFeedback").style.display = "block";
	  document.getElementById("providefeedbackbtn").style.display = "none";
	  document.getElementById("op1").style.display = "none";
	  document.getElementById("op2").style.display = "none";
	  document.getElementById("op3").style.display = "none";
	  document.getElementById("op4").style.display = "none";
	  document.getElementById("op5").style.display = "none";
	}
function closeProvideFeedbackForm() {
	  document.getElementById("formProvideFeedback").style.display = "none";
	  document.getElementById("providefeedbackbtn").style.display = "block";
	  document.getElementById("op1").style.display = "block";
	  document.getElementById("op2").style.display = "block";
	  document.getElementById("op3").style.display = "block";
	  document.getElementById("op4").style.display = "block";
	  document.getElementById("op5").style.display = "block";
	}
	
function openBookedVehiclesForm() {
	  document.getElementById("formBookedVehicles").style.display = "block";
	  document.getElementById("bookedvehiclesbtn").style.display = "none";
	  document.getElementById("op1").style.display = "none";
	  document.getElementById("op3").style.display = "none";
	  document.getElementById("op4").style.display = "none";
	  document.getElementById("op5").style.display = "none";
	  document.getElementById("op6").style.display = "none";
	}
function closeBookedVehiclesForm() {
	  document.getElementById("formBookedVehicles").style.display = "none";
	  document.getElementById("bookedvehiclesbtn").style.display = "block";
	  document.getElementById("op1").style.display = "block";
	  document.getElementById("op3").style.display = "block";
	  document.getElementById("op4").style.display = "block";
	  document.getElementById("op5").style.display = "block";
	  document.getElementById("op6").style.display = "block";
	}


</script>
<style>

  body {
  background-color: powderblue;
  background-image: url('../pictures/custdashboard.jpg');
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
.center6 {
  margin: 0;
  position: absolute;
  top: 80%;
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
<body>
<h2 class="glow">Welcome to Customer Dashboard</h2><hr>

<table>
	
	<tr>
		<td colspan="2">
			<c:if test="${requestScope.customermsg!=null}">
			<font color="green">${requestScope.customermsg}</font>
			</c:if>
			
			
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${requestScope.errcustomermsg!=null}">
			<font color="red">${requestScope.errcustomermsg}</font>
			</c:if>
			
			
		</td>
	</tr>
	</table>

	<div class="center1" id="op1">
		<div id="box">
		<button type="button" class="btn btn-primary" id="searchvehiclebtn" onclick="openSearchVehicleForm()">Search Vehicles</button>
     	     	
     	<div class="form-popup" id="formSearchVehicle">
    	<form action="searchvehicles.do" class="form-container">
    		<label for="vehno"><b>Vehicle Number</b></label>
    		<input type="text" placeholder="Enter VehicleNo" name="vehicleNumb" required>
      		
      		<p><input type="submit" value="Search Vehicle" /></p>
      		<button type="button" class="btn cancel" onclick="closeSearchVehicleForm()">Cancel</button>
      		
    	</form>
    	</div></div>
		
	</div>
	
	<div class="center2" id="op2">
		<div id="box">
		<button type="button" class="btn btn-primary" id="bookedvehiclesbtn" onclick="openBookedVehiclesForm()">View Booked Vehicles</button>
     	     	
     	<div class="form-popup" id="formBookedVehicles">
    	<form action="viewbookedvehicles.do" class="form-container">
    		<label for="vehno"><b>Vehicle Number</b></label>
    		<input type="text" placeholder="Enter VehicleNo" name="vehicleNumb" required>
      		
      		<p><input type="submit" value="Show Booked Vehicles" /></p>
      		<button type="button" class="btn cancel" onclick="closeBookedVehiclesForm()">Cancel</button>
      		
    	</form>
    	</div></div>
	</div>
	
	<div class="center3" id="op3">
	<div id="box">
		<button type="button" class="btn btn-primary" id="viewdiscountbtn" onclick="openViewDiscountForm()">View Discount</button>
     	     	
     	<div class="form-popup" id="formViewDiscount">
    	<form action="viewdiscount.do" class="form-container">
    		<label for="vehno"><b>Vehicle Number</b></label>
    		<input type="text" placeholder="Enter VehicleNo" name="vehicleNumbe" required>
      		
      		<p><input type="submit" value="View Dicount" /></p>
      		<button type="button" class="btn cancel" onclick="closeViewDiscountForm()">Cancel</button>
      		
    	</form>
    	</div></div>
	
	</div>
	
	<div class="center4" id="op4">
		<div id="box">
		<button type="button" class="btn btn-primary" id="finalpricebtn" onclick="openViewFinalPriceForm()">Calculate Final Price</button>
     	     	
     	<div class="form-popup" id="formViewFinalPrice">
    	<form action="viewfinalprice.do" class="form-container">
    		<label for="vehno"><b>Vehicle Number</b></label>
    		<input type="text" placeholder="Enter VehicleNo" name="vehicleNumber" required>
      		
      		<p><input type="submit" value="Calculate Price" /></p>
      		<button type="button" class="btn cancel" onclick="closeViewFinalPriceForm()">Cancel</button>
      		
    	</form>
    	</div></div>
	</div>
	
	<div class="center5" id="op5">
		<div id="box">
		<button type="button" class="btn btn-primary" id="vehiclebookbtn" onclick="openSelectAndBookForm()">Select Vehicle & Book</button>
     	     	
     	<div class="form-popup" id="formVehicleBook">
    	<form action="selectandbook.do" class="form-container">
    		<label for="vehno"><b>Vehicle Number</b></label>
    		<input type="text" placeholder="Enter VehicleNo" name="vehicleNumber" required>
      		
      		<p><input type="submit" value="Book Vehicle" /></p>
      		<button type="button" class="btn cancel" onclick="closeSelectAndBookForm()">Cancel</button>
      		
    	</form>
    	</div></div>
	</div>
	
	<div class="center6" id="op6">
		<div id="box">
		<button type="button" class="btn btn-primary" id="providefeedbackbtn" onclick="openProvideFeedbackForm()">Provide Feedback</button>
     	     	
     	<div class="form-popup" id="formProvideFeedback">
    	<form action="givefeedback.do" class="form-container">
    		<label for="vehno"><b>Vehicle Number</b></label>
    		<input type="text" placeholder="Enter VehicleNo" name="vehicleNum" required>

    		<label for="feed"><b>Feedback</b></label>
 	   		<input type="text" placeholder="Enter Feedback" name="feedback" required>
      		
      		<p><input type="submit" value="Provide Feedback" /></p>
      		<button type="button" class="btn cancel" onclick="closeProvideFeedbackForm()">Cancel</button>
      		
    	</form>
    	</div>
		</div>
	</div>
	<div class="bottomleft">
		<br><br>
		<a href="Homepage.jsp">
			<button type="button"> Homepage </button>
		</a>
	</div>
</body>
</html>