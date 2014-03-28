<!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html lang="en">
<head>
<title>Dynamic Flame Badminton Club</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>
<body>
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

	<div class="container">
		<div class="row">
			<div class="12u skel-cell-important">
				<div id="errorsSummary"></div>
				<form:form commandName="newsArticle" action="update.htm" id="newsAdminForm">
					<form:label path="title">
						<spring:message code="label.title" />
					</form:label>
					<form:input path="title" id="title" class="glowing-border"></form:input>
					<form:errors path="title" cssClass="error" />
					<br />

					<form:label path="subtitle">
						<spring:message code="label.subtitle" />
					</form:label>
					<form:input path="subtitle" id="subtitle" class="glowing-border"></form:input>
					<form:errors path="subtitle" cssclass="error"></form:errors>
					<br />

					<form:label path="content">
						<spring:message code="label.content" />
					</form:label>
					<form:textarea path="content" id="content" rows="5" class="glowing-border"></form:textarea>
					<form:errors path="content" cssclass="error"></form:errors>
					<br />

					<input type="submit" value="Save Changes" class="button" />

				</form:form>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/tinymce/tinymce.min.js"></script>
	
	<!-- JavaScript  -->

	<script>
	tinymce.init({
		selector : "textarea"
	});

	$.validator.setDefaults({

	});

	$().ready(function() {

		// validate form on keyup and submit
		$("#newsAdminForm").validate({
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
				title : "required",
				subtitle : "required",
				content : "required"
			},
			messages : {
				title : "Please enter article title",
				subtitle : "Please enter article subtitle",
				content : "Please enter article content"
			}
		});
	});
	</script>

</body>

</html>