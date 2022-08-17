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
 * Servlet implementation class DepositHandler
 */
@WebServlet("/DepositHandler")
public class DepositHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositHandler() {
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
			response.sendRedirect("deposit.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("account")!=null && request.getParameter("amount")!=null && Double.parseDouble(request.getParameter("amount"))>0) {
			AccountsDao acccdaoObj = new AccountsDao();
			int depositStatus = acccdaoObj.depositMoney(request.getParameter("account"),null, Double.parseDouble(request.getParameter("amount")));
			if(depositStatus>0) {
				response.sendRedirect("accounts.jsp");
			}else {
				response.sendRedirect("deposit.jsp?success=0");
			}
		}else {
			response.sendRedirect("deposit.jsp?success=0");
		}
	}

}
