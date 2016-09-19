<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>




<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">


<link rel="canonical" href="http://www.example.com" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>share Song</title>



</head>
<body>

<script type="text/javascript" src="../static/js/jquery-3.1.0.min.js"></script>



<!--     FB function -->

	<script>
		window.___gcfg = {
			lang : 'en-US',
			parsetags : 'onload'
		};
	</script>
	
  <script >
  window.___gcfg = {
    lang: 'zh-CN',
    parsetags: 'onload'
  };
</script>
<!-- 將這個標記放在標頭中，或放在內文結尾標記前面。 -->
<script src="https://apis.google.com/js/platform.js" async defer>
  {lang: 'zh-TW'}
</script>
  
	<!-- Load Facebook SDK for JavaScript -->
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

<script type="text/javascript" src="https://apis.google.com/js/plusone.js">
  {lang: 'zh-TW'}
</script>


	
	<div class="container">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<a href=""></a>
					</div>
					<div class="panel-body">

						<table class="table">
							<thead>
								<tr>

									<th>SongId</th>
									<th>SongName</th>
									
									<th>ShareLink</th>
									<th>FB Share</th>
									<th>Google+ Share</th>

								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="song" items="${getSong}">
									<tr>

										<td>${song.songId}</td>
                                        <td>${song.name}</td>

										<%--  			    				      <td><a href="<c:url value='/GenerateReplyPageServlet?id=${iscore.songId}'/>" class="btn btn-info" role="button">評分</a></td> --%>


										<%--                                          <td> <a href="getScore.jsp" value='/GenerateReplyPageServlet?id=${iscore.scoreValue}' class="btn btn-info" role="button">分享</a></td> --%>

										<td><form>
												<a href=<c:url value='/ShareServlet.member?id=${song.songId}'/> 
													value='/SelectOne'
													class="btn btn-info" role="button" 
													onClick=" var name = prompt('網址.' , 'You link here') ; " >分享</a>




											</form></td>

										
										<!-- <input type="button" value="Close this window" onClick="window.close()">  關閉視窗  -->

										<!-- 										<td><a href="javascript:void(0);" -->
										<!-- 											onclick="window.open('http://www.facebook.com/share.php?u='.concat(encodeURIComponent('http://www.web.com.tw/activity/index.html'));return false;" -->
										<!-- 											class="btn btn-info" role="button">FB分享</a></td> -->

										<td><form>
												<a class="btn btn-info" role="button" id="otherid" src="http://tomcat.apache.org/images/tomcat.png"
													href="javascript: void(window.open('http://www.facebook.com/share.php?u='.concat(encodeURIComponent('http://tomcat.apache.org/'))));">FB分享</a>
											</form></td>
										<td><form>
										<g:plusone href='http://tomcat.apache.org/' src="http://tomcat.apache.org/images/tomcat.png"></g:plusone>
											</form></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>

						<br>
					</div>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>
</body>
</html>