<%@page import="com.ssbank.model.User"%>
<%@page import="com.ssbank.model.Account"%>
<%@page import="com.ssbank.dao.AccountsDao"%>
<%@page import="java.util.UUID"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp" %>

<h3 class="home-welcome text-center">
    <%
	    HttpSession userSession = request.getSession(true);
	    User currentUser = (User)userSession.getAttribute("user");
	   
        if(userSession.getAttribute("user")!=null && currentUser.toString().length()!=0){
            out.print("Welcome "+currentUser.getFist_name()+" "+currentUser.getLast_name()+"!");
        }
    %>
</h3>
<div class="row main-contecnt-accounts">
    <%@ include file="navbar.jsp" %>
    <div class="col-md-7 col-lg-8 col-xl-9">
    
        <div class="row">
            <div class="col-md-12">
                <div class="card dash-card">
                    <div class="card-body">
                    	<h4 class="text-center mb-5">Accounts Summary</h4>
                        <div class="row">
                            <div class="col-md-6 col-lg-6 text-center">
                            	<div class="card dash-card account-details">
                    				<div class="card-body">
		                                Checking Account
		                                <div class="mt-3">
			                                <% 
												AccountsDao accountsObj = new AccountsDao();
			                                	List <Account> accountList = accountsObj.getAccountbyParam(currentUser.getUser_id(), null);
			                                	for(int i=0;i<accountList.size();i++){
			                                		if(accountList.get(i).getAccount_type().equals("checking")){
			                                			out.print("<p>");
			                                			out.print(accountList.get(i).getAccount_number());
			                                			out.print("</p>");
			                                			out.print("<p>");
			                                			double amountSav = accountList.get(i).getAccount_balance();
														Locale localeSav = new Locale("en", "US");      
														NumberFormat currencyFormatterSav = NumberFormat.getCurrencyInstance(localeSav);
														out.print(currencyFormatterSav.format(amountSav));
														out.print("</p>");
			                                		}
			                                	}
			                                %>
		                                </div>
	                                </div>
								</div>
                            </div>
                   
                            <div class="col-md-6 col-lg-6 text-center">
                            	<div class="card dash-card account-details">
                    				<div class="card-body">
		                                Savings Account
		                                <p class="mt-3">
			                                <% 
			                                	if(accountList.size()==1){
			                                		out.print("<a href=\"SavingsAcccountCreator\" class=\"btn btn-primary\">Create</a></p>");
			                                	}else{
					                                for(int i=0;i<accountList.size();i++){
				                                		if(accountList.get(i).getAccount_type().equals("savings")){
				                                			out.print("<p>");
				                                			out.print(accountList.get(i).getAccount_number());
				                                			out.print("</p>");
				                                			
				                                			out.print("<p>");
				                                			double amountSav = accountList.get(i).getAccount_balance();
															Locale localeSav = new Locale("en", "US");      
															NumberFormat currencyFormatterSav = NumberFormat.getCurrencyInstance(localeSav);
															out.print(currencyFormatterSav.format(amountSav));
															out.print("</p>");
				                                		}
				                                	}
			                                	}
		                                	%>
		                                </p>
									</div>
								</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="footer.jsp" %>