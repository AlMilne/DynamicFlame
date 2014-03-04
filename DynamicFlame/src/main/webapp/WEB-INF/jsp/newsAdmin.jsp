<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>New Article</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>

<script>
	$.validator.setDefaults({});

	$().ready(function() {

		// validate form on keyup and submit
		$("#newsAdminForm").validate({
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

	<div id="errorsSummary"></div>
	<form:form commandName="newsArticle" action="news.htm" id="newsAdminForm" style="margin-left: 10em;">
		<form:label path="title">
			<spring:message code="label.title" />
		</form:label>
		<form:input path="title" id="title"></form:input>
		<form:errors path="title" cssClass="error" />
		<br />

		<form:label path="subtitle">
			<spring:message code="label.subtitle" />
		</form:label>
		<form:input path="subtitle" id="subtitle"></form:input>
		<form:errors path="subtitle" cssclass="error"></form:errors>
		<br />

		<form:label path="content">
			<spring:message code="label.content" />
		</form:label>
		<form:textarea path="content" id="content" rows="5" style="width: 50em; background: #fff; border: 1px solid;"></form:textarea>
		<form:errors path="content" cssclass="error"></form:errors>
		<br />

		<input type="submit" value="Save article" class="button" />

	</form:form>

	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>

</body>

</html>