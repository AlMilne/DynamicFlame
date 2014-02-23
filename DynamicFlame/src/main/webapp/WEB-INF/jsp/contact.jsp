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
				<div class="12u skel-cell-important" id="content">
					<article id="main" class="special">
						<header>
							<h2>Contact Us</h2>
							<span class="byline">For more information about the club please contact Norm Anthony on mobile XX XXXX XXXX.</span>
						</header>


						<form:form action="/sendEmail.htm" commandName="email" style="margin-left: 10em;" id="emailForm">
							<form:label path="recipient">
								<spring:message code="label.recipient" />
							</form:label>
							<form:input path="recipient" id="recipient"></form:input>
							<form:errors path="recipient" cssClass="error" />
							<br />

							<form:label path="subject">
								<spring:message code="label.subject" />
							</form:label>
							<form:input path="subject" id="subject"></form:input>
							<form:errors path="subject" cssclass="error"></form:errors>
							<br />

							<form:label path="message">
								<spring:message code="label.message" />
							</form:label>
							<form:textarea path="message" id="message" rows="5" style="width: 50em; background: #fff; border: 1px solid;"></form:textarea>
							<form:errors path="message" cssclass="error"></form:errors>
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