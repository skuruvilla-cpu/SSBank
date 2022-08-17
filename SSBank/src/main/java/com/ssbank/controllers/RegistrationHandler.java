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
    
    public static boolean isValidPassword(final String password) {
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        return password.matches(pattern);
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
		String phone_number= request.getParameter("phone_number");
		String street_address=request.getParameter("street_address"); 
		String city=request.getParameter("city");
		String state=request.getParameter("state"); 
		String postal_code=request.getParameter("postal_code"); 
		String nationality=request.getParameter("nationality");
		String password=request.getParameter("password");
		String confirmPassword = request.getParameter("RepeatPassword");
		String accounttypessav= request.getParameter("accounttypeSav");
		
		System.out.println(password);
		System.out.println(confirmPassword);
		
		if(!RegistrationHandler.isValidPassword(password)) {
			response.sendRedirect("register.jsp?pwd=0");
		}else if(!confirmPassword.equals(password)) {
			response.sendRedirect("register.jsp?pwd=-1");
		}else {
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
			AccountsDao checkaccobj = new AccountsDao();
			
			//exit if user email already exists
			newdao.getUserbyParam(null, email);
			if(newdao.getUserbyParam(null, email)!= null) {
				response.sendRedirect("register.jsp?email=0");
			}else {
				int registerStatus = newdao.createUser(newUser);
				if(registerStatus != 0) {
					int accountcreateStatus = 0;
					
					//creating accounts
					
					accountcreateStatus = checkaccobj.createAccounts("checking",user_id);
					
					if(accounttypessav!=null && accounttypessav.equals("savings")) {
						accountcreateStatus = checkaccobj.createAccounts("savings",user_id);
					}
					
					if(accountcreateStatus == 0) {
						response.sendRedirect("register.jsp?success=0");
					}else {
						response.sendRedirect("login.jsp?success=1");
					}
				}else {
					response.sendRedirect("register.jsp?success=0");
				}
			}
		}
	}
}
