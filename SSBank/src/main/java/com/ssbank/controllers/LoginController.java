package com.ssbank.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssbank.dao.*;
import com.ssbank.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession usersession = request.getSession();
		User currentuser = (User)usersession.getAttribute("user");
	    if(currentuser == null){
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("accounts.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("email") == null || request.getParameter("password")== null || request.getParameter("email").length()==0 || request.getParameter("password").length()==0) {
			response.sendRedirect("login.jsp?success=0");
		}else {
			UserDao userdao = new UserDao();
			User userObj = userdao.getUserbyParam(null, request.getParameter("email"));
			if(userObj!=null && userObj.getPassword().equals(request.getParameter("password"))) {
				HttpSession userSession = request.getSession(true);
				userSession.setAttribute("user",userObj);
				response.sendRedirect("LoginController");
			}else {
				response.sendRedirect("login.jsp?success=0");	
			}
		}
	}

}
