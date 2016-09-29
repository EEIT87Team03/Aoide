<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html"/>
<style>
.sp {
    font-size: 20pt;
}
* {box-sizing:border-box}
body {font-family: Verdana,sans-serif;}
/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}
/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}
/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}
/* The dots/bullets/indicators */
.dot {
  height: 13px;
  width: 13px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}
.active {
  background-color: #717171;
}
/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 2.5s;
  animation-name: fade;
  animation-duration: 2.5s;
}
@-webkit-keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
}
@keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
}
/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}
</style>
</head>
<body>
	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
				<div class="box">
		        	<br>
		        	<br>
		        	<form action="<c:url value ='/SearchSongServlet'/>" method="post" style="text-align: center;">
						搜尋：<input type="text" name="searchSong" style="color:black" autofocus>　
						<input class="btn" type="submit" value="送出" style="color:black">
						<p><span class="sp">${errorMsg.emptySearchMsg}</span>
						<p>
						<input type="radio" name="searchType" value="name" checked> 搜尋歌名　
						<input type="radio" name="searchType" value="singer"> 搜尋歌手　
						<input type="radio" name="searchType" value="album"> 搜尋專輯
					</form>
						<div style="padding-left: 215px;">
							<p>點歌規則:</p>
							<p>1. 同一首歌曲 12小時內只能點播一次。</p>
							<p>2. 一次限點播一首。</p>
						</div>
					<br>
		        	<br>
				</div>
<center>
<div class="slideshow-container" >

<div class="mySlides fade">
	<a href="<c:url value='/DisplaySongServlet?id=1'/>">
  		<img alt=""src="/Aoide/files/song_cover_files/Songid1.jpg" width="300" height="300">
  	</a>
  <div class="text">Caption Text</div>
</div>

<div class="mySlides fade">
	<a href="<c:url value='/DisplaySongServlet?id=38'/>">
  		<img alt=""src="/Aoide/files/song_cover_files/Songid38.jpg" width="300" height="300">
    </a>
  <div class="text">Caption Two</div>
</div>

<div class="mySlides fade">
	<a href="<c:url value='/DisplaySongServlet?id=48'/>">
  		<img alt=""src="/Aoide/files/song_cover_files/Songid48.jpg" width="300" height="300">
    </a>
  <div class="text">Caption Three</div>
</div>

</div>
<br>

<div style="text-align:center" id="PushButton">
  <span class="dot"></span>
  <span class="dot"></span>
  <span class="dot"></span>
</div>
</div>
</center>
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex> slides.length) {slideIndex = 1}
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 3000); // Change image every 2 seconds
}
</script>
</body>
</html>