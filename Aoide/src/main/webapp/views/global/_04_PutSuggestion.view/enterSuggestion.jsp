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
<title>編輯建議</title>

</head>
<!-- <body class="hold-transition skin-blue fixed sidebar-mini"> -->
<body>
<!-- Site wrapper -->
<!-- <div class="wrapper"> -->
  <!-- header -->
  <%--  <c:import url="/template/htmlBlocks/header.html"/> --%>
  <!-- header -->
  <!-- header -->

  <!-- =============================================== -->

  <!-- sidebar -->
  <!-- header -->
   <%-- <c:import url="/template/htmlBlocks/sidebar_global.html"/> --%>
  <!-- sidebar -->

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
<!--   <div class="content-wrapper"> -->
  <div>
    <!-- Content Header (Page header) -->
<!--     <section class="content-header"> -->
<!--       <h1> -->
<!--         新增建議 -->
<!--         <small>編輯建議標題/內容</small> -->
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
          <div class="box" >
            <!-- Add the bg color to the header using any of the bg-* classes -->
            <div class="box-header with-border">
              <h3 class="box-title">編輯建議表單</h3>
            </div>
            <!-- /.box-header -->
            <!-- =========================================================== -->

            <!-- =========================================================== -->
            <!-- Edit info form -->
            <form role="form" action="<c:url value='/SaveSuggestionServlet'/>" method="POST">
              <div class="box-body">
                  <!-- =========================================================== -->
                  <!-- Edit Title -->
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-5">
                        <div class="form-group">
                          <label>建議標題</label>
                          <input type="text" name="title" class="form-control" value="${enteredText.title}"> ${errorMsg.emptyTitleMsg}
                        </div> 
                    </div>
                    <div class="col-xs-6">
                    </div>
                  </div>
                  <!-- /.row -->
                  <!-- =========================================================== -->
                  <!-- Edit Suggestion -->
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-10">
                      <div class="form-group">
                        <label>建議內容</label><span style="padding:10px;">${errorMsg.emptyContentMsg}</span>
                        <textarea name="content"  id="suggestionContent" rows="10" cols="80" >
                        ${enteredText.content}
                        </textarea>
                        <script>
                            // Replace the <textarea id="editor1"> with a CKEditor
                            // instance, using default configuration.
                            CKEDITOR.replace( 'suggestionContent' );
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
  <%-- <c:import url="/template/htmlBlocks/footer.html"/> --%>
  <!-- footer -->

  <!-- Control Sidebar -->
  <%-- <c:import url="/template/htmlBlocks/control_sidebar.html"/> --%>
  <!-- Control Sidebar -->
<!-- </div> -->
<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->
</body>
</html>