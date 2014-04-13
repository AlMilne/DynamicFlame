<!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html lang="en">
<head>
<title>Dynamic Flame Badminton Club</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!--[if lt IE 9]>
	<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

</head>
<body onload='document.f.j_username.focus();'>
<body class="no-sidebar">

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
	</div>

	<!-- Nav -->
	<%@ include file="/WEB-INF/jsp/nav.jsp"%>

	<!-- Main -->
	<div class="container">
		<div class="row">
			<br>
			<br>
			<form id="loginForm" action="<c:url value='j_spring_security_check' />" method='POST' class="form-horizontal" style="margin-bottom: 150px;">
				<fieldset>

					<!-- Form Name -->
					<c:if test="${not empty error}">
						<div class="errorblock">
							Your login attempt was not successful, try again.<br />
						</div>
					</c:if>
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="username">Username</label>
						<div class="col-md-4">
							<input id="username" name="j_username" placeholder="username" class="form-control input-md" required="" type="text">

						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="password">Password</label>
						<div class="col-md-4">
							<input id="password" name="j_password" placeholder="password" class="form-control input-md" required="" type="password">

						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for=""></label>
						<div class="col-md-4">
							<button id="" name="" class="btn btn-primary">Login</button>
						</div>
					</div>

				</fieldset>
			</form>


		</div>
	</div>

	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>

	<!-- JavaScript  -->

	<script>
		$.validator.setDefaults({});

		$().ready(function() {

			// validate form on keyup and submit
			$("#loginForm").validate({
				errorClass : "loginError",
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

</body>
</html>