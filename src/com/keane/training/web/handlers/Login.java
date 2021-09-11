package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;

import com.ntt.domain.UserDetails;
import com.ntt.dao.UserDetailsDAO;
import com.ntt.dao.UserDetailsDAOException;

public class Login implements HttpRequestHandler {

	public static Logger log = Logger.getLogger(Login.class);

	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int userid = Integer.parseInt(request.getParameter("user_id"));
		String password = request.getParameter("password");
		
		List users = null;
		UserDetailsDAO dao = new UserDetailsDAO();
		users = dao.getCredentials(userid,password);
		
		if(users != null && users.size() > 0) {
			for (Object object : users) {

				UserDetails user = (UserDetails) object;
				if(user.getRoleId() == 102) {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("CustomerDashboard.jsp");
					request.setAttribute("CustomerDashboard",
							"Welcome to Customer Dashboard");

					dispatcher.forward(request, response);
				}
				else {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("AdminDashboard.jsp");
					request.setAttribute("Err",
							"Welcome to Admin Dashboard");
					dispatcher.forward(request, response);
				}
				
			}
		}
		else {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Login.jsp");
			request.setAttribute("Err",
					"username or password is incorrect");
			dispatcher.forward(request, response);
		}
			
		
		log.info(users);
		

	}
}
