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
						<a href="newsAdmin.html" class="newbutton">New Article</a> <a class="buttonLogin"
							href="<c:url value="/j_spring_security_logout" />">Logout</a>
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
						<p>The latest club's NEWSLETTER can be downloaded here.</p>
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
						<p>Tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum.</p>
						<div class="row half no-collapse">
							<div class="4u">
								<a href="http://mdomaradzki.deviantart.com/art/Air-Lounge-385212062" class="image full"><img src="images/pic10.jpg"
									alt="" /></a>
							</div>
							<div class="8u">
								<h4>Nibh sed cubilia</h4>
								<p>Amet nullam fringilla nibh nulla convallis tique ante proin.</p>
							</div>
						</div>
						<div class="row half no-collapse">
							<div class="4u">
								<a href="http://mdomaradzki.deviantart.com/art/Paris-City-Streets-II-382623606" class="image full"><img
									src="images/pic11.jpg" alt="" /></a>
							</div>
							<div class="8u">
								<h4>Proin sed adipiscing</h4>
								<p>Amet nullam fringilla nibh nulla convallis tique ante proin.</p>
							</div>
						</div>
						<div class="row half no-collapse">
							<div class="4u">
								<a href="http://mdomaradzki.deviantart.com/art/Trainride-Visions-383309985" class="image full"><img
									src="images/pic12.jpg" alt="" /></a>
							</div>
							<div class="8u">
								<h4>Lorem feugiat magna</h4>
								<p>Amet nullam fringilla nibh nulla convallis tique ante proin.</p>
							</div>
						</div>
						<div class="row half no-collapse">
							<div class="4u">
								<a href="http://mdomaradzki.deviantart.com/art/Paris-Metro-382623851" class="image full"><img src="images/pic13.jpg"
									alt="" /></a>
							</div>
							<div class="8u">
								<h4>Sed tempus fringilla</h4>
								<p>Amet nullam fringilla nibh nulla convallis tique ante proin.</p>
							</div>
						</div>
						<div class="row half no-collapse">
							<div class="4u">
								<a href="http://mdomaradzki.deviantart.com/art/Cliffs-of-Coogee-II-366961860" class="image full"><img
									src="images/pic14.jpg" alt="" /></a>
							</div>
							<div class="8u">
								<h4>Malesuada fermentum</h4>
								<p>Amet nullam fringilla nibh nulla convallis tique ante proin.</p>
							</div>
						</div>
						<footer>
							<a href="#" class="button">Magna Adipiscing</a>
						</footer>
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
										<a href="delete/${article.storyId}" onclick="return confirm('Are you sure you want to delete this article?')"
											class="button">Delete</a>
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