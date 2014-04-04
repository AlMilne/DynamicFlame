<!DOCTYPE HTML>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html lang="en">
<head>
<title>Dynamic Flame Badminton Club</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/photoswipe.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/lib/simple-inheritance.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/code-photoswipe-1.0.11.min.js"></script>


<script type="text/javascript">
	// Set up PhotoSwipe with all anchor tags in the Gallery container 
	document.addEventListener('DOMContentLoaded', function() {

		Code.photoSwipe('a', '#Gallery');

	}, false);
</script>

</head>
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

<!-- Main -->
<div class="container marketing">
	<div class="row">
		<div id="wrap">
			<div id="Gallery">
				<div class="gallery-row">
					<div class="gallery-item">
						<a href="resources/images/full/001.jpg"><img src="resources/images/thumb/001.jpg" alt="Image 01" /></a>
					</div>
					<div class="gallery-item">
						<a href="resources/images/full/002.jpg"><img src="resources/images/thumb/002.jpg" alt="Image 02" /></a>
					</div>
					<div class="gallery-item">
						<a href="resources/images/full/003.jpg"><img src="resources/images/thumb/003.jpg" alt="Image 03" /></a>
					</div>
				</div>
				<div class="gallery-row">
					<div class="gallery-item">
						<a href="resources/images/full/004.jpg"><img src="resources/images/thumb/004.jpg" alt="Image 04" /></a>
					</div>
					<div class="gallery-item">
						<a href="resources/images/full/005.jpg"><img src="resources/images/thumb/005.jpg" alt="Image 05" /></a>
					</div>
					<div class="gallery-item">
						<a href="resources/images/full/006.jpg"><img src="resources/images/thumb/006.jpg" alt="Image 06" /></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<hr />


<!-- Footer -->
<%@ include file="/WEB-INF/jsp/footer.jsp"%>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>



</body>
</html>