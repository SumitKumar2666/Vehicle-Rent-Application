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

public class ProvideFeedback implements HttpRequestHandler{
	
static Logger log = Logger.getLogger(ProvideFeedback.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String vehicleNum = request.getParameter("vehicleNum");
		String vehicleFeedback = request.getParameter("feedback");
		//VehicleDetails veh = new VehicleDetails(vehicleNum,vehicleFeedback);
		int result=0;
		
	
		result=VehicleDetailsDAO.addFeedback(vehicleNum,vehicleFeedback);

		if (result!=0) {
			
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("CustomerDashboard.jsp");
			request.setAttribute("customermsg",
					"Feedback added successfully");
			dispatcher.forward(request, response);
		} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("CustomerDashboard.jsp");
				request.setAttribute("errcustomermsg",
						"Failed to add feedback");

				dispatcher.forward(request, response);
			
		}
	
	}


}
