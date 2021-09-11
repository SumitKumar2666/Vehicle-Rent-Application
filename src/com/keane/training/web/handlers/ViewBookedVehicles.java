package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.ntt.dao.BookingDetailsDAO;
import com.ntt.dao.VehicleDetailsDAO;

public class ViewBookedVehicles implements HttpRequestHandler{

static Logger log = Logger.getLogger(ViewBookedVehicles.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String vehBNumber = request.getParameter("vehicleNumb");
		
		List all=null;
		try {
			all=BookingDetailsDAO.getCBooking(vehBNumber);
			if(all!=null && all.size()>0 )
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("DisplayBookedVehicles.jsp");
				request.setAttribute("property", all);
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("CustomerDashboard.jsp");
				request.setAttribute("errcustomermsg", "No bookings found");
				dispatcher.forward(request, response);
			}

		
		}catch (Exception e) {
			System.out.println(e);
		}
			
		}

	
}
