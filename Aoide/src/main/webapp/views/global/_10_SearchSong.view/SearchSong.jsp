<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- head_library -->
  <c:import url="/template/htmlBlocks/head_library.html"/>
  <!-- head_library -->
  <script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
<title></title>

</head>
<!-- <body class="hold-transition skin-blue fixed sidebar-mini"> -->
<body>

<!-- Site wrapper -->
<div class="wrapper">
  <!-- header -->
<%--   <c:import url="/template/htmlBlocks/header.html"/> --%>
  <!-- header -->

  <!-- =============================================== -->

  <!-- sidebar -->
<%--   <c:import url="/template/htmlBlocks/sidebar_global.html"/> --%>
  <!-- sidebar -->

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
<!--   <div class="content-wrapper"> -->
   <div >
    <!-- Content Header (Page header) -->
<!--     <section class="content-header"> -->
<!--       <h1> -->
<!--         編輯會員資料 -->
<!--         <small>修改會員頭像/名稱/Email</small> -->
<!--       </h1> -->
<!--       <ol class="breadcrumb"> -->
<!--         <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li> -->
<!--         <li><a href="#">Layout</a></li> -->
<!--         <li class="active">Fixed</li> -->
<!--       </ol> -->
<!--     </section> -->

    <!-- Main content -->
    <section class="content">
      <!-- =========================================================== -->
      <div class="row">
        <!-- left empty column -->
        <div class="col-md-3">
        </div>
        <!-- /left empty column -->
        <!-- =========================================================== -->
        <!-- middle content column -->
        <div class="col-md-6">
	        <div class="box" style="background-color:transparent;color:white">
	        	<br>
	        	<br>
	        	<form action="<c:url value ='/SearchSongServlet'/>" method="post" style="text-align: center;">
					搜尋：<input type="text" name="searchSong" style="color:black">　
					<input class="btn" type="submit" value="送出" style="color:black">　${errorMsg.emptySearchMsg}
					<p>
					<input type="radio" name="searchType" value="name" checked>搜尋歌名　
					<input type="radio" name="searchType" value="singer">搜尋歌手　
					<input type="radio" name="searchType" value="album">搜尋專輯
				</form>
					<div style="padding-left: 215px;">
						<p>點歌規則:</p>
						<p>同一首歌曲 25 小時內只能點播一次。</p>
						<p>相同的演出者不能重複出現在播放清單上。</p>
						<p>一次限點播一首，播放清單上沒有其它人點播時才能連續點播。</p>
						<p>冷卻時間結束後 8 天內又再度被點播的歌曲會增加額外的冷卻時間。</p>
					</div>
				<br>
	        	<br>
			</div>
        </div>
        <!-- /middle content column -->
        <!-- =========================================================== -->
        <!-- right empty column -->
        <div class="col-md-3">
        </div>
        <!-- /right empty column -->
      </div>
      <!-- /.row -->
      <!-- =========================================================== -->
    </section>
    <!-- /.content -->
    <!-- =========================================================== -->
  </div>
  <!-- /.content-wrapper -->

  <!-- footer -->
<%--   <c:import url="/template/htmlBlocks/footer.html"/> --%>
  <!-- footer -->

  <!-- Control Sidebar -->
  <c:import url="/template/htmlBlocks/control_sidebar.html"/>
  <!-- Control Sidebar -->
</div>
<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->
<script src="/Aoide/js/_17_EditInfo/ajaxUploadImage.js"></script>
</body>
</html>