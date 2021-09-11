package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.ntt.dao.BookingDetailsDAO;

import com.ntt.domain.BookingDetails;


public class SelectAndBookVehicle implements HttpRequestHandler{
	
static Logger log = Logger.getLogger(SelectAndBookVehicle.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String vehicleNum = request.getParameter("vehicleNumber");
		BookingDetails veh = new BookingDetails(vehicleNum);
		int result=0;
		
	
		result=BookingDetailsDAO.addBooking(veh);

		if (result!=0) {
			log.info("Discount added successfully");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("CustomerDashboard.jsp");
			request.setAttribute("customermsg",
					"Booking done successfully");
			dispatcher.forward(request, response);
		} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("CustomerDashboard.jsp");
				request.setAttribute("errcustomermsg",
						"Failed to book vehicle");

				dispatcher.forward(request, response);
			
		}
	
	}


}
