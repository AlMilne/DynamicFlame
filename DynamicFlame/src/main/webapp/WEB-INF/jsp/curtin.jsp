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
		myLatlng = new google.maps.LatLng(-32.002958, 115.890403);

		var mapOptions = {
			center : myLatlng,
			zoom : 12,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		}
		map = new google.maps.Map(mapCanvas, mapOptions);

		marker = new google.maps.Marker({
			position : myLatlng,
			map : map,
			title : "Curtin"
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
				<div class="6u skel-cell-important">
					<article id="main" class="special">
						<header>
							<h2>Curtin</h2>
							<h3>Curtin University Stadium</h3>
							<span class="byline">Wednesday 6:30pm to 8:30pm Juniors and Adults </span> <span class="byline"> $8 for members <strong>|</strong>
								$10 for non-members
							</span>
						</header>
					</article>
				</div>
				<div class="6u skel-cell">
					<div id="mapCanvas"></div>
				</div>
			</div>

			<hr />

		</div>
	</div>
	
	<!-- Footer -->
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>

</body>
</html>