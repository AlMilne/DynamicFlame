<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>

<html>
<head>
<title>Dynamic Flame Badminton Club</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script>
	$.validator.setDefaults({

	});

	$().ready(function() {

		// validate form on keyup and submit
		$("#emailForm").validate({
			
			invalidHandler : function(form, validator) {
				var errors = validator.numberOfInvalids();
				if (errors) {
					var message = errors == 1 ? 'Please correct the below error\n' : 'Please correct the below ' + errors + ' errors.\n';
					var errors = "";

					$("#errorsSummary").text(message + errors);
				}
				validator.focusInvalid();
			},
			rules : {
				subject : "required",
				message : "required"
			},

			messages : {
				subject : "Please enter a subject",
				message : "Please enter email message"
			}
		});
	});
</script>
</head>
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

		<!-- Nav -->
		<%@ include file="/WEB-INF/jsp/nav.jsp"%>
	</div>

	<!-- Main -->
	<div class="wrapper style4">

		<div class="container">
			<div class="row">
				<div class="12u skel-cell-important">
					<article id="main" class="special">
						<header style="margin-bottom: 0px;">
							<h2>Contact Us</h2>
							<span class="byline" style="margin-bottom: 0px;">For more information about the club please contact Norman Anthony on mobile XX XXXX XXXX.</span>
						</header>

						<div id="errorsSummary">&nbsp;</div>
						<form:form action="sendEmail.htm" commandName="email" id="emailForm">

							<form:label path="subject">
								<spring:message code="label.subject" />
							</form:label>
							<form:input path="subject" id="subject" class="glowing-border"></form:input>
							<form:errors path="subject" cssclass="error"></form:errors>
							<label for="subject" class="error">&nbsp;</label>
							
							<form:label path="message">
								<spring:message code="label.message" />
							</form:label>
							<form:textarea path="message" id="message" rows="5" class="glowing-border" ></form:textarea>
							<form:errors path="message" cssclass="error"></form:errors>
							<label for="message" class="error">&nbsp;</label>
							<br />

							<input type="submit" value="Send" class="button" />

						</form:form>

					</article>
				</div>
			</div>
			<hr />

		</div>
	</div>

	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>

</body>
</html>