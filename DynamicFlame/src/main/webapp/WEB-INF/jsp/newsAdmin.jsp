<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News Stories</title>

<form:form method="post" commandName="news-article" action="articleDetails.htm">
	<table>
		<tr>
			<td>Title:</td>
			<td><form:input path="title" /></td>
		</tr>
		<tr>
			<td>Subtitle:</td>
			<td><form:input path="subtitle" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save Changes" /></td>
		</tr>
	</table>
</form:form>
</head>
<body>

</body>

</html>