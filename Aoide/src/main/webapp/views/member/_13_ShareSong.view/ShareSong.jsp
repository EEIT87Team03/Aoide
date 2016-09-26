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




<link rel="canonical" href="http://www.example.com" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>share Song</title>


</head>
<body>






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

									<div class="fb-like"
										data-href="http://localhost:8080/Aoide/index.jsp"
										data-layout="standard" data-action="like" data-size="small"
										data-show-faces="true" data-share="true"></div>


									<div class="fb-follow"
										data-href="http://localhost:8080/Aoide/index.jsp"
										data-layout="standard" data-size="small"
										data-show-faces="true"></div>

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
									<script>
										(function(d, s, id) {
											var js, fjs = d
													.getElementsByTagName(s)[0];
											if (d.getElementById(id))
												return;
											js = d.createElement(s);
											js.id = id;
											js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1";
											fjs.parentNode
													.insertBefore(js, fjs);
										}(document, 'script', 'facebook-jssdk'));
									</script> <script type="text/javascript"
										src="https://apis.google.com/js/plusone.js">
		{
			lang: 'zh-TW'
		}
	</script>


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

												<th>ShareLink</th>
												<th>FB Share</th>
												<th>Google+ Share</th>




												<c:forEach var="song" items="${getSong}">
													<tr>

														<td>${song.songId}</td>
														<td>${song.name}</td>



														<td><form>

																<a
																	href=<c:url value='/ShareServlet.member?id=${song.songId}'/>
																	class="btn"
																	onClick=" var name = prompt('網址.' , 'localhost8080/Aoide/ShareServlet.member?id=${song.songId}') ; ">複製網址</a>

															</form></td>



														<td><form>


																<a id="otherid"
																	src="http://tomcat.apache.org/images/tomcat.png"
																	class="btn"
																	href="javascript: void(window.open('http://www.facebook.com/share.php?u='.concat(encodeURIComponent('www.kimo.com.tw'))));">FB分享</a>
																
															</form></td>


														<td><form>
																<g:plusone href='http://tomcat.apache.org/'src="http://tomcat.apache.org/images/tomcat.png"></g:plusone>
															</form></td>

													</tr>
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
</body>
</html>
