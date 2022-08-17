package com.ssbank.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssbank.dao.AccountsDao;
import com.ssbank.model.User;

/**
 * Servlet implementation class SavingsAcccountCreator
 */
@WebServlet("/SavingsAcccountCreator")
public class SavingsAcccountCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavingsAcccountCreator() {
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
			AccountsDao checkaccobj = new AccountsDao();
			int accountcreateStatus = checkaccobj.createAccounts("savings",currentuser.getUser_id());
			if(accountcreateStatus > 0) {
				response.sendRedirect("accounts.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
