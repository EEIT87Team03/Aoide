<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  
  <!-- head_library -->
  <c:import url="/template/htmlBlocks/head_library.html"/>
  <!-- head_library -->
<title>Score</title>


</head>
<body class="hold-transition skin-blue fixed sidebar-mini">
<!-- Site wrapper -->

<div class="wrapper">
  <!-- header -->
  <c:import url="/template/htmlBlocks/header.html"/>
  <!-- header -->

  <!-- =============================================== -->

  <!-- sidebar -->
  <c:import url="/template/htmlBlocks/sidebar_global.html"/>
  <!-- sidebar -->

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Score
        <small>Score Your Song</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="\Aoide\_14_Score.view\index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Song</a></li>
<!--         <li class="active">Fixed</li> -->
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
<script type="text/javascript">

  var v =0;
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

	
	
	// 	var gb = 0;

	function myFunction(event) {

		var a = "too bad";
		var b = "bad";
		var c = "so so";
		var d = "good";
		var e = "very well";

		//    		 var bb = a.onclick = document.getElementById("g7").id
		//     		 alert(bb);

		v = document.getElementById("G8").innerText;

		if (v == document.getElementById("1").id) {
			alert(a);
		} else if (v == document.getElementById("2").id) {
			alert(b);
		} else if (v == document.getElementById("3").id) {
			alert(c);

		} else if (v == document.getElementById("4").id) {
			alert(d);

		} else if (v == document.getElementById("5").id)
			alert(e);
         
	}

	function sendStat() {
		alert(v);
		//var formData = new FormData();
		//formData.append("socreStar", G8);  上傳用mulitipart data

		xhr = new XMLHttpRequest();

		xhr.onload = function() {
			if (this.status == 200) {
				alert("send done");

			} else {

				alert("Please Enter Point & Comment");
			}
		}
      xhr.open("post", "/Aoide/ScoreInDataBaseServlet.member");
      xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
      var comment = document.getElementById("replyContent").value;
      console.log(comment);
	  xhr.send("socreStar="+ v + "&comment=" + comment );
	}
</script>

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title"></h3>
      

<title>評分評論</title>
<!-- <script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script> -->
<!-- <!-- Latest compiled and minified CSS --> 
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" -->
<!-- 	crossorigin="anonymous"> -->

<!-- <!-- Optional theme --> 
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" -->
<!-- 	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" -->
<!-- 	crossorigin="anonymous"> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<div class="container"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-lg-1"></div> -->
<!-- 			<div class="col-lg-10"> -->
<!-- 				<div class="panel panel-primary"> -->
<!-- 					<div class="panel-heading"> -->
<!-- 						<a href=""></a> -->
<!-- 					</div> -->
					<div class="panel-body">

						<table class="table">
							<thead>
								<tr>
									<th>MemberId</th>
									<th>SongId</th>
									<th>Date</th>
									<th>ScoreValue</th>
									<th>CommentFile</th>
								</tr>
							</thead>
							<tbody>

								<script>
									
								</script>


								<tr>
									<td>${scoreVO.memberId}</td>
									<td>${scoreVO.songId}</td>
									<td>Date</td>
									<td>
										<!-- 顯示star與取值 -->


										<form action="/GetScoreServlet?"></form>
										<p id="g7" class="starWrapper" onmouseover="rate(this,event)">


											<a id="1" name="1" title="1"><img
												src="http://www.jb51.net/upload/20080508122008586.gif" /></a> <a
												id="2" name="2" title="2"><img
												src="http://www.jb51.net/upload/20080508122008586.gif" /></a> <a
												id="3" name="3" title="3"><img
												src="http://www.jb51.net/upload/20080508122008586.gif" /></a> <a
												id="4" name="4" title="4"><img
												src="http://www.jb51.net/upload/20080508122008586.gif" /></a> <a
												id="5" name="5" title="5"><img
												src="http://www.jb51.net/upload/20080508122008586.gif" /></a> <br>
											&nbsp; &nbsp; 分數為: &nbsp; <span id="G8"
												style="width: 120px; height: 40px; font-size: 14px;">......</span>
									</td>

									<td>  <textarea name="replyContent" id="replyContent" rows="5" cols="60">
				                     
				            </textarea>
									<td><button onclick="sendStat()" type="button" herf="\_14_Score.view\CommentPresent.jsp" class="btn btn-info" role="button"
											value="sumit"><span class="glyphicon glyphicon-hand-down"></span> Summit!
        </button><br>
        
        <br>
                                            <br>&nbsp; &nbsp;<a class="btn btn-info" role="button" href="CommentPresent.jsp" align="center"><span class="glyphicon glyphicon-eye-open"></span><br>Comment</a>
										</td>
                                             
									
									<a href="http://localhost:8080/Aoide/index.jsp" class="btn btn-info" role="button"  >回首頁</a>
									
									
									
									
							</tbody>
						</table>

						<br>
					</div>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        
      
        <!-- /.box-body -->

        <!-- /.box-footer-->
    
      <!-- /.box -->


    <!-- /.content -->

  <!-- /.content-wrapper -->

  <!-- footer -->
  <c:import url="/template/htmlBlocks/footer.html"/>
  <!-- footer -->

  <!-- Control Sidebar -->
  <c:import url="/template/htmlBlocks/control_sidebar.html"/>
  <!-- Control Sidebar -->

<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->
</body>
</html>





