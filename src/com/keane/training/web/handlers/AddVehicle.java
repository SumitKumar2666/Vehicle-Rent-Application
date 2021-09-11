package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.ntt.dao.VehicleDetailsDAO;
import com.ntt.domain.VehicleDetails;

public class AddVehicle implements HttpRequestHandler {
	
static Logger log = Logger.getLogger(AddVehicle.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//AdminOperation adm= new AdminOperation();
		String vehicleType = request.getParameter("vehicleType");
		String vehicleName = request.getParameter("vehicleName");
		double bookingPrice = Double.parseDouble(request.getParameter("bookingPrice"));
		String vehicleNumber = request.getParameter("vehicleNumber");
		
		VehicleDetails veh = new VehicleDetails(vehicleType,vehicleName,bookingPrice,vehicleNumber);
		int result;
		result = 0;
	
		result=VehicleDetailsDAO.addVehicle(veh);

		if (result!=0) {
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("AdminDashboard.jsp");
			request.setAttribute("adminmsg",
					"Vehicle added successfully");
			dispatcher.forward(request, response);
		} else {
			
			
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AdminDashboard.jsp");
				request.setAttribute("erradminmsg",
						"Failed to add vehicle");

				dispatcher.forward(request, response);
			
		}
	
	}


}
