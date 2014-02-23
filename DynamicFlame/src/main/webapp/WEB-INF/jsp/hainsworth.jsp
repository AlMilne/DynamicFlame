<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE HTML>

<html>
<head>
<title>Dynamic Flame Badminton Club</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC-aQPwDQ4SB1xM8HwK3p-BPVBPBH9mTuA&sensor=false">
	
</script>
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
<body class="no-sidebar">

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
				<div class="6u skel-cell-important" id="content">
					<article id="main" class="special">
						<header>
							<h2>Hainsworth Community Centre</h2>
							<h3>Hainsworth Avenue, Girrawheen</h3>
							<span class="byline" style="margin-bottom: 0;"> Sundays </span> <span class="byline"
								style="margin-bottom: 0; margin-top: 0;"> 2:00pm to 3:30pm Juniors </span> <span class="byline"
								style="margin-top: 0; margin-bottom: 1em;"> 3:00pm to 5:00pm Adults </span> <span class="byline"> $8 for members <strong>|</strong>
								$10 for non-members
							</span>
						</header>
					</article>
				</div>
				<div class="6u skel-cell-important" id="content">
					<section class="12u skel-cell-important">
						<div id="mapCanvas"></div>
					</section>
				</div>
			</div>

			<hr />

		</div>

	</div>

	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>

</body>
</html>