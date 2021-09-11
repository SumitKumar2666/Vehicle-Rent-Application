package com.ntt.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.ntt.domain.UserDetails;
import com.ntt.domain.VehicleDetails;
import com.ntt.dao.VehicleDetailsDAO;

public class AdminOperations {
	
static Logger log=Logger.getLogger(AdminOperations.class);
	
	public static void adminMenu() {
	int ch = 0;
	int status = 0;
	Scanner sc = new Scanner(System.in);
	
	do {
	
	System.out.println("--MENU--");
	System.out.println("1.Add vehicle"); //insert
	System.out.println("2.View vehicle"); //Select
	System.out.println("3.Add Discount");
	System.out.println("4.View booking");
	System.out.println("5.View feedback");
	System.out.println("Enter ur choice");
	ch=sc.nextInt();
	
	switch (ch) {
	case 1: 
		int result=0;
		System.out.println("Enter vehicle type: "); //
		String vehType=sc.next();
		System.out.println("Enter vehicle name: "); //
		String vehName=sc.next();
		// adding required fields
		System.out.println("Enter price for booking: "); // 
		float vehPrice=sc.nextFloat();
		System.out.println("Enter vehicle number"); // 
		String vehNumber=sc.next();
		int roleId = 102; // for customer
		
		VehicleDetails veh = new VehicleDetails(vehType, vehName, vehPrice, vehNumber);
		result=VehicleDetailsDAO.addVehicle(veh);
		if(result!=0)
		{
			System.out.println("Vehicle addition done successfully");
		}
		else
		{
			System.out.println("Failed to add");
		}
		break;
		
	case 2:
		List vehicleList = null;
		try {
			vehicleList = VehicleDetailsDAO.getVehicles();
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

	case 3:
		System.out.println("Enter discount");
		int discount=0;
		discount = sc.nextInt();
		System.out.println("Enter vehicle number to add discount");
		String number = sc.next();
		VehicleDetails ad=new VehicleDetails(discount, number);
		result=VehicleDetailsDAO.addDiscount(ad);

		break;
	
	case 4:
		List bookingList = null;
		try {
			bookingList = BookingDetailsDAO.getBookings();
			if(!(bookingList.isEmpty())) {
				System.out.println("\n\n**** Booked Vehicles **** \n");
				System.out.println("------------------------------------");
				for(Iterator it=bookingList.iterator();it.hasNext();)
					System.out.println(it.next());
			}
			else {
				System.out.println("Sorry no vehicles are booked");
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
	
	case 5:
		System.out.println("Enter vehicle number to view feedback");
		String feedbackVehicleNumber = sc.next();
		List vehicleFeedbackList = null;
		try {
			vehicleFeedbackList = VehicleDetailsDAO.getFeedback(feedbackVehicleNumber);
			
			if(!(vehicleFeedbackList.isEmpty())) {
				System.out.println("\n\n**** Feedback: **** \n");
				System.out.println("------------------------------------");
				for(Object vDet: vehicleFeedbackList) {
					String vNum = ((VehicleDetails) vDet).getVehicleNumber();
					String vFeed = ((VehicleDetails) vDet).getVehicleFeedback();
					System.out.println("Vehicle Number = "+vNum+ ", Vehicle Feedback = "+vFeed);
				}
//				for(Iterator it=vehicleFeedbackList.iterator();it.hasNext();)
//					System.out.println(it.next());
			}
			else {
				System.out.println("Sorry no feedback is available");
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
	
	} // end switch
	System.out.println("\nDo you wish to return to dashboard?(press any number not zero)");
	status=sc.nextInt();
	
	}// do-while loop
	while(!(status==0));
	System.out.println("\n\n Thank You \n\n");
 }

}
