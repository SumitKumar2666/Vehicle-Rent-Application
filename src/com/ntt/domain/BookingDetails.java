package com.ntt.domain;

public class BookingDetails {
	
	private String vehicleNumber;
	private double vehiclePrice;
	private double discount;
	private double finalPrice;
	
	public BookingDetails(String vehicleNumber, double vehiclePrice, double discount, double finalPrice) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehiclePrice = vehiclePrice;
		this.discount = discount;
		this.finalPrice = finalPrice;
	}
	
	
	public BookingDetails(String vehBNumber) {
		this.vehicleNumber = vehBNumber;
		
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public double getVehiclePrice() {
		return vehiclePrice;
	}
	public void setVehiclePrice(double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	public String toString()
	{
		return ("Vehicle Number-"+vehicleNumber+", Vehicle Price-"+vehiclePrice+", Discount-"+discount+", Final Price-"+finalPrice).toString();
	}

}
