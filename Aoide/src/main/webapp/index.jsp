<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en-US" class="state2 page-is-gated scroll-bar site-decoration-a" data-skrollex-config="{isInitColorPanel: false, isCustomizer: false, adminUrl: &#039;http://skrollex-wp.x40.ru/anna/wp-admin/&#039;, ajaxUrl: &#039;http://skrollex-wp.x40.ru/anna/wp-admin/admin-ajax.php&#039;, homeUri: &#039;http://skrollex-wp.x40.ru/anna&#039;, themeUri: &#039;http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/&#039;, permalink: &#039;http://skrollex-wp.x40.ru/anna&#039;, colors: &#039;colors-preset-anna.css&#039;}">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no">
<title>Aoide</title>
<link rel="Shortcut Icon" type="image/x-icon" href="views/dist/img/AoideIcon.png" />
<link rel="stylesheet" href="css/_02_PlaySong/audioSocket.css">		<!-- Byc -->
<link rel="stylesheet" href="css/_02_PlaySong/playlist.css">		<!-- Byc -->
<link rel="stylesheet" href="css/HoverableDropDown.css">
<link rel="stylesheet" href="css/_05_DisplayDanmuku/barrager.css">
<link rel="stylesheet" href="danmmu/css/bootstrap.min.css" media="screen" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="alternate" type="application/rss+xml" title="SKROLL[EX] &raquo; Feed" href="http://skrollex-wp.x40.ru/anna/feed/"/>
<link rel="alternate" type="application/rss+xml" title="SKROLL[EX] &raquo; Comments Feed" href="http://skrollex-wp.x40.ru/anna/comments/feed/"/>
<style>#wp-admin-bar-layers-edit-layout .ab-icon:before{font-family:"layers-interface"!important;content:"\e62f"!important;font-size:16px!important;}</style>
<link rel='stylesheet' id='contact-form-7-css' href='http://skrollex-wp.x40.ru/anna/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=4.4.2' type='text/css' media='all'/>
<link rel='stylesheet' id='layers-google-fonts-css' href='//fonts.googleapis.com/css?family=Ubuntu%3Aregular%2Citalic%2C700%2C300%2C300italic%2C500%2C500italic%2C700italic%7COswald%3Aregular%2C700%2C300&#038;ver=1.5.3' type='text/css' media='all'/>
<link rel='stylesheet' id='layers-framework-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/layerswp/assets/css/framework.css?ver=1.5.3' type='text/css' media='all'/>
<link rel='stylesheet' id='layers-components-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/layerswp/assets/css/components.css?ver=1.5.3' type='text/css' media='all'/>
<link rel='stylesheet' id='layers-responsive-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/layerswp/assets/css/responsive.css?ver=1.5.3' type='text/css' media='all'/>
<link rel='stylesheet' id='layers-icon-fonts-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/layerswp/assets/css/layers-icons.css?ver=1.5.3' type='text/css' media='all'/>
<link rel='stylesheet' id='layers-style-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/style.css?ver=1.5.3' type='text/css' media='all'/>
<link rel='stylesheet' id='layers-font-awesome-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/layerswp/core/assets/plugins/font-awesome/font-awesome.min.css?ver=1.5.3' type='text/css' media='all'/>
<link rel='stylesheet' id='animate.css-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/bower_components/animate.css/animate.min.css?ver=8dba6713421708b83f224493838e3224' type='text/css' media='all'/>
<link rel='stylesheet' id='purecss-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/pure/pure-min.css?ver=8dba6713421708b83f224493838e3224' type='text/css' media='all'/>
<link rel='stylesheet' id='purecss-grids-responsive-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/pure/grids-responsive-min.css?ver=8dba6713421708b83f224493838e3224' type='text/css' media='all'/>
<link rel='stylesheet' id='linecons-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/linecons/style.css?ver=8dba6713421708b83f224493838e3224' type='text/css' media='all'/>
<link rel='stylesheet' id='custom-mit-code-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/mit-code/style.css?ver=8dba6713421708b83f224493838e3224' type='text/css' media='all'/>
<link rel='stylesheet' id='custom-gnu-code-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/gnu-code/style.css?ver=8dba6713421708b83f224493838e3224' type='text/css' media='all'/>
<link rel='stylesheet' id='minicolors-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/bower_components/minicolors/jquery.minicolors.css?ver=8dba6713421708b83f224493838e3224' type='text/css' media='all'/>
<link rel='stylesheet' id='skrollex_child_styles-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/css/style.css?ver=8dba6713421708b83f224493838e3224' type='text/css' media='all'/>
<link rel='stylesheet' id='theme-color-schemes-css' href='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/css/colors-preset-anna.css?ver=1466432178' type='text/css' media='all'/>
<link rel='stylesheet' id='fancybox-css' href='http://skrollex-wp.x40.ru/anna/wp-content/plugins/easy-fancybox/fancybox/jquery.fancybox-1.3.7.min.css?ver=1.5.7' type='text/css' media='screen'/>
<!-- <script type='text/javascript' src='http://skrollex-wp.x40.ru/anna/wp-includes/js/jquery/jquery.js?ver=1.12.4'></script> -->
<script src="danmmu/js/jquery-1.9.1.min.js"></script>
<script src="/Aoide/template/plugins/ckeditor/ckeditor.js"></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/layerswp/assets/js/plugins.js?ver=1.5.3'></script>
<link rel='https://api.w.org/' href='http://skrollex-wp.x40.ru/anna/wp-json/'/>
<link rel="EditURI" type="application/rsd+xml" title="RSD" href="http://skrollex-wp.x40.ru/anna/xmlrpc.php?rsd"/>
<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="http://skrollex-wp.x40.ru/anna/wp-includes/wlwmanifest.xml"/>
<meta name="generator" content="WordPress 4.5.4"/>
<link rel="canonical" href="http://skrollex-wp.x40.ru/anna/"/>
<link rel='shortlink' href='http://skrollex-wp.x40.ru/anna/'/>
<link rel="alternate" type="application/json+oembed" href="http://skrollex-wp.x40.ru/anna/wp-json/oembed/1.0/embed?url=http%3A%2F%2Fskrollex-wp.x40.ru%2Fanna%2F"/>
<link rel="alternate" type="text/xml+oembed" href="http://skrollex-wp.x40.ru/anna/wp-json/oembed/1.0/embed?url=http%3A%2F%2Fskrollex-wp.x40.ru%2Fanna%2F&#038;format=xml"/>
<style id="layers-inline-styles-header">body{font-family:"Ubuntu",Helvetica,sans-serif;}h1,h2,h3,h4,h5,h6,.heading{font-family:"Oswald",Helvetica,sans-serif;}button,.button,input[type=submit]{font-family:"Oswald",Helvetica,sans-serif;}</style> 
<meta property="og:title" content=""/>
<meta property="og:type" content="website"/>
<meta property="og:url" content=""/>
<style>.recentcomments a{display:inline!important;padding:0!important;margin:0!important;}</style> 
<link rel="stylesheet" href="css/_05_DisplayDanmuku/missileLauncher.css">
<script>
/* <![CDATA[ */
var fb_timeout = null;
var fb_opts = { 'overlayShow' : true, 'hideOnOverlayClick' : true, 'showCloseButton' : true, 'centerOnScroll' : true, 'enableEscapeButton' : true, 'autoScale' : true };
var easy_fancybox_handler = function(){
	/* IMG */
	var fb_IMG_select = 'a[href*=".jpg"]:not(.nofancybox,.pin-it-button), area[href*=".jpg"]:not(.nofancybox), a[href*=".jpeg"]:not(.nofancybox,.pin-it-button), area[href*=".jpeg"]:not(.nofancybox), a[href*=".png"]:not(.nofancybox,.pin-it-button), area[href*=".png"]:not(.nofancybox)';
	jQuery(fb_IMG_select).addClass('fancybox image');
	var fb_IMG_sections = jQuery('div.gallery ');
	fb_IMG_sections.each(function() { jQuery(this).find(fb_IMG_select).attr('rel', 'gallery-' + fb_IMG_sections.index(this)); });
	jQuery('a.fancybox, area.fancybox, li.fancybox a:not(li.nofancybox a)').fancybox( jQuery.extend({}, fb_opts, { 'transitionIn' : 'elastic', 'easingIn' : 'easeOutBack', 'transitionOut' : 'elastic', 'easingOut' : 'easeInBack', 'opacity' : false, 'hideOnContentClick' : false, 'titleShow' : true, 'titlePosition' : 'over', 'titleFromAlt' : true, 'showNavArrows' : true, 'enableKeyboardNav' : true, 'cyclic' : false }) );
	/* Auto-click */ 
	jQuery('#fancybox-auto').trigger('click');
}
/* ]]> */
</script>
</head>
<body id="skrollex-body" class="home page page-id-26 page-template page-template-builder page-template-builder-php no-colors-label background-k" ondragover="allowDrop(event);" ondrop="onDrop(event);">
	<div class="view full " id="layers-widget-skrollex-section-3"  >
		<div data-src="views/dist/img/aoide2.jpg" class="bg-holder"></div>
		<div data-src="views/dist/img/aoide3.jpg" class="bg-holder"></div>
		<div data-src="views/dist/img/aoide4.jpg" class="bg-holder"></div>
		<div data-src="views/dist/img/aoide5.jpg" class="bg-holder"></div>
		<div id="home" class="fg colors-b  full-size">
			<iframe src="" height="17"></iframe><br>
			<iframe src="" width="31"></iframe>
			<iframe src="home.jsp" height="820" width="1850" name="aoide"></iframe>
			<div class="flask-bubbles from-bottom svg-overlay bottom fixed hide-on-mobile">
			<div class="background-heading bubble b0"></div>
			<div class="background-heading bubble b1"></div>
			<div class="background-heading bubble b2"></div>
			<div class="background-heading bubble b3"></div>
			<div class="background-heading bubble b4"></div>
			<div class="background-heading bubble b5"></div>
			<div class="background-heading bubble b6"></div>
			<div class="background-heading bubble b7"></div>
			<div class="background-heading bubble b8"></div>
			<div class="background-heading bubble b9"></div>
		</div>
		</div>
	</div>
	<div class="gate colors-o">
		<div class="gate-content">
			<div class="gate-bar background-highlight"></div>
			<div class="preloader">
				<div class="preloader-container">
					<div class="circleOne border-heading"></div>
					<div class="circleTwo border-heading"></div>
					<div class="circleThree border-heading"></div>
					<div class="circleFour border-heading"></div>
					<div class="circleFive border-heading"></div>
					<div class="circleSix border-heading"></div>
				</div>
			</div> 
		</div>
	</div>
	<div class="page-border  heading top colors-a main-navigation"></div>
	<!-- 下 -->
	<div class="page-border  heading bottom colors-a main-navigation">
		<a href="home.jsp" target="aoide" title="回首頁"><span><span class="glyphicon glyphicon-home"></span></span></a>
		<!-- audio player -->
		<div id = "playbar" oncontextmenu = "window.event.returnValue = false">
			<a id = "coverInfo" href = "#" target="aoide">
				<img src = "/Aoide/files/song_cover_files/default.jpg" id = "cover" alt="cover" width = "50" height = "50">
			</a>
			<div id = "info">
				<h5 id = "tip"></h5>
				<span id = "trackName"></span>
				<span id = "singer"></span>
			</div>
			<div id = "controls">
				<audio src = "#" id = "track">
					<p>Sorry but audio is not supported in your browser.</p>
				</audio>
				<img id = "controlIcon" src = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAALEwAACxMBAJqcGAAAAvRJREFUSImtlD9IHEEUxr+Z2T1sIuoqRBAFwSLqNRIL5YgY7cQiGtOlCUHBFBJEJBAISggiGizExoBcoxBJOisRssGzsVK5EFD8Bwp6orubhfNuMm/T5NQzd+cq+brZ+d73m8fMPgafam1tfaCU+ggARPTaNM2ffurYTYZQKFSo6/o7xtgrANrfz7+JaNLzvCHTNK07AZqamjQhxEsies85N7LYTgC8NQzj0/z8vPINaG5ufgxggjEWzHW6lIhoXQjRt7S09C0noKWlpVIpNcY5f+InOIO+CCEGFhcXd9IAjY2N9/Ly8t4QUT/nPHDHcAAAESUYY2NENGKapisAoKqq6gWAEcaYuGru7u5GV1cXHMfBwcGBX4bmuu4j13Xdo6OjZS2XMz8/H/X19SgtLUV7ezvC4TC2tray+uPxOBzHgVIKuq4L4PLZ5VRZWRmICD09PTg7O8P09DRisdjFvpQStm0jmUz+U8v9AACgvLwchmGgoKAAg4OD6OzsBOcclmUhFotlDL8VAAAqKipgGAaICA0NDZidncXw8DACgezv4laAFKSoqAiVlZUoKSlBW1sbVlZW0NHR8X8AAEBEIKK0tZQyo9fXJafkeR62t7dhWRZs28b5+TmWl5cxNDQEpTJOiuwAz/PSTuV5HnZ2dmBZFoQQWFhYwNzcXNbgnIBEIgHHcS4Anudhd3cXtm3j8PAQo6OjODk5ubnl6wCl1EXrV7W3t4f9/X2Mj49jc3PTV3AaQEop4vE4XNdN2zw9PUUkEsHMzAwikcitglNiABAMBguJaFxK+ZxzfquLvy4i+h0IBMKMsYGNjY2ztHFdV1cXTCQSU0qp0F3COeffdV3vXVtbi6Z1cF3BYPBpMpkcY4xV+AzeZYz1R6PRr9f3RKaC4+PjH7W1tZNSSpJSPmSMZZwFjLFfmqZ9KC4ufra6uhrN6LnpdNXV1fcBTBBRFy7/fNI07TPnvG99ff04V/2NgJRqamrqiWgKADjnvdFodNVP3R/54E8M4bEcuAAAAABJRU5ErkJggg==">
				<h6 id = "playTime">00:00 / 00:00</h6>
				<progress id = "progressBar" max = "100" value = "0"></progress>
				<img id = "volumeIcon" src = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAN1wAADdcBQiibeAAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAAMASURBVEiJ1ZW/b1tVFMc/98VObBdSICJJg1OnkaOaCJKBCMGCECsgwZANMSIGJv6ADvwLHRk7RoIFJBYkqxJSpUhFCkOhGHCQ0/ASGwensf1+3PNlSOO6UUlooEO/0pXuuzo6n/c99513nCQep4LHmv2JArTb7Zc7nc7C/w3IDhIFQdbMZsIwPHcWwOjxg3q9ntvb3Xt9b2+vBBBF0RZAIVOYfRTAaGu3fbXV/DO89+xarVYFYH19PZHkJRWr1WpmcnJyx3vf75ufrNfruVMBYfjXpWbY+k6yT2R6BqC10/pYnlvNZvPt1dVVH1m05b3PLF9engFEj4ZzqSsUCjMnAnZ2Wu8HJDeFViRx1Cup3PeSkPEZwPT0dEOSV6AZgIn+RJMUpOzgHjIA7Xb7fNRPruDct+C7TsEXD2u/qannboR3dr/C6Z3t7d03Llx4/rqkTix7FshQJkq2E3Ok+QccxAfxRUyfkupNjEsycXzdl30pE05+CcDFrkeaUqvVCoc26SlRDnADgKScTEiK8BROAvjU/yQT5qkAxC7uAYyPjOcBXNZ1nXOu0WjkBiWSZHa4cQTOOOX/ZBJy92NShr7jGNKhmw0A0iSIZEJoDO+7JzoQl2WClB8BFClPCh3f6QEI5ZVIxWKxP3CwH7VuP5U//+EI/CCTN9h38PRDX9/rPQE42wDAkYeUcrncBUj7acFlXR/QALC4uBgD145yNH5tvOJNa8DycO7fbjdeDQK9C9wslWevV6vVzPzM/LgCxUBaq9XGMkEuyIjeAyU6ruJ88Wdl/Gugz4f7wAX2liSQXQEoTZVesCAYscTuAHg/NgFg3g5OBADMzc31S+WLH5npA5m+Ach3x656z0ppofT12traiAVWtDj2m+HmFuDGvJ+VJMseAgHcWSfaxsbGucLo+EoKm5XKXD38JZzcT3ovKnU7Cy+Vbp3q4DQtLS0dkElvVCpzdYC73buzJDBuud+H4/7TPCiXy9HR3kbMe0V/TC1NHQzHnLlE/1ZPzkz+J/0NC1XVmvhIxnEAAAAASUVORK5CYII=">
				<input type = "range" id = "ranger" value = "0.09" min = "0" max = "1" step = "0.01">
			</div>
			<div id = "chart"></div>
		</div>
		<!-- audio player -->
		<!-- missile launcher -->
		<div id = "missileLauncher">
			<div id = "warhead">
				<span id = "destructor" class = "closebtn">×</span>
				<button type="button" id = "fire"><h2>Missile Launcher</h2></button>
			</div>
			<div>
				<textarea id = "missile"></textarea>
			 	<script>
					CKEDITOR.replace( "missile", { toolbar : "MissileLauncherTools" ,width: "450", height: "150" }  );// Replace the <textarea id="editor1"> with a CKEditor instance, using default configuration.		
			 	</script>
			</div>		
		</div>
		<!-- missile launcher -->
		<!-- playlist -->
		<div id = "playlist" draggable="true">
			<div id = "playlistHeader">
				<span id = "closer" class = "closebtn">×</span>
				<h2>Scheduling Playlist</h2>
			</div>
			<table id = "list"></table>
			<h5 id = "playlistFooter">None</h5>
		</div>
		<!-- playlist -->
	</div>
<!-- 左 -->
<div class="page-border  heading left colors-a main-navigation">
	<ul>
		<li><a href= "EditBulletList001" target="aoide"><span class="glyphicon glyphicon-th-list" title="網站公告"></span></a></li>　
		<li><a href= "views/global/_10_SearchSong.view/SearchSong.jsp" target="aoide"><span class="glyphicon glyphicon-search" title="搜尋歌曲"></span></a></li>　
		<li><a href= "PlayHistoryServlet" target="aoide"><span class="glyphicon glyphicon-time" title="播放紀錄"></span></a></li>　
		<li><a href= "views/global/_04_PutSuggestion.view/enterSuggestion.jsp" target="aoide"><span class="glyphicon glyphicon-envelope" title="反應建議"></span></a></li>　　
		<li><span><span class="glyphicon glyphicon-minus"></span></span></li>　　
		<li><a href= "#"><span id = "launcher" class="glyphicon glyphicon-send" title="發送彈幕"></span></a></li>　
		<li><a href= "#"><span id = "toggle" class = "glyphicon glyphicon-play-circle" title="開啟/關閉歌曲資訊"></span></a></li>　<!-- audio player toggle -->
		<li><a href= "#"><span id = "playlistMenu" class = "glyphicon glyphicon-list-alt"></span></a></li>　
	</ul>
</div>
<!-- 右 -->
<div class="page-border  heading right colors-a main-navigation"></div>

<section id="top-nav" class="page-transition main-navigation heading colors-a top-nav-logo-left" data-colors-1="colors-a" data-colors-2="colors-a">
<div class="layout-boxed top-nav-inner clearfix">
<nav class="nav nav-horizontal">
<ul id="menu-skrollex-menu-1" class="menu">
<li id="menu-item-804" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-804"><a href="Query.member" target="aoide"><span><span class="glyphicon glyphicon-user"></span></span>會員資料</a></li>
<li id="menu-item-805" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-805">
<div class="dropdown"><a href="#" class="dropbtn">
<span><span class="glyphicon glyphicon-music"></span></span>管理歌曲
</a><div class="dropdown-content">
<a href="views/member/_16_ManageSong.view/UploadSong.jsp" target="aoide"><span><span class="glyphicon glyphicon-upload"></span></span>上傳歌曲</a>
<a href="ListSongServlet.member" target="aoide"><span><span class="glyphicon glyphicon-pencil"></span></span>編輯歌曲</a>
</div></div></li>
<li id="menu-item-806" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-806">
<div class="dropdown"><a href="#"class="dropbtn">
<span><span class="glyphicon glyphicon-cd"></span></span>管理專輯
</a><div class="dropdown-content">
<a href="BuildAlbumServlet.member" target="aoide"><span><span class="glyphicon glyphicon-record"></span></span>建立專輯</a>
<a href="ListAlbumServlet.member" target="aoide"><span><span class="glyphicon glyphicon-edit"></span></span>編輯專輯</a>
</div></div></li>
<li id="menu-item-807" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-807"><a href="ShowFavoriteServlet.member" target="aoide"><span><span class="glyphicon glyphicon-heart"></span></span>收藏清單</a></li>
<li id="menu-item-808" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-808">
<div class="dropdown"><a href="#" class="dropbtn">
<span><span class="glyphicon glyphicon-piggy-bank"></span></span>點數中心
</a><div class="dropdown-content">
<a href="StartDepositTokenServlet.member" target="aoide"><span><span class="glyphicon glyphicon-usd"></span></span>儲值點數</a>
<a href="CheckTokenServlet.member" target="aoide"><span><span class="glyphicon glyphicon-list-alt"></span></span>查詢點數</a>
</div></div></li>
<li id="menu-item-809" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-809"><a href="CheckCashRecordServlet.member" target="aoide"><span><span class="glyphicon glyphicon-gift"></span></span>贊助紀錄</a></li>
</ul> <a href="" class="responsive-nav" data-toggle="#off-canvas-right" data-toggle-class="open">
<span class="l-menu"></span>
</a> </nav>
<div class="logo">
<div class="site-description">
<a href="home.jsp" target="aoide" title="回首頁"><h3 class="sitename sitetitle">A<span>O</span>IDE <span><span class="glyphicon glyphicon-fire"></span></span></h3></a>
</div>
</div>
</div>
</section>
<ul id="dot-scroll" class="colors-a no-colors-label"></ul>
<div class="overlay-window gallery-overlay colors-q" data-overlay-zoom=".fg">
<div class="overlay-control">
<a class="previos" href=""></a>
<a class="next" href=""></a>
<a class="cross" href=""></a>
</div>
<div class="overlay-view scroll-bar">
<div class="layout-boxed overlay-content">
</div>
</div>
<ul class="loader">
<li class="background-highlight"></li>
<li class="background-highlight"></li>
<li class="background-highlight"></li>
</ul>
</div>
<div class="overlay-window map-overlay colors-q">
<div class="overlay-control">
<a class="cross" href=""></a>
</div>
<div class="overlay-view scroll-bar">
</div>
</div>
<div class="wrapper invert off-canvas-right scroll-bar colors-k" id="off-canvas-right">
<a class="close-canvas" data-toggle="#off-canvas-right" data-toggle-class="open">
<i class="l-close"></i>
Close
</a>
</div>
<script src="js/_05_DisplayDanmuku/jquery.barrager.js"></script>
<script src="js/_05_DisplayDanmuku/danmukuWithWebSocket.jsp"></script>
<script src="js/_05_DisplayDanmuku/missileLauncher.js"></script>			<!-- missile launcher javascript source-->
<script src="js/_02_PlaySong/audioSocket.js"></script>						<!-- audio player javascript source-->	
<script src="js/_02_PlaySong/playlist.js"></script>							<!-- audio player javascript source-->			
<script src='http://skrollex-wp.x40.ru/anna/wp-content/plugins/contact-form-7/includes/js/jquery.form.min.js?ver=3.51.0-2014.06.20'></script>
<script>
/* <![CDATA[ */
var _wpcf7 = {"loaderUrl":"http:\/\/skrollex-wp.x40.ru\/anna\/wp-content\/plugins\/contact-form-7\/images\/ajax-loader.gif","recaptchaEmpty":"Please verify that you are not a robot.","sending":"Sending ..."};
/* ]]> */
</script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/plugins/contact-form-7/includes/js/scripts.js?ver=4.4.2'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/bower_components/jquery-cookie/jquery.cookie.js?ver=8dba6713421708b83f224493838e3224'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-includes/js/masonry.min.js?ver=3.1.2'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/bower_components/less.js/dist/less.min.js?ver=8dba6713421708b83f224493838e3224'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/tween/tween.min.js?ver=8dba6713421708b83f224493838e3224'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/bower_components/modernizr/modernizr.js?ver=8dba6713421708b83f224493838e3224'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/bower_components/snap.svg/dist/snap.svg-min.js?ver=8dba6713421708b83f224493838e3224'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/bower_components/minicolors/jquery.minicolors.min.js?ver=8dba6713421708b83f224493838e3224'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/bower_components/textillate/assets/jquery.lettering.js?ver=8dba6713421708b83f224493838e3224'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/bower_components/textillate/assets/jquery.fittext.js?ver=8dba6713421708b83f224493838e3224'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/bower_components/textillate/jquery.textillate.js?ver=8dba6713421708b83f224493838e3224'></script>
<script src='//maps.googleapis.com/maps/api/js?key=AIzaSyBTCtUEUL9HZu2EIpWFiUy6ExMLXbj_1QE&#038;ver=8dba6713421708b83f224493838e3224'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/lib/stringencoders-v3.10.3/javascript/base64.js?ver=8dba6713421708b83f224493838e3224'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/skrollex/assets/js/script-bundle.min.js?ver=8dba6713421708b83f224493838e3224'></script>
<script>
/* <![CDATA[ */
var layers_script_settings = {"header_sticky_breakpoint":"270"};
/* ]]> */
</script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/themes/layerswp/assets/js/layers.framework.js?ver=1.5.3'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-includes/js/wp-embed.min.js?ver=4.5.4'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/plugins/easy-fancybox/fancybox/jquery.fancybox-1.3.7.min.js?ver=1.5.7'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/plugins/easy-fancybox/jquery.easing.pack.js?ver=1.3'></script>
<script src='http://skrollex-wp.x40.ru/anna/wp-content/plugins/easy-fancybox/jquery.mousewheel.min.js?ver=3.1.12'></script>
<script>
jQuery(document).on('ready post-load', easy_fancybox_handler );
</script>
</body>
</html>