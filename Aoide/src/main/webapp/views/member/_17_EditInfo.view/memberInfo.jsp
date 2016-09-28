<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html"/>

<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
</head>
<body>
	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
			
			<!-- Main content -->
		    <section class="content">
		      <!-- =========================================================== -->
		      <div class="row">
		          <!-- box -->
		          <div class="box box-widget widget-user">
		            <!-- Add the bg color to the header using any of the bg-* classes -->
		            <div class="widget-user-header bg-black" style="background: url('/Aoide/views/dist/img/photo1.png') center center;">
		              <h3 class="widget-user-username">${ member.name }</h3>
		              <h5 class="widget-user-desc">${ member.account }</h5>
		            </div>
		            <div class="widget-user-image">
		              <!--<img class="img-circle" src="../dist/img/user3-128x128.jpg" alt="User Avatar">-->
		              <img class="img-circle"  src="data:image/*;base64,${member.picture}" alt="User Avatar">
<!-- 		              <img class="img-circle" src="#" id = "preview"  alt = "preview image" style = "display : none"/> -->
		            </div>
		            <!-- /.box-header -->
		            <!-- =========================================================== -->
		            <div class="box-footer">
		              <div class="row">
		                <div class="col-sm-4 border-right">
		                  <div class="description-block">
		                    <h5 class="description-header">登入日期</h5>
		                    <span class="description-text">${member.lastLoginDate }</span>
		                  </div>
		                  <!-- /.description-block -->
		                </div>
		                <!-- /.col -->
		                <div class="col-sm-4 border-right">
		                  <div class="description-block">
		                    <h5 class="description-header">登入次數</h5>
		                    <span class="description-text">${member.loginCount}</span>
		                  </div>
		                  <!-- /.description-block -->
		                </div>
		                <!-- /.col -->
		                <div class="col-sm-4">
		                  <div class="description-block">
		                    <h5 class="description-header">會員點數</h5>
		                    <span class="description-text">${member.tokenTotal}</span>
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
		                    </div>
		                    <div class="col-xs-1">
		                    </div>
		                  </div>
		                  <!-- /.row -->
		                  <!-- =========================================================== -->
		                  <!-- Edit Picture -->
		                  <div class="row">
		                    <div class="col-xs-1">
		                    </div>
		                    <div class="col-xs-8">
		                        <div class="form-group">
		                          <label for="exampleInputFile">Picture :</label>
		                            <input type = "file" id = "selectedFile" accept="image/*" name = "selectedFile">
		                        </div>
		                        <div style="align:left;">
		                            <img class="img-circle" id = "current" src="data:image/*;base64,${member.picture}" alt="User Avatar" style = "height:100px; width:100px;">
		                            <img class="img-circle" src="#" id = "preview"  alt = "preview image" style = "display:none; height:100px; width:100px;"/>
		                        </div>
		                    </div>
		                    <div class="col-xs-2">
		                      
		                      <br>
		                      <span style="float:right;">
		                        <input class="btn btn-default" type = "button" id = "upload" value = "Upload"><span id="progress"></span>
		                      </span>
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
		                        <label>Introduction</label>
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
		                <br>
		                <br>
		              </div>
		              <!-- /.box-footer -->
		            </form>            
		          </div>
		          <!-- /.box -->
		      </div>
		      <!-- /.row -->
		      <!-- =========================================================== -->
		    </section>
		    <!-- /.content -->

            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->

<script src="<c:url value='/js/_17_EditInfo/ajaxUploadImage.js'/>"></script>
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>