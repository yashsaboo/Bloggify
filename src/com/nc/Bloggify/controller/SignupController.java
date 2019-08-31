package com.nc.Bloggify.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nc.Bloggify.dao.ISignUpValidate;
import com.nc.Bloggify.dao.SignUpValidate;
import com.nc.Bloggify.dto.User;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ISignUpValidate suv;
	
	public void init(ServletConfig config) throws ServletException {
		suv = new SignUpValidate();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = "WEB-INF/signup-success.jsp";
		
		
		User newUser = new User();
		newUser.setFirstName(request.getParameter("fName"));
		newUser.setLastName(request.getParameter("lName"));
		newUser.setEmail(request.getParameter("email"));
		newUser.setPassword(request.getParameter("password"));
		newUser.setRePassword(request.getParameter("repassword"));

		boolean result = suv.signUpValidate(newUser);
		
		if (result == false)
			target = "WEB-INF/signup-invalid.jsp";
		
		
		javax.servlet.RequestDispatcher dispatch = request.getRequestDispatcher(target);
		dispatch.forward(request, response);
	
		response.getWriter().println("Path:" + request.getRequestURI());
	}

}
