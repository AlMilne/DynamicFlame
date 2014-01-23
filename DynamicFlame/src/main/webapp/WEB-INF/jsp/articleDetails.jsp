<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News Stories</title>

</head>
<body>
	<p>Article title is ${article.title}. Subtitle is
		${article.subtitle}.Content is ${article.content}</p>

	<h3>News Articles</h3>
	<c:if test="${!empty articleList}">
		<table class="data">
			<tr>
				<th>Title</th>
				<th>Subtitle</th>
				<th>Contact</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${articleList}" var="article">
				<tr>
					<td>${article.title}</td>
					<td>${article.subtitle}</td>
					<td>${article.content}</td>
					<td><a href="delete/${article.story_id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>

</html>