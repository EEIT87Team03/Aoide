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
<!-- <div class="wrapper"> -->
<div>
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
  <div>
    <!-- Content Header (Page header) -->
<!--     <section class="content-header"> -->
<!--       <h1> -->
<!--         回覆建議 -->
<!--         <small>編輯回覆內容</small> -->
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
          <!-- Collapsed box -->
          <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">${updatedSuggestion.title}</h3>

<!--               <div class="box-tools pull-right"> -->
<!--                 <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i> -->
<!--                 </button> -->
<!--               </div> -->
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <label>Suggestion</label>
              <span>${updatedSuggestion.suggestionContentFile}</span>
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
              <label>Reply</label>
              ${updatedSuggestion.replyContentFile}
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
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
<%--   <c:import url="/template/htmlBlocks/control_sidebar.html"/> --%>
  <!-- Control Sidebar -->
</div>
<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->
</body>
</html>