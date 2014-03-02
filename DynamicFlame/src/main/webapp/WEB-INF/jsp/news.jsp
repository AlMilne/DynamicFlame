<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>

<html>
<head>
<title>Dynamic Flame Badminton Club</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600" rel="stylesheet" type="text/css" />
</head>
<body class="left-sidebar">

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
				<sec:authorize access="isAuthenticated()">
					<div class="-9u 3u">
						<a href="newsAdmin.html" class="newbutton">New Article</a> <a class="buttonLogin" href="<c:url value="/j_spring_security_logout" />">Logout</a>
					</div>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<div class="-9u 3u">
						<a class="buttonLogin" href="login.html"> Login</a>
					</div>
				</sec:authorize>
				<div class="4u" id="sidebar">
					<hr class="first" />
					<section>
						<header>
							<h3>
								<a href="#">News Letter</a>
							</h3>
						</header>
						<p>Download the club's latest newsletter.</p>
						<footer>
							<a href="${contextPath}resources/docs/dfbc_7th_newsletter.pdf" class="button">Download</a>
						</footer>
					</section>
					<hr />
					<section>
						<header>
							<h3>
								<a href="#">Popular articles</a>
							</h3>
						</header>
						<p>The hottest news articles right now.</p>
						<c:if test="${!empty mostPopular}">
							<c:forEach items="${mostPopular}" begin="0" end="3" var="article">

								<div class="row half no-collapse">
									<div class="4u">
										<img src="${contextPath}resources/images/shuttle_icon.gif" alt="shuttle icon" style="margin: 10px;" /></a>
									</div>
									<div class="8u">
										<h4>${article.title}</h4>
										<p>${article.subtitle}</p>
									</div>
								</div>

							</c:forEach>
						</c:if>
					</section>
				</div>
				<div class="8u skel-cell-important" id="content">
					<article id="main">
						<h2>Club News</h2>
						<c:if test="${!empty articleList}">
							<c:forEach items="${articleList.pageList}" var="article">
								<section>
									<h3>${article.title}</h3>
									<span class="byline"><fmt:formatDate pattern="EEEE, dd MMMM yyyy, HH:mm " value="${article.postedTime}" /></span>
									<p>${article.subtitle}</p>
									<p>${article.content}</p>
									<sec:authorize access="isAuthenticated()">
										<a href="delete/${article.storyId}" onclick="return confirm('Are you sure you want to delete this article?')" class="button">Delete</a>
										<a href="edit/${article.storyId}" class="buttonEdit">Edit</a>
									</sec:authorize>
								</section>

								<c:if test="${articleList.nrOfElements == 0}">
									<p>No Person Data</p>
								</c:if>
							</c:forEach>
						</c:if>
						<div>
							<c:if test="${!articleList.firstPage}">
								<a href="news.html?page=previous"><b>&lt;&lt; Prev</b></a>
							</c:if>
							<c:if test="${!articleList.lastPage}">
								<a href="news.html?page=next"><b>Next &gt;&gt;</b></a>
							</c:if>
						</div>
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