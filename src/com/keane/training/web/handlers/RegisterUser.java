package com.keane.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.keane.mvc.HttpRequestHandler;
import com.ntt.dao.UserDetailsDAO;
import com.ntt.dao.UserDetailsDAOException;
import com.ntt.domain.UserDetails;

public class RegisterUser implements HttpRequestHandler {
	static Logger log = Logger.getLogger(RegisterUser.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDetailsDAO dao = new UserDetailsDAO();
		UserDetails user = new UserDetails();
		user.setUid(Integer.parseInt(request.getParameter("user_id")));
		user.setUname(request.getParameter("name"));
		user.setUpassword(request.getParameter("password"));
		user.setUcity(request.getParameter("city"));
		user.setUemail(request.getParameter("email"));
		user.setUcontactNumber(Long.parseLong(request.getParameter("contact_no")));
		user.setRoleId(102);

		boolean isExists;
		try {
			isExists = dao.validateUser(user.getUid());

			if (isExists) {
				log.info("User already registered");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("RegisterUser.jsp");
				request.setAttribute("Err",
						"User already registered with the system");
				dispatcher.forward(request, response);
			} else {
				
				int finalRes = dao.insertUser(user);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("success.jsp");
					request.setAttribute("success",
							"User succesfully registered with the system");
					request.setAttribute("details", user);
					dispatcher.forward(request, response);
				}
			}
		} catch (UserDetailsDAOException e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}
