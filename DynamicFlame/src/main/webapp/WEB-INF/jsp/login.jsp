<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE HTML>

<html>
<head>
<title>Dynamic Flame Badminton Club</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC-aQPwDQ4SB1xM8HwK3p-BPVBPBH9mTuA&sensor=false">
	
</script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>

<script>
	$.validator.setDefaults({});

	$().ready(function() {

		// validate form on keyup and submit
		$("#loginForm").validate({
			errorClass: "loginError",
			rules : {
				j_username : "required",
				j_password : "required"
			},
			messages : {
				j_username : "Please enter username",
				j_password : "Please enter password"
			}
		});
	});
</script>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
.loginError {
    color:#FF0000;
}
</style>
</head>
<body onload='document.f.j_username.focus();'>

	<!-- Header -->
	<div id="header">

		<!-- Inner -->
		<div class="inner">
			<header>
				<h1>
					<a href="#" id="logo">Dynamic Flame</a>
				</h1>
			</header>
		</div>

		<!-- Nav -->
		<%@ include file="/WEB-INF/jsp/nav.jsp"%>

		<!-- Main -->
		<div class="wrapper style4">

			<c:if test="${not empty error}">
				<div class="errorblock">
					Your login attempt was not successful, try again.<br />
				</div>
			</c:if>

			<form id="loginForm" action="<c:url value='j_spring_security_check' />" method='POST' style="color: black;">
				<div class="row">
					<div class="-2u 7u">
						<label for="username">Username </label>
					</div>
					<div class="-3u 6u">
						<input name="j_username" id="username">
					</div>
				</div>

				<div class="row" >
					<div class="-2u 7u">
						<label for="password">Password </label>
					</div>
					<div class="-3u 6u" style="padding-top: 0em;">
						<input name="j_password" id="password" type="password">
					</div>
				</div>
				<br /> <input type="submit" value="Login" class="button" />
			</form>
		</div>
	</div>

	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>