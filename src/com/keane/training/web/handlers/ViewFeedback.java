package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.ntt.dao.VehicleDetailsDAO;

public class ViewFeedback implements HttpRequestHandler{

static Logger log = Logger.getLogger(ViewVehicles.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String vehicleNum = request.getParameter("vehicleNumb");
		
		List vehicleFeedbackList = null;
	
		try {
			vehicleFeedbackList=VehicleDetailsDAO.getFeedback(vehicleNum);
			if(vehicleFeedbackList!=null && vehicleFeedbackList.size()>0 )
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("DisplayFeedback.jsp");
				request.setAttribute("feed", vehicleFeedbackList);
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AdminDashboard.jsp");
				request.setAttribute("erradminmsg", "Entered vehicle number is not available");
				dispatcher.forward(request, response);
			}

		
		}catch (Exception e) {
			System.out.println(e);
		}
			
		}

	
}
