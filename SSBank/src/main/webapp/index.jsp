<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<title>SS Bank</title>

	<link type="image/x-icon" href="assets/img/favicon.png" rel="icon">

	<link rel="stylesheet" href="assets/css/bootstrap.min.css">

	<link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
	<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="stylesheet" href="assets/css/newstyle.css">
</head>
<body>

	<div class="main-wrapper">

		<header class="header">
			<nav class="navbar navbar-expand-lg header-nav">
				<div class="navbar-header logo-placement">
					
					<a href="index.html" class="navbar-brand logo">
						<img src="assets/img/logo.png" class="img-fluid" alt="Logo">
					</a>
				</div>

				<ul class="nav header-navbar-rht">
					<li class="nav-item">
						<a class="nav-link header-login" href="login.jsp">Login</a>
					</li>
					<li class="nav-item">
						<a class="nav-link header-login" href="register.jsp">Signup </a>
					</li>
				</ul>
			</nav>
		</header>


		<section class="section section-search">
			<div class="container-fluid">
				<div class="banner-wrapper home-banner">
					<h1 class="banner-text">Go With SSBank Anywhere You Go!</h1>
				</div>
			</div>
		</section>
		<section>
			<div class="container-fluid">
				<div class="home-features-wrapper">
					<div class="row">
						<div class="col-md-4 text-center">
							<i class="fa fa-shield-alt"></i>
							<p>A FINANCIAL INSTITUTION PCI DSS 3.2 CERTIFIED</p>
						</div>
						<div class="col-md-4 text-center">
							<i class="fa fa-fighter-jet"></i>
							<p>FASTER THAN YOUR CURRENT BANK</p>
						</div>
						<div class="col-md-4 text-center">
							<i class="fa fa-child"></i>
							<p>EASY AND FAST ACCOUNT SETUP</p>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>

<%@ include file="footer.jsp" %>