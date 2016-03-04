<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html class="login">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>系统出错</title>
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/font-awesome.css"/>">
<style type="text/css">
body {
	background: rgb(25, 73, 94);
}

.container-fluid {
	margin-top: 10%;
	color: #fff;
}
.container-fluid h2 i{
	font-size: 50px;
}
ul {
	line-height: 40px;
}
</style>
<!-- start:jquery -->
<script src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-5 col-md-offset-4">
				<h2>
					<i class="fa fa-frown-o"></i> 系统好像生病了					
				</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5 col-md-offset-4">
				<h3>
					病情如下：${error}				
				</h3>
			</div>
		</div>
		

	</div>
</body>
</html>