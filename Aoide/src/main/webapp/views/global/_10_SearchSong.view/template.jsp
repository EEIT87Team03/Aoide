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
<title>編輯會員資料</title>

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
        <div class="col-md-2">
        </div>
        <!-- /left empty column -->
        <!-- =========================================================== -->
        <!-- middle content column -->
        <div class="col-md-8">
		      <!-- Default box -->
		      <div class="box">
		        <div class="box-header with-border">
		          <h3 class="box-title">搜尋結果</h3>
		        </div>
		        <!-- /.box-body -->
		        <div class="box-body">
			    <!-- /.table -->
			    ${type1}
				<% int i = 0; %>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>　</th>
							<th>專輯ID</th>
							<th>專輯名稱</th>
							<th>演出者</th>
							<th>上傳日期</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="result" items="${searchList}">
							<tr>
								<td><% out.print(i = i + 1); %></td>
								<td>${result.albumId}</td>
								<td>${result.name}</td>
								<td>${result.artist}</td>
								<td>${result.updateDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				 <p>共有<% out.print(i); %>項符合搜尋結果</p>
			     <p><a href="SearchSong.jsp">回搜尋歌曲</a></p>
		         <!-- /.table -->
		       </div>
		        <!-- /.box-body -->
		        <div class="box-footer clearfix">
		          <ul class="pagination pagination-sm no-margin pull-right">
		            <li><a href="#">&laquo;</a></li>
		            <li><a href="#">1</a></li>
		            <li><a href="#">2</a></li>
		            <li><a href="#">3</a></li>
		            <li><a href="#">&raquo;</a></li>
		          </ul>
		        </div>
		        <!-- /.box-footer-->
		      </div>
		      <!-- /.box -->
        </div>
        <!-- /middle content column -->
        <!-- =========================================================== -->
        <!-- right empty column -->
        <div class="col-md-2">
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