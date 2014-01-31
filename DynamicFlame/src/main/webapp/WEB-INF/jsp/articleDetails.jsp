<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News Stories</title>

</head>
<body>
	<h3>News Articles</h3>
	<div>
		<c:if test="${!articleList.firstPage}">
			<a href="articleDetails.html?page=previous"><b>&lt;&lt; Prev</b></a>
          </c:if>
		<c:if test="${!articleList.lastPage}">
			<a href="articleDetails.html?page=next"><b>Next &gt;&gt;</b></a>
		</c:if>
	</div>
	<c:if test="${!empty articleList}">
		<table class="data">
			<tr>
				<td>Articles: ${articleList.nrOfElements}</td>
			</tr>
			<tr>
				<th>Title</th>
				<th>Subtitle</th>
				<th>Contemt</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${articleList.pageList}" var="article">
				<tr>
					<td>${article.title}</td>
					<td>${article.subtitle}</td>
					<td>${article.content}</td>
					<td>${article.postedTime}</td>
					<td><a href="delete/${article.storyId}"
						onclick="return confirm('Are you sure you want to delete this document?')">Delete</a></td>
					<td><a href="edit/${article.storyId}">Edit</a></td>
				</tr>
				<c:if test="${articleList.nrOfElements == 0}">
					<tr>
						<td colspan="5">No Person Data</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</c:if>
</body>

</html>