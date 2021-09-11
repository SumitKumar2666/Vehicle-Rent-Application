package com.ntt.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.ntt.domain.BookingDetails;
import com.ntt.domain.VehicleDetails;

public class CustomerOperations {
	
	static Logger log=Logger.getLogger(CustomerOperations.class);
	
	public static void customerMenu() throws DBFWException, UserDetailsDAOException, DBConnectionException {
	int ch = 0;
	int status = 0;
	Scanner sc = new Scanner(System.in);
	String vehBNumber = null;
	do {
	
	System.out.println("--MENU--");
	System.out.println("1.Search Vehicles"); //insert
	System.out.println("2.View booked vehicle"); //Select
	System.out.println("3.View Discount");
	System.out.println("4.Calculate the price");
	System.out.println("5.Select vehicle and book");
	System.out.println("6.Provide feedback");
	System.out.println("Enter ur choice");
	ch=sc.nextInt();
	
	switch (ch) {
	case 1: 
		List vehicleList = null;
		try {
			String searchVehByNumber;
			System.out.println("Enter vehicle number to search");
			searchVehByNumber = sc.next();
			vehicleList = VehicleDetailsDAO.getVehicles(searchVehByNumber);
			if(!(vehicleList.isEmpty())) {
				System.out.println("\n\n**** Available Vehicles **** \n");
				System.out.println("------------------------------------");
				for(Iterator it=vehicleList.iterator();it.hasNext();)
					System.out.println(it.next());
			}
			else {
				System.out.println("Sorry no vehicles are available");
			}
		} catch (DBFWException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (UserDetailsDAOException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (DBConnectionException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		break;
	case 2:
		List vehicleBList = null;
		vehicleBList = BookingDetailsDAO.getCBooking(vehBNumber);
		if(!(vehicleBList.isEmpty())) {
			System.out.println("\n\n**** Vehicles booked by you are **** \n");
			System.out.println("------------------------------------");
			for(Object vBList: vehicleBList) {
				String vType = ((VehicleDetails) vBList).getVehicleType();
				String vName = ((VehicleDetails) vBList).getVehicleName();
				String vNum = ((VehicleDetails) vBList).getVehicleNumber();
				double vBPrice = ((VehicleDetails) vBList).getVehicleBPrice();
				double vDisc = ((VehicleDetails) vBList).getVehicleDiscount();
				
				System.out.println("Vehicle Type = "+vType+ ", Vehicle Name = "+vName+ ", Vehicle Number = "+vNum+ ", Booking Price = "+vBPrice+ ", Vehicle Discount = "+vDisc);
				break;
			}
		}
		else {
			System.out.println("Sorry no vehicles are booked");
		}
		
		break;
	case 3:
		String discVehNumber;
		System.out.println("Enter vehicle number to view discount");
		discVehNumber = sc.next();
		List vehicleDiscList = null;
		vehicleDiscList = VehicleDetailsDAO.getDiscount(discVehNumber);
		
		if(!(vehicleDiscList.isEmpty())) {
			System.out.println("\n\n**** Vehicle Number with Discount **** \n");
			System.out.println("------------------------------------");
			for(Object vDet: vehicleDiscList) {
				String vNum = ((VehicleDetails) vDet).getVehicleNumber();
				double vDisc = ((VehicleDetails) vDet).getVehicleDiscount();
				System.out.println("Vehicle Number = "+vNum+ ", Vehicle Discount = "+vDisc);
			}
		}
		else {
			System.out.println("No disc avail");
		}
		
		break;
	case 4:
		String calcVehNumber;
		System.out.println("Enter vehicle number to calculate its price");
		calcVehNumber = sc.next();
		List vehicleCalcPriceList = null;
		vehicleCalcPriceList = VehicleDetailsDAO.getFinalPrice(calcVehNumber);
		
		if(!(vehicleCalcPriceList.isEmpty())) {
			System.out.println("\n\n**** Vehicle Number with Discount **** \n");
			System.out.println("------------------------------------");
			for(Object vDet: vehicleCalcPriceList) {
				String vNum = ((VehicleDetails) vDet).getVehicleNumber();
				double vBookingPrice = ((VehicleDetails) vDet).getVehicleBPrice();
				double vDisc = ((VehicleDetails) vDet).getVehicleDiscount();
				double finalPrice = vBookingPrice - vDisc;
				System.out.println("Vehicle Number = "+vNum+ ", Booking Price= "+vBookingPrice+ ", Vehicle Discount = "+vDisc+ ", Final Price = "+finalPrice);
			}
		}
		else {
			System.out.println("No disc avail");
		}
		
		break;
	case 5:
		int bookResult = 0;
		System.out.println("Enter the vehicle number to book:");
		vehBNumber = sc.next();
		BookingDetails vehBook = new BookingDetails(vehBNumber);
		bookResult=BookingDetailsDAO.addBooking(vehBook);
		System.out.println("Vechile having number "+vehBNumber+" is booked successfully");
		break;
	case 6:
		int result = 0;
		System.out.println("Enter the vehicle number to give feedback:");
		String vehNumber = sc.next();
		System.out.println("Enter feedback:");
		String feedback = sc.next();
		//VehicleDetails vehFeed = new VehicleDetails(feedback, vehNumber);
		result=VehicleDetailsDAO.addFeedback(vehNumber,feedback);
		
		break;
	} // end switch
	System.out.println("Do you wish to return to dashboard?(press any number not zero)");
	status=sc.nextInt();
	
	}
	while(!(status==0));
	System.out.println("\n\n Thank You \n\n");
 }
}
