<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE HTML>

<html>
<head>
<title>Dynamic Flame Badminton Club</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600" rel="stylesheet" type="text/css" />
</head>

<body class="homepage">
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_GB/all.js#xfbml=1";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<!-- Header -->
	<div id="header">
		<div id="facebook" class="row">
			<section class="-9u 3u">
				<div class="fb-like" data-href="http://www.facebook.com/dynamicflamebadmintonclub" data-layout="button_count"
					data-action="like" data-show-faces="true" data-share="true"></div>
			</section>
		</div>

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
	<div id="banner" class="venues">
		<h2>We invite you to join us at the following venues</h2>
		<br>
		<div class="section group">
			<div class="col span_1_of_4">
				<a href="melville.html"><span class="venueContent">Melville</span>Sunday <span class="venueContentTimes">9:30am to
						11:30am</span><br> Juniors &amp; Adults </a>
			</div>

			<div class="col span_1_of_4">
				<a href="cannington.html"><span class="venueContent">Cannington</span>Sunday <span class="venueContentTimes">11:00am
						to 1:00pm</span><br> Juniors &amp; Adults </a>
			</div>

			<div class="col span_1_of_4">
				<a href="hainsworth.html"><span class="venueContent">Hainsworth</span>Sunday <span class="venueContentTimes">2:00pm
						to 3:00pm Juniors</span><br> 3:00pm to 5:00pm Adults </a>
			</div>

			<div class="col span_1_of_4">
				<a href="kingsway.html"><span class="venueContent">Kingsway</span>Tuesday <span class="venueContentTimes">5:30pm to
						6:45pm Juniors</span><br> 7:00pm to 10:00pm Adults </a>
			</div>

		</div>
		<br>
		<div class="section group">
			<div class="col span_1_of_4">
				<a href="curtin.html"><span class="venueContentWed">Curtin</span>Wednesday <span class="venueContentTimes">6:30pm
						to 8:30pm</span><br> Juniors &amp; Adults </a>
			</div>

			<div class="col span_1_of_4">
				<a href="vicpark.html"><span class="venueContent">Vic Park</span>Friday <span class="venueContentTimes">5:30pm to
						6:45pm Juniors</span><br> 6:45pm to 9:00pm Adults </a>
			</div>

			<div class="col span_1_of_4">
				<a href="langford.html"><span class="venueContent">Langford</span>Saturday <span class="venueContentTimes">10:30am
						to 12:00am</span><br> Juniors &amp; Adults </a>
			</div>
			<div class="col span_1_of_4">
				<a href="heathridge.html"><span class="venueContent">Heathridge</span>Saturday <span class="venueContentTimes">1:00pm
						to 3:30pm Juniors</span><br> Juniors &amp; Adults </a>
			</div>

		</div>


		<br> <br>
		<h3>
			All the above sessions provide <strong>FREE</strong> badminton coaching by Qualified and Nationally Accredited Coaches.
		</h3>
	</div>


	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>

</body>
</html>