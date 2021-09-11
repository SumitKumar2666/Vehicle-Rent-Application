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

public class ViewSearchVehicle implements HttpRequestHandler{

static Logger log = Logger.getLogger(ViewVehicles.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String vehicleNum = request.getParameter("vehicleNumb");
	
		List all=null;
		try {
			all=VehicleDetailsDAO.getVehicles(vehicleNum);
			if(all!=null && all.size()>0 )
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("DisplaySearchVehicle.jsp");
				request.setAttribute("searchvehData", all);
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("CustomerDashboard.jsp");
				request.setAttribute("errcustomermsg", "No such vehicle available");
				dispatcher.forward(request, response);
			
			}

		
		}catch (Exception e) {
			System.out.println(e);
		}
			
		}

	
}
