<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<script type="text/javascript"
	src="../../../static/js/jquery-1.9.1.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html" />

<title>Share Song</title>

<head>


<%-- <link rel="canonical" href="<c:url value='/DisplaySongServlet?id=${result.songId}'/>" /> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分享吧~</title>

   <!-- You can use Open Graph tags to customize link previews.
    Learn more: https://developers.facebook.com/docs/sharing/webmasters -->
	<meta property="og:url"           content="http://localhost:8080/Aoide/index.jsp" />
	<meta property="og:type"          content="website" />
	<meta property="og:title"         content="Aoide" />
	<meta property="og:description"   content="Share Your Song" />
	<meta property="og:image"         content="${song.coverFile}" />


</head>
<body>

<!-- Go to www.addthis.com/dashboard to customize your tools -->
<!-- <script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-57ea63172c50a682"></script> -->

<script src='https://googledrive.com/host/0BykclfTTti-0SlU3SDg5RUVtNlk/TOC_date_FB_main.js' type='text/javascript'></script>
<script src='https://googledrive.com/host/0BykclfTTti-0SlU3SDg5RUVtNlk/TOC_date_FB_display.js' type='text/javascript'></script>



	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
									<h1>
									<small>share Song</small>
									</h1>

									</section>

									<!-- Main content -->
									<section class="content">


									</script> <!--     FB function --> <script>
	window.___gcfg = {
		lang : 'en-US',
		parsetags : 'onload'
	};
</script> <script>
		window.___gcfg = {
			lang : 'zh-CN',
			parsetags : 'onload'
		};
	</script> <!-- 將這個標記放在標頭中，或放在內文結尾標記前面。 --> <script
										src="https://apis.google.com/js/platform.js" async defer>
	{
		lang: 'zh-TW'
	}
</script> <!-- Load Facebook SDK for JavaScript -->
		<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.7";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


									<div id="fb-root"></div>
									<script>
										(function(d, s, id) {
											var js, fjs = d
													.getElementsByTagName(s)[0];
											if (d.getElementById(id))
												return;
											js = d.createElement(s);
											js.id = id;
											js.src = "//connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v2.7";
											fjs.parentNode
													.insertBefore(js, fjs);
										}(document, 'script', 'facebook-jssdk'));
									</script>



									<title>Share</title>

									<div class="panel-body">

										<table class="table">
											<tbody>


												<th>SongId</th>
												<th>SongName</th>

<!-- 												<th>ShareLink</th> -->
<!-- 												<th>Share</th> -->
<!-- 												<th>Google+ Share</th> -->




												<c:forEach var="song" items="${getSong}">
													<tr>

														<td>${song.songId}</td>
														<td>${song.name}</td>
														<table class="table">
														<td><img src='${song.coverFile}'></td>



														<td><form>

																<a
																	href=<c:url value='/ShareServlet.member?id=${song.songId}'/>
																	class="btn"
																	onClick=" var name = prompt('網址.' , 'localhost8080/Aoide/ShareServlet.member?id=${song.songId}') ; ">複製網址</a>

															</form></td>



														<td><form>

<!-- Go to www.addthis.com/dashboard to customize your tools -->
<div class="addthis_inline_share_toolbox_8lsh"></div>

<%-- <div class="fb-share-button" data-href="<c:url value='Aoide/ShareServlet.member?id=${song.songId}'/>" data-layout="button" data-size="small" data-mobile-iframe="true"><a class="fb-xfbml-parse-ignore" target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Flocalhost%3A8080%2FAoide%2Findex.jsp&amp;src=sdkpreparse">分享</a></div> --%>

<!-- 																<a id="otherid"  -->
<%-- 																	src='${song.coverFile}' --%>
<!--  																	class="btn"  -->
<!--  																	href="javascript: void(window.open('http://www.facebook.com/share.php?u='.concat(encodeURIComponent('http://www.aoide.ch/'))));">FB分享</a> -->
																
															</form></td>

<!--                                                      <form> -->
<!--  														<g:plusone href='http://www.aoide.ch/' src="http://tomcat.apache.org/images/tomcat.png"></g:plusone> -->
                                                                                       
<!-- 													</tr></form> -->
												</c:forEach>
											</tbody>

										</table>

										<br>
									</div>
					
				<!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
	</div>

	<!-- body-library  -->
	<c:import url="/TestHTML/body_library.html" />
<!-- Go to www.addthis.com/dashboard to customize your tools -->
<script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-57ea63172c50a682"></script>
</body>
</html>
