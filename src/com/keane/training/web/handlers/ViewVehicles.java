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


public class ViewVehicles implements HttpRequestHandler {
	
	
static Logger log = Logger.getLogger(ViewVehicles.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		List all=null;
		try {
			all=VehicleDetailsDAO.getVehicles();
			if(all!=null && all.size()>0 )
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("DisplayVehicles.jsp");
				request.setAttribute("property", all);
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AdminDashboard.jsp");
				request.setAttribute("erradminmsg", "No vehicles available");
				dispatcher.forward(request, response);
			
			}

		
		}catch (Exception e) {
			System.out.println(e);
		}
			
		}

}
