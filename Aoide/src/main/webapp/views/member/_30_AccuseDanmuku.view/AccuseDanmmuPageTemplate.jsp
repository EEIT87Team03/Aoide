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
  
  <!-- _05_DisplayDanmuku_library_css -->
  <c:import url="/views/global/_05_DisplayDanmuku/_05_DisplayDanmuku_library_css.html"/>
  <!-- _05_DisplayDanmuku_library_css -->
  
  <!-- head_library -->
<title>_21_EnterDanmuku(輸入檢舉原因頁面.....)</title>
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
        Fixed Layout
        <small>Blank example to the fixed layout</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Layout</a></li>
        <li class="active">Fixed</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-12">
        
        
        <!-- 文字編輯區塊開始 -->
          <div class="box box-info">
            <div class="box-header">
              <h3 class="box-title">我來檢舉囉~~~~
                <small>請輸入檢舉原因~~</small>
              </h3>
              
            </div>
            <!-- /.box-header -->
            <div class="box-body pad">
              <form action="<c:url value='/SaveAccuseDanmukuServlet'/>" method="post">
                    <textarea id="editor1" name="replyContent" rows="10" cols="80">
                                           
                    </textarea>
                    <input class="btn btn-primary" type="submit" value="Submit">
              </form>
            </div>
          </div>
          <!-- 文字編輯區塊結束 -->
          
          <!-- /.box -->

        </div>
        <!-- /.col-->
      </div>
      <!-- ./row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- footer -->
  <c:import url="/template/htmlBlocks/footer.html"/>
  <!-- footer -->

  <!-- Control Sidebar -->
  <c:import url="/template/htmlBlocks/control_sidebar.html"/>
  <!-- Control Sidebar -->
</div>
<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->

<!-- _05_DisplayDanmuku_library -->
<c:import url="/views/global/_05_DisplayDanmuku/_05_DisplayDanmuku_library.html"/>
<!-- _05_DisplayDanmuku_library -->

<script src="https://cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>
<script>
  $(function () {
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('editor1');
    //bootstrap WYSIHTML5 - text editor
    $(".textarea").wysihtml5();
  });
</script>
</body>
</html>