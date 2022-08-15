package com.ssbank.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssbank.dao.*;
import com.ssbank.model.User;

/**
 * Servlet implementation class RegistrationHandler
 */
@WebServlet("/RegistrationHandler")
public class RegistrationHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer user_id = User.generateUserID();
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String gender=request.getParameter("gender"); 
		String email=request.getParameter("email");
		Long phone_number=Long.parseLong(request.getParameter("phone_number"));
		String street_address=request.getParameter("street_address"); 
		String city=request.getParameter("city");
		String state=request.getParameter("state"); 
		String postal_code=request.getParameter("postal_code"); 
		String nationality=request.getParameter("nationality");
		String password=request.getParameter("password");
		
		User newUser = new User(
				user_id,
				first_name,
				last_name,
				gender,
				email,
				phone_number,
				street_address,
				city,
				state,
				postal_code,
				nationality,
				password);
		
		UserDao newdao = new UserDao();
		newdao .createUser(newUser);
	}

}
