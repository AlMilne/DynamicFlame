<!DOCTYPE HTML>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<title>Dynamic Flame Badminton Club</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="Dynamic flame badminton club news. All the latest news and info from the club.">
<META NAME="ROBOTS" CONTENT="INDEX, FOLLOW">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
	</div>

	<!-- Nav -->
	<%@ include file="/WEB-INF/jsp/nav.jsp"%>

	<div id="masthead">
		<div class="container">
			<div class="row">
				<div class="col-md-7">
					<h1>
						Club News
						<p class="lead">Latest news and info</p>
					</h1>
				</div>
				<div class="col-md-5">

					<div class="row">
						<sec:authorize access="isAuthenticated()">
							<div class="col-sm-6">
								<a href="newsAdmin.html" class="newbutton">New Article</a> <a class="buttonLogin" href="<c:url value="/j_spring_security_logout" />">Logout</a>
							</div>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							<div class="col-sm-6">
								<a class="buttonLogin" href="login.html"> Login</a>
							</div>
						</sec:authorize>

					</div>

				</div>
			</div>
		</div>
		<!-- /cont -->
	</div>

	<!-- Begin Body -->
	<div class="container">

		<div class="row">
			<div class="col-md-3" id="leftCol">
				<ul class="nav nav-stacked" id="sidebar">
					<c:if test="${!empty articleList}">
						<c:forEach items="${articleList.pageList}" var="article">
							<li><a href="#${article.storyId}">${article.title}</a></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
			<section class="col-md-9">
				<c:if test="${!empty articleList}">
					<article>
						<c:forEach items="${articleList.pageList}" var="article">
							<h2 id="${article.storyId}">${article.title}</h2>
							<time>
								<fmt:formatDate pattern="EEEE, dd MMMM yyyy, HH:mm " value="${article.postedTime}" />
							</time>
							<p>${article.subtitle}</p>
							<p>${article.content}</p>
							<sec:authorize access="isAuthenticated()">
								<a href="delete/${article.storyId}" onclick="return confirm('Are you sure you want to delete this article?')" class="button">Delete</a>
								<a href="edit/${article.storyId}" class="buttonEdit">Edit</a>
							</sec:authorize>
							<hr class="col-md-12">
						</c:forEach>
					</article>
				</c:if>
				<c:if test="${articleList.nrOfElements == 0}">
					<p>No current news articles</p>
				</c:if>
				<div>
					<c:if test="${!articleList.firstPage}">
						<a href="news.html?page=previous"><b>&lt;&lt; Prev</b></a>
					</c:if>
					<c:if test="${!articleList.lastPage}">
						<a href="news.html?page=next"><b>Next &gt;&gt;</b></a>
					</c:if>
					<br>
				</div>
			</section>
		</div>
	</div>
	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>

	<script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type='text/javascript' src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

	<script type='text/javascript'>
		$(document).ready(function() {

			$('#sidebar').affix({
				offset : {
					top : 235
				}
			});

			var $body = $(document.body);
			var navHeight = $('.navbar').outerHeight(true) + 10;

			$body.scrollspy({
				target : '#leftCol',
				offset : navHeight
			});

			/* smooth scrolling sections */
			$('a[href*=#]:not([href=#])').click(function() {
				if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
					var target = $(this.hash);
					target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
					if (target.length) {
						$('html,body').animate({
							scrollTop : target.offset().top - 50
						}, 1000);
						return false;
					}
				}
			});

		});
	</script>

</body>
</html>




