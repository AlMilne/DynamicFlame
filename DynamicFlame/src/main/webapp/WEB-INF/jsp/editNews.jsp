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

			<div id="errorsSummary"></div>
			<form:form commandName="newsArticle" action="update.htm" id="newsAdminForm" class="form-horizontal" style="margin-left: 5px;">
				<fieldset>
					<br />
					<div class="form-group">
						<form:label path="title" class="text-left col-xs-8 ">
							<spring:message code="label.title" />
						</form:label>
						<div class="col-xs-8">
							<form:input id="title" path="title" name="title" class="form-control input-md" type="text"></form:input>
						</div>
						<form:errors path="title" cssClass="error" />
					</div>
					<br />

					<div class="form-group">
						<form:label path="subtitle" class="col-xs-8 text-left">
							<spring:message code="label.subtitle" />
						</form:label>
						<div class="col-xs-8">
							<form:input path="subtitle" id="subtitle" name="subtitle" class="form-control input-md" type="text"></form:input>
						</div>
						<form:errors path="subtitle" cssclass="error"></form:errors>
					</div>
					<br />

					<div class="form-group">
						<form:label path="content" class="col-xs-8 text-left">
							<spring:message code="label.content" />
						</form:label>
						<div class="col-xs-8"> 
							<form:textarea id="content" path="content" rows="5" class="form-control input-md"></form:textarea>
						</div>
						<form:errors path="content" cssclass="error"></form:errors>
					</div>
					<br />
				</fieldset>

				<div class="form-group">
					<div class="col-xs-8">
						<button id="send" name="action" class="btn btn-primary" value="save">Save Changes</button>
					
						<button id="cancel" name="action" class="btn btn-primary" value="cancel">Cancel</button>
					</div>
				</div>


			</form:form>
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