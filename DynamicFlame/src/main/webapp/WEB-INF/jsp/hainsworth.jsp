<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE HTML>

<html>
<head>
<title>Dynamic Flame Badminton Club</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC-aQPwDQ4SB1xM8HwK3p-BPVBPBH9mTuA&sensor=false">
</script>

<!--[if lt IE 9]>
	<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<script>
	var marker;
	var myLatlng;
	var map;
	function initialize() {
		var mapCanvas = document.getElementById('mapCanvas');
		myLatlng = new google.maps.LatLng(-31.845615, 115.848043);

		var mapOptions = {
			center : myLatlng,
			zoom : 12,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		}
		map = new google.maps.Map(mapCanvas, mapOptions);

		marker = new google.maps.Marker({
			position : myLatlng,
			map : map,
			title : "Melville Recreation Centre"
		});
	}

	google.maps.event.addDomListener(window, 'load', initialize);
	google.maps.event.addDomListener(window, "resize", function() {
		var center = map.getCenter();
		google.maps.event.trigger(map, "resize");
		map.setCenter(center);
	});
</script>
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

	<!-- Main -->
	<div class="wrapper style4">

		<div class="container marketing">
			<div class="row">
				<div class="col-md-6">
					<article id="main" class="text-center">
						<header>
							<h2>Hainsworth Community Centre</h2>
							<h3>Hainsworth Avenue, Girrawheen</h3>
							<span class="byline" style="margin-bottom: 0;"> Sundays </span> <span class="byline" style="margin-bottom: 0; margin-top: 0;">
								2:00pm to 3:30pm Juniors </span> <span class="byline" style="margin-top: 0; margin-bottom: 1em;"> 3:00pm to 5:00pm Adults </span> <span
								class="byline"> $8 for members <strong>|</strong> $10 for non-members
							</span>
						</header>
					</article>
				</div>
				<div class="col-md-6">
					<div id="mapCanvas"></div>
				</div>
			</div>
			<hr class="featurette-divider">
		</div>


		<!-- Footer -->
		<%@ include file="/WEB-INF/jsp/footer.jsp"%>

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>