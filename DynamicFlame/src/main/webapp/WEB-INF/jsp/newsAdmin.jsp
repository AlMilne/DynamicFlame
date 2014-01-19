<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"/>
<title>News Stories</title>

</head>
<body>
	<form:form commandName="newsArticle" action="articleDetails.htm">
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
		<form:textarea path="content" id="content" rows="5"></form:textarea>
		<form:errors path="content" cssclass="error"></form:errors>
		<br />

		<input type="submit" value="Save Changes" />

	</form:form>

</body>

</html>