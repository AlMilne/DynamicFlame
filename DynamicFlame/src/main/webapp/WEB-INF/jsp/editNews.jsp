<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Article</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/tinymce/tinymce.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
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

</body>

</html>