<%@ include file="header.jsp" %>
<%@page import="com.ssbank.dao.AccountsDao"%>
<%@page import="java.util.List"%>

<%
	HttpSession userSession = request.getSession(true);
	User currentUser = (User)userSession.getAttribute("user");
%>
<div class="row main-contecnt-accounts">
	<%@ include file="navbar.jsp" %>
	<div class="col-md-7 col-lg-8 col-xl-9">
        <div class="row">
            <div class="col-md-12">
                <div class="card dash-card">
                    <div class="card-body">
                    	<h4 class="text-center mb-5">Transfer Funds</h4>
                    	<form action="TransferHandler" method="POST">
	                    	<div class="row">
	                    		<div class="col-25">
							 		<label><b>Amount</b></label> 
							 	</div>
							 	<div class="col-50">
							 		<input class="long-text" type="text" placeholder="$0.00" name="amount" required> 
							 	</div>
							</div>
							<div class="row">
	                    		<div class="col-25">
							 		<label><b>From Account</b></label> 
							 	</div>
							 	<div class="col-50">
							 		<select type="select" name="account" required>
								 		<%
									 		AccountsDao accountsObj = new AccountsDao();
		                                	List <Account> accountList = accountsObj.getAccountbyParam(currentUser.getUser_id(), null);
		                                	for(int i=0;i<accountList.size();i++){
		                                		if(accountList.get(i).getAccount_type().equals("checking")){
		                                			out.print("<option id=\"checking\" value=\""+accountList.get(i).getAccount_number()+"\">");
		                                			out.print("checking : "+accountList.get(i).getAccount_number());
		                                			out.print("</option>"); 
		                                		}
		                                		if(accountList.get(i).getAccount_type().equals("savings")){
		                                			out.print("<option id=\"savings\" value=\""+accountList.get(i).getAccount_number()+"\">");
		                                			out.print("savings : "+accountList.get(i).getAccount_number());
		                                			out.print("</option>"); 
		                                		}
		                                	}
								 		%>
							 		</select> 
							 	</div>
							</div>
							<div class="row">
	                    		<div class="col-25">
							 		<label><b>Beneficiary Email</b></label> 
							 	</div>
							 	<div class="col-50">
							 		<input class="long-text" type="text" placeholder="someone@email.com" name="email" required> 
							 	</div>
							</div>
							<div class="row">
								<div class="col text-center mt-5">
									<input type="submit" value="transfer"class="btn btn-primary"/>
								</div>
							</div>
                    	</form>
                    	<% 
                    	if(request.getParameter("success")!=null && Integer.parseInt(request.getParameter("success"))==0){ 
	                    	out.print("<div class=\"error mt-2\"><p class=\"text-center text-danger\">Transaction Incomplete! Please try again!</p></div>");
						}
                    	if(request.getParameter("balance")!=null && Integer.parseInt(request.getParameter("balance"))==0){ 
	                    	out.print("<div class=\"error mt-2\"><p class=\"text-center text-danger\">Not Enough Balance.</p></div>");
						}
                    	if(request.getParameter("beneficiary")!=null && Integer.parseInt(request.getParameter("beneficiary"))==0){ 
	                    	out.print("<div class=\"error mt-2\"><p class=\"text-center text-danger\">No Such Beneficiary Exists!</p></div>");
						}
						%>
                    </div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>