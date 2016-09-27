<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<script src="/Aoide/template/plugins/ckeditor/ckeditor.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html" />


<title>評分評論</title>

<script type="text/javascript" src="../../../static/js/jquery-1.9.1.min.js"></script>
</head>


<body class="hold-transition skin-blue fixed sidebar-mini">
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
							寫出您對此首歌的意見 <small>(分數必填)</small>
						</h1>
						<br>
		

						<!-- Main content -->
						 <script type="text/javascript">
							var v = 0;
							function rate(obj, oEvent) {

								var imgSrc = "http://www.miankoutu.com/uploadfiles/2015-9-24/20159248311132.png";
								var imgSrc_2 ="http://www.miankoutu.com/uploadfiles/2015-9-24/2015924831100.png";

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
<!-- 											<th>類型</th> -->
<!-- 											<th>語言</th> -->
 											<th>上傳日期</th> 
											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="songOne" items="${getScore}">
											<tr>
												<%-- 					<td><% out.print(i = i + 1); %></td> --%>
												<td>${songOne.songId}</td>
												<td>${songOne.name}</td>
												<td>${songOne.singer}</td> 
<%-- 												<td>${songOne.songType}</td> --%>
<%-- 												<td>${songOne.songLanguage}</td> --%>
												<td>${songOne.updateDate}</td> 
												<table class="table">
												 <th>專輯封面</th> 
 												<table class="table">
                                                 <td> 
                                              	
<!--   	                 <img src = "/Aoide/files/song_cover_files/Songid01.jpg">   -->

     	                                   <img src="${songOne.coverFile}"> 
             
<!--                                                 </td>											</tr> -->
										</c:forEach>
									</tbody>
								</table>


								<table class="table">
									<thead>
										<tr>
											<th>會員</th>
											<th>日期</th>
											<th>給的分數</th>
											<th>評論內容</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="ScoreVO" items="${fulks}">
											<tr>
												<td>${ScoreVO.memberId}</td>
												<td>${ScoreVO.date}</td>
												<td>${ScoreVO.scoreValue}</td>
												<td>${ScoreVO.comment}</td>

											</tr>

										</c:forEach>
									</tbody>
								</table>
								<br>
								<div class="panel-body">
								    <table class="table">
                                  
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
															src="http://www.miankoutu.com/uploadfiles/2015-9-24/20159248311132.png" /></a>
														<a id="2" name="2" title="2"><img
															src="http://www.miankoutu.com/uploadfiles/2015-9-24/20159248311132.png" /></a>
														<a id="3" name="3" title="3"><img
															src="http://www.miankoutu.com/uploadfiles/2015-9-24/20159248311132.png" /></a>
														<a id="4" name="4" title="4"><img
															src="http://www.miankoutu.com/uploadfiles/2015-9-24/20159248311132.png" /></a>
														<a id="5" name="5" title="5"><img
															src="http://www.miankoutu.com/uploadfiles/2015-9-24/20159248311132.png" /></a>
														<br> &nbsp; &nbsp; 您給了: &nbsp; <span id="G8"
															style="width: 120px; height: 40px; font-size: 14px;">__</span>分


													
												</td>
						</tr>
												
				<td><textarea name="replyContent" id="reply" rows="5" cols="60" ></textarea>
				        <script>	                     	      
 			CKEDITOR.replace("reply",{ toolbar : "Basic" });		
	 	</script>    	
</tbody>

									</table>
<input type="button" onclick="sendStat()" class="btn" value="送出">

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





