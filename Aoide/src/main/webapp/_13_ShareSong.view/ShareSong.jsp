<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>share Song</title>





<meta property="og:url" content="http://www.AOIDE.com/index.html" />
<meta property="og:type" content="website" />
<meta property="og:title" content="AOIDE" />
<meta property="og:description" content="hello test" />
<meta property="og:image"
	content="http://www.your-domain.com/path/image.jpg" />

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
</head>
<body>

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

	<!-- Your share button code -->
	<div class="fb-share-button"
		data-href="http://www.AOide.com/index.html" data-layout="button_count">
	</div>



	<script>
		var fbhtml_url = window.location.toString();
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
									<th>MemberId</th>
									<th>SongId</th>
									<th>Date</th>
									<th>CopyLink</th>
									<th>FB Share</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="iscore" items="${getScore}">
									<tr>
										<td>${iscore.memberId}</td>
										<td>${iscore.songId}</td>
										<td>${iscore.date}</td>

										<%--  			    				      <td><a href="<c:url value='/GenerateReplyPageServlet?id=${iscore.songId}'/>" class="btn btn-info" role="button">評分</a></td> --%>


										<%--                                          <td> <a href="getScore.jsp" value='/GenerateReplyPageServlet?id=${iscore.scoreValue}' class="btn btn-info" role="button">分享</a></td> --%>

										<td><form>
												<a href="ShareSong.jsp"
													value='/GenerateReplyPageServlet?id=${iscore.scoreValue}'
													class="btn btn-info" role="button"
													onClick=" var name = prompt('網址.' , '網址.') ; ">分享</a>
												<!-- <input type="button" value="Ask me a question" -->
												<!-- onClick=" var name = prompt('What is your name?.' , 'You name here') ; alert('Hi, ' + name) "> -->
												<!-- </form></td> -->
											</form></td>
										</form>
										<td><a href="javascript:void(0);"
											onclick="window.open('http://www.facebook.com/sharer/sharer.php?u='+fbhtml_url);return false;"
											class="btn btn-info" role="button">FB分享</a></td>
									</tr>

									</tr>

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