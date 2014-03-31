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
		myLatlng = new google.maps.LatLng(-32.042713, 115.939903);

		var mapOptions = {
			center : myLatlng,
			zoom : 12,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		}
		map = new google.maps.Map(mapCanvas, mapOptions);

		marker = new google.maps.Marker({
			position : myLatlng,
			map : map,
			title : "Langford"
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
	<div class="container marketing">
		<div class="row">
			<div class="col-md-6">
				<article id="main" class="text-center">
					<header>
						<h2>Langford Recreation Centre</h2>
						<h3>52 Langford Avenue, Langford</h3>
						<span class="byline">Saturdays 10:30am to 12:00pm Juniors and Adults </span> <span class="byline"> $8 for members <strong>|</strong>
							$10 for non-members
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