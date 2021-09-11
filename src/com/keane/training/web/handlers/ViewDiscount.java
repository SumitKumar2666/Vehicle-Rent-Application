package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;
import com.ntt.dao.VehicleDetailsDAO;

public class ViewDiscount implements HttpRequestHandler{
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String vehicleNum = request.getParameter("vehicleNumbe");
	
		List all=null;
		try {
			all=VehicleDetailsDAO.getDiscount(vehicleNum);
			if(all!=null && all.size()>0 )
			{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("DisplayDiscount.jsp");
				request.setAttribute("viewDiscountData", all);
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("CustomerDashboard.jsp");
				request.setAttribute("errcustomermsg", "Entered vehicle no is incorrect");
				dispatcher.forward(request, response);
			}

		
		}catch (Exception e) {
			System.out.println(e);
		}
			
		}


}
