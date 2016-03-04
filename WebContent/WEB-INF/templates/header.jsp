<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- start:navbar top -->
<header class="header" style="    display: block;">
	<a href="#" class="logo"> <!-- <i class="fa fa-pied-piper-alt"></i> -->
		©上海迪普
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<a href="#" class="navbar-btn sidebar-toggle" data-target="#atas"
			data-toggle="offcanvas" role="button"> <span class="sr-only">Toggle
				navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</a>
		<div class="collapse navbar-collapse" id="atas">
			<div class="navbar-left">
				<ul class="nav navbar-nav">
					<li class="dropdown messages-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="fa fa-envelope"></i> <span class="label label-success">4</span>
					</a>
						<ul class="dropdown-menu">
							<li class="header">You have 4 messages</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<div class="slimScrollDiv"
									style="position: relative; overflow: hidden; width: auto; height: 200px;">
									<ul class="menu"
										style="overflow: hidden; width: 100%; height: 200px;">
										<li>
											<!-- start message --> <a href="#">
												<div class="pull-left">
													<img src="" class="img-circle" alt="User Image">
												</div>
												<h4>
													Support Team <small><i class="fa fa-clock-o"></i> 5
														mins</small>
												</h4>
												<p>Why not buy a new awesome theme?</p>
										</a>
										</li>
										<!-- end message -->
									</ul>
									<div class="slimScrollBar"
										style="width: 3px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 0px; z-index: 99; right: 1px; background: rgb(0, 0, 0);"></div>
									<div class="slimScrollRail"
										style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 0px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
								</div>
							</li>
							<li class="footer"><a href="#">See All Messages</a></li>
						</ul></li>
					<li class="dropdown tasks-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="fa fa-tasks"></i> <span class="label label-danger">9</span>
					</a>
						<ul class="dropdown-menu">
							<li class="header">You have 9 tasks</li>
							<li>
								<!-- inner menu: contains the actual data -->
								<div class="slimScrollDiv"
									style="position: relative; overflow: hidden; width: auto; height: 200px;">
									<ul class="menu"
										style="overflow: hidden; width: 100%; height: 200px;">
										<li>
											<!-- Task item --> <a href="#">
												<h3>
													Design some buttons <small class="pull-right">20%</small>
												</h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-aqua"
														style="width: 20%" role="progressbar" aria-valuenow="20"
														aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">20% Complete</span>
													</div>
												</div>
										</a>
										</li>
										<!-- end task item -->										
									</ul>
									<div class="slimScrollBar"
										style="width: 3px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 0px; z-index: 99; right: 1px; background: rgb(0, 0, 0);"></div>
									<div class="slimScrollRail"
										style="width: 3px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 0px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
								</div>
							</li>
							<li class="footer"><a href="#">View all tasks</a></li>
						</ul></li>
					<li class="form-search"><input type="text"
						class="form-control" placeholder="Search.."></li>
				</ul>
			</div>
			<div class="navbar-right">			
				<ul class="nav navbar-nav">
					<li class="icon-spinner"> </li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <img src=""
							class="img-circle img-responsive img-user"> <strong>@john</strong>
					</a>
						<ul class="dropdown-menu dropdown-login">
							
							<li>
								<div class="navbar-login">
									<div class="row">
										<div class="col-lg-3">
											<p class="text-center">
												<img src="" class="img-responsive img-circle">
											</p>
										</div>
										<div class="col-lg-9">
											<p class="text-left">
												<strong>John Doe</strong>
											</p>
											<p class="text-left small">johndoe@email.com</p>
											<div class="row">
												<div class="col-md-6">
													<small><a href="#">Edit Profile</a></small>
												</div>
												<div class="col-md-6">
													<small><a href="#">Notification</a></small>
												</div>
											</div>
										</div>
									</div>
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="navbar-login navbar-login-session">
									<a href="#" class="btn btn-default btn-square btn-block"
										data-original-title="" title="">Logout</a>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
</header>
<!-- end:navbar top -->