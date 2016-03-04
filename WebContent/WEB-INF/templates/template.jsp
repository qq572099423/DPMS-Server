<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en" style="min-height: 1330px;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<c:set var="title">
	<tiles:insertAttribute name="title" />
</c:set>
<title><spring:message code="${title}"></spring:message></title>
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" media="all">
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"
	type="text/css" media="all">
<%-- <link href="<c:url value="/resources/css/contest.css"/>"
	rel="stylesheet" type="text/css" media="all"> --%>

<!-- start:bootstrap v3.2.0 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<!-- start:bootstrap reset -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap-reset.css"/>">
<!-- start:style arjuna -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/tree-menu.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/owl.carousel.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/owl.theme.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/owl.transitions.css"/>">
<!-- start:font awesome v4.1.0 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/font-awesome.css"/>">

<!-- start:javascript for all pages -->
<!-- start:jquery -->
<script src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
<!-- start:bootstrap -->
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<!-- start:arjuna.js -->
<script src="<c:url value="/resources/js/tree-menu.js"/>"></script>
<!-- start:validate.js -->
<script src="<c:url value="/resources/js/validate.js"/>"></script>
<!-- start:custom.js -->
<script src="<c:url value="/resources/js/custom.js"/>"></script>
<!-- end:javascript for all pages-->
</head>
<body class="cl-default fixed" style="min-height: 1330px;">
	<!-- start:navbar top -->
	<tiles:insertAttribute name="header" />
	<!-- end:navbar top -->
	<!-- start:wrapper body -->
	<div class="wrapper row-offcanvas row-offcanvas-left"
		style="min-height: 287px;">
		<!-- start:left sidebar -->
		<aside class="left-side sidebar-offcanvas" style="min-height: 1330px;">
			<div class="slimScrollDiv"
				style="position: relative; overflow: hidden; width: auto; height: 885px;">
				<section class="sidebar"
					style="overflow: hidden; width: auto; height: 885px;">
					<!-- Sidebar user panel -->
					<div class="user-panel">
						<div style="color: #fff">欢迎您，汪鹏</div>
					</div>

					<!-- sidebar menu: : style can be found in sidebar.less -->
					<ul class="sidebar-menu">
						<li style="background: #2c3e50;"><a> </a></li>
						<li class="treeview"><a href=""> <i class="fa fa-cog"></i>
								<span>Component</span> <i class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/todo-list.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Todo List</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/draggable-portlet.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Draggable Portlet</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/nestable.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Nestable</a></li>
							</ul></li>
						<li class="treeview"><a href=""> <i
								class="fa fa-bar-chart-o"></i> <span>Charts</span> <i
								class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/morris.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Morris</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/xchart.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										XChart</a></li>
							</ul></li>
						<li class="treeview"><a
							href="http://bootemplates.com/themes/arjuna/#"> <i
								class="fa fa-laptop"></i> <span>UI Elements</span> <i
								class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/general.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										General</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/icons.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Icons</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/button.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Buttons</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/slider.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Sliders</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/timeline.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Timeline</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/typography.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Typography</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/grid.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Grid</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/panel-well.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Panel &amp; Well</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/collapse.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Collapse</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/list-media.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										List Media</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/popup-notif.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Popup &amp; Notification</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/jumbotron-thumbnail.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Jumbotron &amp; Thumbnail</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/breadcrumb-pagination.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Breadcrumb &amp; Pagination</a></li>
							</ul></li>
						<li class="treeview"><a
							href="http://bootemplates.com/themes/arjuna/#"> <i
								class="fa fa-edit"></i> <span>Forms</span> <i
								class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/form-component.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Form Component</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/advance-component.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Advance Component</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/form-wizard.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Form Wizard</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/form-validation.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Form Validation</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/dropzone-file-upload.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Dropzone File Upload</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/multiple-file-upload.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Multiple File upload</a></li>
							</ul></li>
						<li class="treeview"><a
							href="http://bootemplates.com/themes/arjuna/#"> <i
								class="fa fa-table"></i> <span>Tables</span> <i
								class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/basic-table.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Basic Table</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/responsive-table.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Responsive Table</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/dynamic-table.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Dynamic Tables</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/editable-table.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Editable Table</a></li>
							</ul></li>
						<li class="treeview"><a
							href="http://bootemplates.com/themes/arjuna/#"> <i
								class="fa fa-calendar"></i> <span>Calendar</span> <i
								class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/basic-calendar.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Basic Calendar</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/language-calendar.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Language Calendar</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/drag-calendar.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Dragging Calendar</a></li>
							</ul></li>
						<li class="treeview"><a
							href="http://bootemplates.com/themes/arjuna/#"> <i
								class="fa fa-home"></i> <span>Property</span> <i
								class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/property.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Property</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/property-column.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Property Column</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/property-detail.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Property Detail</a></li>
							</ul></li>
						<li class="treeview"><a
							href="http://bootemplates.com/themes/arjuna/#"> <i
								class="fa fa-shopping-cart"></i> <span>Store</span> <i
								class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/store.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Store List</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/store-detail.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Store Detail</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/shopping-cart.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Shopping Cart</a></li>
							</ul></li>
						<li class="treeview"><a
							href="http://bootemplates.com/themes/arjuna/#"> <i
								class="fa fa-envelope"></i> <span>Mailbox</span> <i
								class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/inbox.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Inbox</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/inbox-detail.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Inbox Detail</a></li>
							</ul></li>
						<li class="treeview"><a
							href="http://bootemplates.com/themes/arjuna/#"> <i
								class="fa fa-comments"></i> <span>Chat Room</span> <i
								class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/lobby.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Lobby</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/chat-room.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Chat Room</a></li>
							</ul></li>
						<li class="treeview"><a
							href="http://bootemplates.com/themes/arjuna/#"> <i
								class="fa fa-folder"></i> <span>Extras Pages</span> <i
								class="fa fa-angle-left pull-right"></i>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="http://bootemplates.com/themes/arjuna/invoice.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Invoice</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/login.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Login</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/register.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Register</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/forgot-password.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Forgot Password</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/lockscreen.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Lockscreen</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/404.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										404 Error</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/500.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										500 Error</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/blank.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										Blank Page</a></li>
								<li><a
									href="http://bootemplates.com/themes/arjuna/faq.html"
									style="margin-left: 10px;"><i class="fa fa-circle-o"></i>
										FAQ</a></li>
							</ul></li>
					</ul>
					<div class="project-sidebar">
						<tiles:insertAttribute name="footer" />
					</div>
				</section>
				<div class="slimScrollBar"
					style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 0px; z-index: 99; right: 1px; height: 658.245px; background: rgba(0, 0, 0, 0.2);"></div>
				<div class="slimScrollRail"
					style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 0px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
			</div>
		</aside>
		<!-- end:left sidebar -->
		<!-- start:right sidebar -->
		<aside class="right-side">
			<div id="msgArea" class="msgArea">				
				<span class="msg"></span>
			</div>
			<section class="content">
				<div class="row">
					<!-- start:content -->
					<tiles:insertAttribute name="body" />
					<!-- end:content -->
				</div>
			</section>
		</aside>
		<!-- end:right sidebar -->
	</div>
	<!-- end:wrapper body -->
</body>
</html>
