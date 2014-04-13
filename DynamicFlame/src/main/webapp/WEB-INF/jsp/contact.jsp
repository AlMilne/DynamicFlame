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
		<div class="row text-center">
			<header style="margin-bottom: 0px;">
				<h2>Contact Us</h2>
				<span class="byline" style="margin-bottom: 0px;">For more information about the club please contact Norman Anthony on mobile XX
					XXXX XXXX.</span>
			</header>

			<div id="errorsSummary" class="text-center">&nbsp;</div>
			<br>
			<form:form action="sendEmail.htm" commandName="email" id="emailForm" class="form-horizontal">
				<fieldset>
					<!-- Text input-->
					<div class="form-group">
						<form:label path="yourEmail" class="col-md-4 control-label">
							<spring:message code="label.yourEmail" />
						</form:label>
						<div class="col-md-4">
							<input id="yourEmail" name="yourEmail" placeholder="Your email address" class="form-control input-md" type="text">
						</div>
						<form:errors path="yourEmail" cssclass="error"></form:errors>
						<label for="yourEmail" class="error">&nbsp;</label>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<form:label path="subject" class="col-md-4 control-label">
							<spring:message code="label.subject" />
						</form:label>
						<div class="col-md-4">
							<input id="subject" name="subject" placeholder="Subject of your message" class="form-control input-md" type="text">
						</div>
						<form:errors path="subject" cssclass="error"></form:errors>
						<label for="subject" class="error">&nbsp;</label>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<form:label path="message" class="col-md-4 control-label">
							<spring:message code="label.message" />
						</form:label>
						<div class="col-md-4">
							<textarea id="message" name="message" placeholder="Your message content" class="form-control input-md"></textarea>
						</div>
						<form:errors path="message" cssclass="error"></form:errors>
						<label for="message" class="error">&nbsp;</label>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="send"></label>
						<div class="col-md-4">
							<button id="send" name="send" class="btn btn-primary">Send</button>
						</div>
					</div>


				</fieldset>

			</form:form>
		</div>
		<hr />

	</div>

	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>

	<!-- JavaScript  -->

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
					yourEmail : {
						required : true,
						email : true
					},
					subject : "required",
					message : "required"
				},

				messages : {
					yourEmail : "Please enter your email address",
					subject : "Please enter a subject",
					message : "Please enter email message"
				}
			});
		});
	</script>


</body>
</html>