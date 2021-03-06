<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<!-- head-library  -->
	<c:import url="/TestHTML/head_library.html" />
	<!-- ck editor -->
	<script src="/Aoide/template/plugins/ckeditor/ckeditor.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
				<!-- ========================================= -->
				<!-- Site wrapper -->
				<div class="wrapper">
					<div class="content-wrapper">
						<!-- Content Header (Page header) -->
						<section class="content-header">
						<h1>
							SongInfo <small>do something</small>
						</h1>
						<br>
						<a href="<c:url value='/BuildPlaylistServlet?id='/>"><svg fill="#000000" height="24"
								viewBox="0 0 24 24" width="24"
								xmlns="http://www.w3.org/2000/svg"> <path
								d="M8 5v14l11-7z" /> <path d="M0 0h24v24H0z" fill="none" /> </svg></a> <script
							type="text/javascript" src="http://mediaplayer.yahoo.com/js"></script>

						<button style="background-color: #C2C2FF" title="蒐藏"
							onclick="location.href='<c:url value='/UpdateFavoriteServlet.member'/>'">
							<svg fill="#000000" height="18" viewBox="0 0 18 18" width="18"
								xmlns="http://www.w3.org/2000/svg"> <path
								d="M9 11.3l3.71 2.7-1.42-4.36L15 7h-4.55L9 2.5 7.55 7H3l3.71 2.64L5.29 14z" />
							<path d="M0 0h18v18H0z" fill="none" /> </svg>
						</button>

						<button style="background-color: #C2C2FF" title="分享"
							onclick="location.href='<c:url value='/ShareServlet.member'/>'">
							<svg fill="#000000" height="18" viewBox="0 0 24 24" width="18"
								xmlns="http://www.w3.org/2000/svg"> <path
								d="M0 0h24v24H0z" fill="none" /> <path
								d="M1 21h4V9H1v12zm22-11c0-1.1-.9-2-2-2h-6.31l.95-4.57.03-.32c0-.41-.17-.79-.44-1.06L14.17 1 7.59 7.59C7.22 7.95 7 8.45 7 9v10c0 1.1.9 2 2 2h9c.83 0 1.54-.5 1.84-1.22l3.02-7.05c.09-.23.14-.47.14-.73v-1.91l-.01-.01L23 10z" />
							</svg>
						</button>

						<button style="background-color: #C2C2FF" title="贊助"
							onclick="location.href='<c:url value=''/>'">
							<svg fill="#000000" height="18" viewBox="0 0 24 24" width="18"
								xmlns="http://www.w3.org/2000/svg"> <g> <path
								d="M0 0h24v24H0z" fill="none" /> <path
								d="M16.49 15.5v-1.75L14 16.25l2.49 2.5V17H22v-1.5z" /> <path
								d="M19.51 19.75H14v1.5h5.51V23L22 20.5 19.51 18z" /> <g> <path
								d="M9.5 5.5c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zM5.75 8.9L3 23h2.1l1.75-8L9 17v6h2v-7.55L8.95 13.4l.6-3C10.85 12 12.8 13 15 13v-2c-1.85 0-3.45-1-4.35-2.45l-.95-1.6C9.35 6.35 8.7 6 8 6c-.25 0-.5.05-.75.15L2 8.3V13h2V9.65l1.75-.75" />
							</g></g> </svg>
						</button>
					
						</section>

						<!-- Main content -->
						 <script type="text/javascript">
							var v = 0;
							function rate(obj, oEvent) {

								var imgSrc = 'http://www.jb51.net/upload/20080508122008586.gif';
								var imgSrc_2 = 'http://www.jb51.net/upload/20080508122010810.gif';

								if (obj.rateFlag)
									return;
								var e = oEvent || window.event;

								var target = e.target || e.srcElement;
								var imgArray = obj.getElementsByTagName("img");

								for (var i = 0; i < imgArray.length; i++) {
									imgArray[i]._num = i;
									imgArray[i].onclick = function() {
										if (obj.rateFlag)
											return;
										obj.rateFlag = true;

										document.getElementById("G8").innerText = this._num + 1;
										v = this._num + 1;

										;

									};
								}

								if (target.tagName == "IMG") {
									for (var j = 0; j < imgArray.length; j++) {
										if (j <= target._num) {
											imgArray[j].src = imgSrc_2;
										} else {
											imgArray[j].src = imgSrc;
										}
									}
								} else {
									for (var k = 0; k < imgArray.length; k++) {
										imgArray[k].src = imgSrc;
									}
								}

							}

							function sendStat() {
								alert(v);
								//var formData = new FormData();
								//formData.append("socreStar", G8);  上傳用mulitipart data

								xhr = new XMLHttpRequest();

								xhr.onload = function() {
									if (this.status == 200) {
										alert("評論已送出");
										top.location.href = "<c:url value='/GetScoreServlet.member'/>"

									} else {

										alert("請誤空白以及重複評分");

									}
								}
								xhr.open("post",
										"/Aoide/ScoreInDataBaseServlet.member",
										true);
								xhr.setRequestHeader("Content-Type",
										"application/x-www-form-urlencoded");
// 								var comment = document
// 										.getElementById("launcher").value;
                                var comment = CKEDITOR.instances.reply.getData()
								console.log(comment);
								xhr.send("socreStar=" + v + "&comment="
										+ comment);
// 								cke_1_contents
							}
						</script> <!-- Default box -->
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title"></h3>


								<title>評分評論</title>
         

								<table class="table">
									<thead>
										<tr>
											<th>歌曲ID</th>
											<th>歌名</th>
											<th>演出者</th>
											<th>類型</th>
											<th>語言</th>
											<th>上傳日期</th>
											<th>專輯封面</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>${song.songId}</td>
											<td>${song.name}</td>
											<td>${song.singer}</td>
											<td>${song.songType}</td>
											<td>${song.songLanguage}</td>
											<td>${song.updateDate}</td> 
                                            <td><img src="${song.coverFile}"></td>											
                                         </tr>
									</tbody>
								</table>

								<table class="table">
									<thead>
										<tr>
											<th>MemberId</th>
											<th>Date</th>
											<th>ScoreValue</th>
											<th>CommentFile</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="aScore" items="${scores}">
											<tr>
												<td>${aScore.memberId}</td>
												<td>${aScore.date}</td>
												<td>${aScore.scoreValue}</td>
												<td>${aScore.comment}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<br>
								<div class="panel-body">
									<table class="table">
										<thead>
											<tr>
												<th>請評分~</th>
												<br>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>
													<!-- 顯示star與取值 -->
													<p id="g7" class="starWrapper"
														onmouseover="rate(this,event)">
														<a id="1" name="1" title="1"><img
															src="http://www.jb51.net/upload/20080508122008586.gif" /></a>
														<a id="2" name="2" title="2"><img
															src="http://www.jb51.net/upload/20080508122008586.gif" /></a>
														<a id="3" name="3" title="3"><img
															src="http://www.jb51.net/upload/20080508122008586.gif" /></a>
														<a id="4" name="4" title="4"><img
															src="http://www.jb51.net/upload/20080508122008586.gif" /></a>
														<a id="5" name="5" title="5"><img
															src="http://www.jb51.net/upload/20080508122008586.gif" /></a>
														<br> &nbsp; &nbsp; 您給了: &nbsp; <span id="G8"
															style="width: 120px; height: 40px; font-size: 14px;">__</span>分
												</td>
						                    </tr>
											<tr>
												<td>	
				         							<textarea name="replyContent" id="reply" rows="5" cols="60" ></textarea>
				        							<script>CKEDITOR.replace("reply",{ toolbar : "Basic" });</script>    							
	 											</td>
	 										</tr>
                                        </tbody>
									</table>
                                    <input type="button" onclick="sendStat()" class="btn" value="繳交">
									<br>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>





