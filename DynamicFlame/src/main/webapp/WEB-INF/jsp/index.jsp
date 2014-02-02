<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE HTML>

<html>
<head>
<title>Dynamic Flame Badminton Club</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600" rel="stylesheet" type="text/css" />

</head>
<body class="homepage">

	<!-- Header -->
	<div id="header">

		<!-- Inner -->
		<div class="inner">
			<header>
				<h1>
					<a href="#" id="logo">Dynamic Flame Badminton Club</a>
				</h1>
				<hr />
				<span class="byline">A fun social badminton club based in Perth WA</span>
			</header>
			<footer>
				<a href="#banner" class="button circled scrolly">Let's Play!</a>
			</footer>
		</div>

		<!-- Nav -->
		<%@ include file="/WEB-INF/jsp/nav.jsp"%>

	</div>


	<!-- Banner -->
	<div id="banner">
		<h2>We invite you to join us at the following venues</h2>
		<br>
		<div class="section group">
			<div class="col span_1_of_4">
				<a href="melville.html"> <strong><span class="venueContent">Melville</strong></span>Sunday <span class="venueContentTimes">9:30am
						to 11:30am</span><br> Juniors & Adults 
			</div>
			</a>
			<div class="col span_1_of_4">
				<a href="cannington.html"> <strong><span class="venueContent">Cannington</strong></span>Sunday <span
					class="venueContentTimes">11:00am to 1:00pm</span><br> Juniors & Adults 
			</div>
			</a>
			<div class="col span_1_of_4">
				<a href="hainsworth.html"> <strong><span class="venueContent">Hainsworth</strong></span>Sunday <span
					class="venueContentTimes">2:00pm to 3:30pm Juniors</span><br> 3:00pm to 5:00pm Adults 
			</div>
			</a>
			<div class="col span_1_of_4">
				<a href="kingsway.html"> <strong><span class="venueContent">Kingsway</strong></span>Tuesday <span
					class="venueContentTimes">5:30pm to 6:45pm Juniors</span><br> 7:00pm to 10:00pm Adults 
			</div>
			</a>
		</div>
		<br>
		<div class="section group">
			<div class="col span_1_of_4">
				<strong><span class="venueContentWed">Curtin</strong></span>Wednesday <span class="venueContentTimes">6:30pm to 8:30pm</span><br>
				Juniors & Adults
			</div>
			<div class="col span_1_of_4">
				<strong><span class="venueContent">Vic Park</strong></span>Friday <span class="venueContentTimes">5:30pm to 6:45pm
					Juniors</span><br> 6:45pm to 9:00pm Adults
			</div>
			<div class="col span_1_of_4">
				<strong><span class="venueContent">Leeming</strong></span>Saturday <span class="venueContentTimes">10:00am to 11:30am</span><br>
				Juniors & Adults
			</div>
			<div class="col span_1_of_4">
				<strong><span class="venueContent">Heathridge</strong></span>Saturday <span class="venueContentTimes">1:00pm to 3:30pm
					Juniors</span><br> Juniors & Adults
			</div>
		</div>


		<br> <br>
		<h3>
			All the above sessions provide <strong>FREE</strong> badminton coaching by Qualified and Nationally Accredited Coaches.
		</h3>
	</div>


	<!-- Footer -->
	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="12u">

					<!-- Contact -->
					<section class="contact">
						<ul class="icons">
							<li><a href="#" class="fa fa-twitter solo"><span>Twitter</span></a></li>
							<li><a href="#" class="fa fa-facebook solo"><span>Facebook</span></a></li>
						</ul>
					</section>

					<!-- Copyright -->
					<div class="copyright">
						<ul class="menu">
							<li>&copy; 2013 Dynamic Flame. All rights reserved.</li>
						</ul>
					</div>

				</div>

			</div>
		</div>
	</div>

</body>
</html>