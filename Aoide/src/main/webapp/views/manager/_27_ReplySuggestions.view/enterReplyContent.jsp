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
        回覆建議
        <small>編輯回覆內容</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Layout</a></li>
        <li class="active">Fixed</li>
      </ol>
    </section>

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
          <div class="box" >
            <!-- Add the bg color to the header using any of the bg-* classes -->
            <div class="box-header with-border">
              <h3 class="box-title">編輯回覆表單</h3>
            </div>
            <!-- /.box-header -->
            <!-- =========================================================== -->

            <!-- =========================================================== -->
            <!-- Edit info form -->
            <form role="form" action="<c:url value='/SaveSuggestionReplyServlet'/>" method="POST">
              <div class="box-body">
                  <!-- =========================================================== -->
                  <!-- Title -->
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-5">
                        <div class="form-group">
                          <label>Title</label>
                          ${suggestion.title}
                        </div> 
                    </div>
                    <div class="col-xs-6">
                    </div>
                  </div>
                  <!-- /.row -->
                  <!-- =========================================================== -->
                  <!-- Suggestion -->
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-5">
                        <div class="form-group">
                          <label>Suggestion</label>
                          ${suggestion.suggestionContentFile}
                        </div> 
                    </div>
                    <div class="col-xs-6">
                    </div>
                  </div>
                  <!-- /.row -->
                  <!-- =========================================================== -->
                  <!-- Edit Reply -->
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-10">
                      <div class="form-group">
                        <label>Reply</label>
                        <textarea name="replyContent"  id="replyContent" rows="10" cols="80" >
                        </textarea>
                        <script>
                            // Replace the <textarea id="editor1"> with a CKEditor
                            // instance, using default configuration.
                            CKEDITOR.replace( 'replyContent' );
                        </script>
                      </div>
                    </div>
                    <div class="col-xs-1">
                    </div>
                  </div>
                  <!-- /.row -->
                  <!-- =========================================================== -->
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-10">
                      <input class="btn btn-info pull-right" type="submit" value="Submit">
                    </div>
                    <div class="col-xs-1">
                    </div>
                  </div>
                  <!-- /.row -->
              </div>
              <!-- /.box-footer -->
            </form>            
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
</body>
</html>