<%@page import="com.ssbank.model.User"%>
<%@page import="java.util.UUID"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
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
    <div class="col-md-5 col-lg-4 col-xl-3 theiaStickySidebar">
        <div class="profile-sidebar">
    
            <div class="dashboard-widget">
                <nav class="dashboard-menu">
                    <ul>
                    
                    	<li class="active">
                            <a href="doctor-dashboard.html">
                                <i class="fas fa-columns"></i>
                                <span>Accounts Summary</span>
                            </a>
                        </li>
                        
                        <li>
                            <a href="doctor-dashboard.html">
                                <i class="fas fa-columns"></i>
                                <span>Deposit Funds</span>
                            </a>
                        </li>
        
                        <li>
                            <a href="appointments.html">
                            <i class="fas fa-calendar-check"></i>
                            <span>Withdraw Funds</span>
                            </a>
                        </li>
                        <li>
                            <a href="my-patients.html">
                            <i class="fas fa-user-injured"></i>
                            <span>Transfer Funds</span>
                            </a>
                        </li>
                    
                        <li>
                            <a href="index.html">
                            <i class="fas fa-sign-out-alt"></i>
                            <span>Logout</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <div class="col-md-7 col-lg-8 col-xl-9">
    
        <div class="row">
            <div class="col-md-12">
                <div class="card dash-card">
                    <div class="card-body">
                    	<h4 class="text-center mb-5">Accounts Summary</h4>
                        <div class="row">
                            <div class="col-md-6 col-lg-6 text-center">
                            	<a href="accountDetails?type=checking">
	                            	<div class="card dash-card">
	                    				<div class="card-body">
			                                Savings Account
			                                <p class="mt-3">
			                                <% 
			                                	UUID uuid = UUID.randomUUID();
			                                	out.print("ss"+uuid.toString().replace("-", ""));
			                                %>
			                                </p>
			                                <p>
			                                <%
				                                double amountSav =21000.0;
												Locale localeSav = new Locale("en", "US");      
												NumberFormat currencyFormatterSav = NumberFormat.getCurrencyInstance(localeSav);
												out.print(currencyFormatterSav.format(amountSav));
			                                %>
			                                </p>
		                                </div>
									</div>
								</a>
                            </div>
                   
                            <div class="col-md-6 col-lg-6 text-center">
                            	<a href="accountDetails?type=checking">
	                            	<div class="card dash-card">
	                    				<div class="card-body">
			                                Checking Account
			                                <p class="mt-3">
			                                <% 
			                                	UUID uuid2 = UUID.randomUUID();
			                                	out.print("ss"+uuid2.toString().replace("-", ""));
			                                %>
			                                </p>
			                                
			                                <p>
			                                <% 
				                                double amount =2000.0;
												Locale locale = new Locale("en", "US");      
												NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
												out.print(currencyFormatter.format(amount));
			                                %>
			                                </p>
										</div>
									</div>
								</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="footer.jsp" %>