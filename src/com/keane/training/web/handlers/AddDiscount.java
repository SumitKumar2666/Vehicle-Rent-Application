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

public class AddDiscount implements HttpRequestHandler {

	static Logger log = Logger.getLogger(AddDiscount.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		double discount = Double.parseDouble(request.getParameter("discount"));
		String vehicleNum = request.getParameter("vehicleNum");
		VehicleDetails veh = new VehicleDetails(discount,vehicleNum);
		int result=0;
		
	
		result=VehicleDetailsDAO.addDiscount(veh);

		if (result!=0) {
			log.info("Discount added successfully");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("AdminDashboard.jsp");
			request.setAttribute("adminmsg",
					"Discount added successfully");
			dispatcher.forward(request, response);
		} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AdminDashboard.jsp");
				request.setAttribute("erradminmsg",
						"Failed to add discount");

				dispatcher.forward(request, response);
			
		}
	
	}

}
