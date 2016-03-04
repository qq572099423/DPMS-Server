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
<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" media="all">
<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-reset.css"/>"> --%>
<link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet"
	type="text/css" media="all">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/font-awesome.css"/>">
<!-- start:jquery -->
<script src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/supersized.3.2.7.min.js"/>"></script>
<script src="<c:url value="/resources/js/supersized-init.js"/>"></script>
<script src="<c:url value="/resources/js/login.js"/>"></script>
<script src="<c:url value="/resources/js/custom.js"/>"></script>

<script type="text/javascript">
	function submitByEnter() {
		if (event.keyCode == 13) {
			$('#login').click();
		}
	}
	$(function() {
		$('#login').click(function() {
			var json = {
				'username' : $('#username').val(),
				'password' : $('#password').val()
			};
			$.ajax({
				url : '<c:url value="/account/login.ajax"/>',
				type : 'GET',
				data : json,
				success : function(data) {
					if (data.hasSuccess == true)
						window.location.href = '<c:url value="/home/home.html"/>';
				}
			});

		});
	});
</script>
</head>
<body onkeydown="submitByEnter();">
	<div class="mask">
		<h2>
			<a href="#"><img class="dp-logo"
				src="<c:url value='/resources/img/dp.png'/>" /></a> <b>上海迪普自动化技术有限公司</b>
		</h2>
	</div>
	<div id="msgArea" class="msgArea">
		<span class="msg"></span>
	</div>
	<div class="page-container">
		<h1>登录</h1>
		<div class="form">
			<input id="username" type="text" name="username" class="username"
				placeholder="用户名"> <input id="password" type="password"
				name="password" class="password" placeholder="密码">
			<button id="login">提交</button>
		</div>
	</div>
</body>
</html>