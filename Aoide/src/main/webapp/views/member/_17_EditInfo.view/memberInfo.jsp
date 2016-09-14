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
        編輯會員資料
        <small>修改會員頭像/名稱/Email</small>
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
          <div class="box box-widget widget-user">
            <!-- Add the bg color to the header using any of the bg-* classes -->
            <div class="widget-user-header bg-black" style="background: url('/Aoide/views/dist/img/photo1.png') center center;">
              <h3 class="widget-user-username">${ member.name }</h3>
              <h5 class="widget-user-desc">${ member.account }</h5>
            </div>
            <div class="widget-user-image">
              <!--<img class="img-circle" src="../dist/img/user3-128x128.jpg" alt="User Avatar">-->
              <img class="img-circle" id = "current" src="data:image/*;base64,${member.picture}" alt="User Avatar">
              <img class="img-circle" src="#" id = "preview"  alt = "preview image" style = "display : none"/>
            </div>
            <!-- /.box-header -->
            <!-- =========================================================== -->
            <div class="box-footer">
              <div class="row">
                <div class="col-sm-4 border-right">
                  <div class="description-block">
                    <h5 class="description-header">登入日期</h5>
                    <span class="description-text">${ member.lastLoginDate }</span>
                  </div>
                  <!-- /.description-block -->
                </div>
                <!-- /.col -->
                <div class="col-sm-4 border-right">
                  <div class="description-block">
                    <h5 class="description-header">登入次數</h5>
                    <span class="description-text">${ member.loginCount }</span>
                  </div>
                  <!-- /.description-block -->
                </div>
                <!-- /.col -->
                <div class="col-sm-4">
                  <div class="description-block">
                    <h5 class="description-header">會員點數</h5>
                    <span class="description-text">${ member.tokenTotal }</span>
                  </div>
                  <!-- /.description-block -->
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->
            </div>
            <!-- =========================================================== -->
            <!-- Edit info form -->
            <form role="form" action="<c:url value='/EditInfoServlet'/>" method="POST">
              <div class="box-body">
                  <!-- =========================================================== -->
                  <!-- Edit Picture -->
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-8">
                        <div class="form-group">
                          <label for="exampleInputFile">Picture :</label>
                            <input class="button" type = "file" id = "selectedFile" accept="image/*" name = "selectedFile">
                        </div>
                    </div>
                    <div class="col-xs-2">
                      <span style="float:right;">
                        <input class="btn btn-default" type = "button" id = "upload" value = "Upload"><span id="progress"></span>
                    </div>
                    <div class="col-xs-1">
                    </div>
                  </div>
                  <!-- /.row -->
                  <!-- =========================================================== -->
                  <!-- Edit Account -->
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-8">
                        <div class="form-group">
                          <label>Account :</label>
                          <input name="account" type="text" class="form-control" value="${member.account}" disabled>
                        </div> 
                    </div>
                    <div class="col-xs-2">
                      <button class="btn btn-default pull-right" >Edit</button>
                    </div>
                    <div class="col-xs-1">
                    </div>
                  </div>
                  <!-- /.row -->
                  <!-- =========================================================== -->
                  <!-- Edit Name -->
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-8">
                      <div class="form-group">
                        <label>Name :</label>
                        <input name="name" type="text" class="form-control" value="${member.name}" >
                      </div>
                    </div>
                    <div class="col-xs-2">
                      <button class="btn btn-default pull-right" >Edit</button>
                    </div>
                    <div class="col-xs-1">
                    </div>
                  </div>
                  <!-- /.row -->
                  <!-- =========================================================== -->
                  <!-- Edit Email -->
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-8">
                     <div class="form-group">
                        <label>Email :</label>
                        <input name="email" type="text" class="form-control" value="${member.email}">
                      </div>
                    </div>
                    <div class="col-xs-2">
                      <button class="btn btn-default pull-right" >Edit</button>
                    </div>
                    <div class="col-xs-1">
                    </div>
                  </div>
                  <!-- /.row -->
                  <!-- =========================================================== -->
                  <!-- Edit Intriduction -->
                  <div class="row">
                    <div class="col-xs-1">
                    </div>
                    <div class="col-xs-8">
                      <div class="form-group">
                        <label>"Introduction"</label>
                        <textarea name="introduction"  id="introduction" rows="10" cols="80"  value="${member.introductionFilePath}">
                        </textarea>
                               <script>
                                   // Replace the <textarea id="editor1"> with a CKEditor
                                   // instance, using default configuration.
                                   CKEDITOR.replace( 'introduction' );
                           </script>
                      </div>
                    </div>
                    <div class="col-xs-2">
                      <button class="btn btn-default pull-right" >Edit</button>
                    </div>
                    <div class="col-xs-1">
                    </div>
                  </div>
                  <!-- /.row -->
                  <!-- =========================================================== -->
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <input class="btn btn-info pull-right" type="submit" value="Submit">
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
<script src="../../../js/_17_EditInfo/ajaxUploadImage.js"></script>
</body>
</html>