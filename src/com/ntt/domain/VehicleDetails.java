package com.ntt.domain;

public class VehicleDetails {
	
	private String vehicleType;
	private String vehicleName;
	private double vehicleBPrice; // booking price of vehicle
	private String vehicleNumber;
	private double vehicleDiscount;
	private String vehicleFeedback;
	private double vehicleFinalPrice;
	
	public VehicleDetails(String vehicleType, String vehicleName, double vehicleBPrice, String vehicleNumber, double vehicleDiscount, String vFeedback) { // admin op for view veh
		super();
		this.vehicleType = vehicleType;
		this.vehicleName = vehicleName;
		this.vehicleBPrice = vehicleBPrice;
		this.vehicleNumber = vehicleNumber;
		this.vehicleDiscount = vehicleDiscount;
		this.vehicleFeedback = vFeedback;
	}
	
	public VehicleDetails(String vehicleType, String vehicleName, double vehicleBPrice, String vehicleNumber, double vehicleDiscount) {
		super();
		this.vehicleType = vehicleType;
		this.vehicleName = vehicleName;
		this.vehicleBPrice = vehicleBPrice;
		this.vehicleNumber = vehicleNumber;
		this.vehicleDiscount = vehicleDiscount;
	}
	public VehicleDetails(String vehicleType, String vehicleName, double vehicleBPrice, String vehicleNumber) {
		super();
		this.vehicleType = vehicleType;
		this.vehicleName = vehicleName;
		this.vehicleBPrice = vehicleBPrice;
		this.vehicleNumber = vehicleNumber;
	}
	public VehicleDetails(double vehicleDiscount, String vehicleNumber) { // for adding discount
		this.vehicleDiscount = vehicleDiscount;
		this.vehicleNumber = vehicleNumber;
	}
	public VehicleDetails(String feedback, String vehicleNumber) { // for adding feedback
		this.vehicleFeedback = feedback;
		this.vehicleNumber = vehicleNumber;
	}
	public VehicleDetails(String feedback) { // for fetching feedback
		this.vehicleFeedback = feedback;

	}
	public VehicleDetails(String vehicleNumber, double discount) { // for fetching disc
		this.vehicleDiscount = discount;
		this.vehicleNumber = vehicleNumber;
	}
	public VehicleDetails(String vehicleNumber,double bookingPrice, double discount) { // for fetching finalprice
		this.vehicleDiscount = discount;
		this.vehicleNumber = vehicleNumber;
		this.vehicleBPrice = bookingPrice;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public double getVehicleBPrice() {
		return vehicleBPrice;
	}

	public void setVehicleBPrice(double vehicleBPrice) {
		this.vehicleBPrice = vehicleBPrice;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	public double getVehicleDiscount() {
		return vehicleDiscount;
	}

	public void setVehicleDiscount(double vehicleDiscount) {
		this.vehicleDiscount = vehicleDiscount;
	}
	

	public String getVehicleFeedback() {
		return vehicleFeedback;
	}
	public void setVehicleFeedback(String vehicleFeedback) {
		this.vehicleFeedback = vehicleFeedback;
	}
	
	public double getVehicleFinalPrice() {
		return vehicleFinalPrice;
	}
	public void setVehicleFinalPrice(double vehicleFinalPrice) {
		this.vehicleFinalPrice = vehicleFinalPrice;
	}
	@Override
	public String toString() {
		return "Vehicle Type=" + vehicleType + ", Vehicle Name=" + vehicleName + ", Booking Price="
				+ vehicleBPrice + ", Vehicle Number=" + vehicleNumber + ", Discount=" + vehicleDiscount
				+ ",\t Vehicle Feedback=" + vehicleFeedback + "";
	}
	
	
	

	
}
