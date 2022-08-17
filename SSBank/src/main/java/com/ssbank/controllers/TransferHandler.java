package com.ssbank.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssbank.dao.AccountsDao;
import com.ssbank.dao.UserDao;
import com.ssbank.model.User;

/**
 * Servlet implementation class TransferHandler
 */
@WebServlet("/TransferHandler")
public class TransferHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferHandler() {
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
			response.sendRedirect("transfer.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("account")!=null && request.getParameter("amount")!=null && request.getParameter("email")!= null && Double.parseDouble(request.getParameter("amount"))>0) {
			
			//check if account exists for email
			UserDao userdaoObj = new UserDao();
			User beneficiaryUser = userdaoObj.getUserbyParam(null, request.getParameter("email"));
			
			if(beneficiaryUser==null) {
				response.sendRedirect("transfer.jsp?beneficiary=0");
			}else {
				AccountsDao acccdaoObj = new AccountsDao();
				int transferStatus = acccdaoObj.transferMoney(request.getParameter("account"), beneficiaryUser.getUser_id(), Double.parseDouble(request.getParameter("amount")));
				if(transferStatus > 0) {
					response.sendRedirect("accounts.jsp");
				}else if(transferStatus == -1) {
					response.sendRedirect("transfer.jsp?balance=0");
				}else {
					response.sendRedirect("transfer.jsp?success=0");
				}
			}
			
			
		}else {
			response.sendRedirect("transfer.jsp?success=0");
		}
	}

}
