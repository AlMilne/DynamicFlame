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
<script src="${contextPath}/resources/js/jquery.lightbox.js"></script>
<script>
	$(document).ready(function() {
		$(".lightbox").lightbox();
	});

	$(window).load(function() {
		$('#gallery img').each(function() {
			createCanvas(this);
		});

		function createCanvas(image) {

			var canvas = document.createElement('canvas');
			if (canvas.getContext) {
				var ctx = canvas.getContext("2d");

				// specify canvas size
				canvas.width = image.width;
				canvas.height = image.height;

				// Once we have a reference to the source image object we can use the drawImage(reference, x, y) method to render it to the canvas. 
				//x, y are the coordinates on the target canvas where the image should be placed.
				ctx.drawImage(image, 0, 0);

				// Taking the image data and storing it in the imageData array. You can read the pixel data on a canvas using the getImageData() method. Image data includes the colour of the pixel (decimal, rgb values) and transparency (alpha value). Each color component is represented by an integer between 0 and 255. imageData.da contains height x width x 4 bytes of data, with index values ranging from 0 to (height x width x 4)-1.
				var imageData = ctx.getImageData(0, 0, canvas.width, canvas.height), pixelData = imageData.data;

				// Loop through all the pixels in the imageData array, and modify
				// the red, green, and blue color values.
				for (var y = 0; y < canvas.height; y++) {
					for (var x = 0; x < canvas.width; x++) {

						// You can access the color values of the (x,y) pixel as follows :
						var i = (y * 4 * canvas.width) + (x * 4);

						// Get the RGB values.
						var red = pixelData[i];
						var green = pixelData[i + 1];
						var blue = pixelData[i + 2];

						// Convert to grayscale. One of the formulas of conversion (e.g. you could try a simple average (red+green+blue)/3)   
						var grayScale = (red * 0.3) + (green * 0.59) + (blue * .11);

						pixelData[i] = grayScale;
						pixelData[i + 1] = grayScale;
						pixelData[i + 2] = grayScale;
					}
				}

				// Putting the modified imageData back on the canvas.
				ctx.putImageData(imageData, 0, 0, 0, 0, imageData.width, imageData.height);

				// Inserting the canvas in the DOM, before the image:
				image.parentNode.insertBefore(canvas, image);
			}
		}
	});
</script>
<style>
#wrap li {
	float: left;
	position: relative;
	display: inline-block;
	width: 320px;
	height: 220px;
	margin: 10px;
	padding: 10px;
	background: #fff;
	-webkit-box-shadow: 0 0 5px rgba(0, 0, 0, .35);
	-moz-boz-shadow: 0 0 5px rgba(0, 0, 0, .35);
	box-shadow: 0 0 5px rgba(0, 0, 0, .35);
}

#wrap li div {
	position: absolute;
	height: 0;
	width: 300px;
	background: rgba(0, 0, 0, .45);
	overflow: hidden;
	bottom: 10px;
	left: 10px;
	padding: 0 10px;
	-webkit-transition: height 1s;
	-moz-transition: height 1s;
	-o-transition: height 1s;
	-ms-transition: height 1s;
	transition: height 1s;
	color: #fff;
	line-height: 50px;
	font-size: 1.2em;
}

#wrap li:hover div {
	height: 50px;
}

canvas {
	opacity: 1;
	position: absolute;
	top: 10px;
	left: 10px;
	-webkit-transition: opacity 1s .2s;
	-moz-transition: opacity 1s .2s;
	-o-transition: opacity 1s .2s;
	-ms-transition: opacity 1s .2s;
	transition: opacity 1s .2s;
}

#wrap li:hover canvas {
	opacity: 0;
}

p {
	clear: left;
	float: right;
	margin-top: 10px;
	margin-right: 20px;
}

p a {
	color: #909090;
	-webkit-transition: color .6s;
	-moz-transition: color .6s;
	-o-transition: color .6s;
	-ms-transition: color .6s;
	transition: color .6s;
}

p a:hover {
	color: #eb5cf4;
}
</style>
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
			<ul id="gallery">
				<div class="row">
					<div class="col-md-4">
						<li><a href="${contextPath}/resources/images/IMG_7923.jpg" class="lightbox" rel="dfbc"><img
								src="${contextPath}/resources/images/IMG_7923_sm.jpg">
								<div>Hainsworth</div></a></li>
					</div>
					<div class="col-md-4">
						<li><a href="${contextPath}/resources/images/IMG_7921.jpg" class="lightbox" rel="dfbc"><img
								src="${contextPath}/resources/images/IMG_7921_sm.jpg">
								<div>Racket</div></a></li>
					</div>
					<div class="col-md-4">
						<li><a href="${contextPath}/resources/images/trophies.jpg" class="lightbox" rel="dfbc"><img
								src="${contextPath}/resources/images/trophies_sm.jpg">
								<div>Trophies</div></a></li>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<li><a href="${contextPath}/resources/images/winners.jpg" class="lightbox" rel="dfbc"><img
								src="${contextPath}/resources/images/winners_sm.jpg">
								<div>DFBC Winners</div></a></li>
					</div>
					<div class="col-md-4">
						<li><a href="${contextPath}/resources/images/trophies.jpg" class="lightbox" rel="dfbc"><img
								src="${contextPath}/resources/images/trophies_sm.jpg">
								<div>Trophies</div></a></li>
					</div>
					<div class="col-md-4">
						<li><a href="${contextPath}/resources/images/IMG_7921.jpg" class="lightbox" rel="dfbc"><img
								src="${contextPath}/resources/images/IMG_7921_sm.jpg">
								<div>Racket</div></a></li>
					</div>
			</ul>
		</div>
	</div>
</div>
<hr />


<!-- Footer -->
<%@ include file="/WEB-INF/jsp/footer.jsp"%>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</body>
</html>