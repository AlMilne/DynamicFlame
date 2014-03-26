<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html lang="en">
<html>
<head>
<title>Dynamic Flame Badminton Club</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

</head>

<body>
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
	
	<!-- Nav -->
	<%@ include file="/WEB-INF/jsp/nav.jsp"%>


	<!-- Carousel
================================================== -->
	<div id="myCarousel" class="carousel slide">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img src="resources/images/IMG_7921.jpg" class="img-responsive ">
				<div class="container">
					<div class="carousel-caption">
						<h1>Dynamic Flame Badminton Club</h1>
						<h2>A fun social badminton club based in Perth WA</h2>
						<pthis is="" an="" example="" layout="" with="" carousel="" that="" uses="" the="" bootstrap="" 3="" styles.<="" small="">
						<p></p>
						<p>
							<a class="btn btn-lg btn-primary" href="#venues">Let's Play</a>
						</p>
						</pthis>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="resources/images/IMG_7923.jpg" class="img-responsive">
				<div class="container">
					<div class="carousel-caption">
						<h1>All skill levels welcome</h1>
						<p>Our members include beginners to state level players</p>
						<p>
							<a class="btn btn-large btn-primary" href="#">Learn more</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="resources/images/shuttle.jpg" class="img-responsive">
				<div class="container">
					<div class="carousel-caption">
						<h1>8 venues across perth</h1>
						<p>One membership covers all venues.</p>
						<p>
							<a class="btn btn-large btn-primary" href="#">Browse gallery</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- Controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev"> <span class="icon-prev"></span>
		</a> <a class="right carousel-control" href="#myCarousel" data-slide="next"> <span class="icon-next"></span>
		</a>
	</div>
	<!-- /.carousel -->

	<!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">

		<div class="row text-center venues">
			<h2>We invite you to join us at the following venues</h2>
			<br>
			<div class="section group">
				<div class="col-md-3 text-center venueBox">
					<a href="melville.html"> <strong><span class="venueContent">Melville</strong></span>Sunday <span class="venueContentTimes">9:30am
							to 11:30am</span><br> Juniors & Adults 
				</div>
				</a>
				<div class="col-md-3 text-center venueBox">
					<a href="cannington.html"> <strong><span class="venueContent">Cannington</strong></span>Sunday <span class="venueContentTimes">11:00am
							to 1:00pm</span><br> Juniors & Adults 
				</div>
				</a>
				<div class="col-md-3 text-center venueBox">
					<a href="hainsworth.html"> <strong><span class="venueContent">Hainsworth</strong></span>Sunday <span class="venueContentTimes">2:00pm
							to 3:30pm Juniors</span><br> 3:00pm to 5:00pm Adults 
				</div>
				</a>
				<div class="col-md-3 text-center venueBox">
					<a href="kingsway.html"> <strong><span class="venueContent">Kingsway</strong></span>Tuesday <span class="venueContentTimes">5:30pm
							to 6:45pm Juniors</span><br> 7:00pm to 10:00pm Adults 
				</div>
				</a>
			</div>
		</div>

		<div class="row text-center venues">
			<div class="col-md-3 text-center venueBox">
				<a href="curtin.html"><span class="venueContentWed">Curtin</span>Wednesday <span class="venueContentTimes">6:30pm to 8:30pm</span><br>
					Juniors &amp; Adults </a>
			</div>

			<div class="col-md-3 text-center venueBox">
				<a href="vicpark.html"><span class="venueContent">Vic Park</span>Friday <span class="venueContentTimes">5:30pm to 6:45pm
						Juniors</span><br> 6:45pm to 9:00pm Adults </a>
			</div>

			<div class="col-md-3 text-center venueBox">
				<a href="langford.html"><span class="venueContent">Langford</span>Saturday <span class="venueContentTimes">10:30am to 12:00am</span><br>
					Juniors &amp; Adults </a>
			</div>
			<div class="col-md-3 text-center venueBox">
				<a href="heathridge.html"><span class="venueContent">Heathridge</span>Saturday <span class="venueContentTimes">1:00pm to 3:30pm
						Juniors</span><br> Juniors &amp; Adults </a>
			</div>
		</div>


		<br> <br> <span class="text-center" />
		<h3>
			All the above sessions provide <strong>FREE</strong> badminton coaching by Qualified and Nationally Accredited Coaches.
		</h3>
		</span>
	</div>


	<hr class="featurette-divider">

	<!-- FOOTER -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>



	<!-- JavaScript jQuery code from Bootply.com editor -->

	<script type='text/javascript'>
		$(document).ready(function() {

		});
	</script>

</body>
</html>