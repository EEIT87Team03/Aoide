<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- head-library  -->
<c:import url="/TestHTML/head_library.html"/>
</head>
<body>
	<div class="container-fluid">
  		<div class="row">
			<div class="col-xs-6 col-md-3"></div>
			<div class="col-xs-6 col-md-6" id="middleContent">
            <!-- ========================================= -->
			    <!-- Main content -->
    			<section class="content">
			    	  <!-- Widget: user widget style 1 -->
			          <div class="box box-widget widget-user">
			            <!-- Add the bg color to the header using any of the bg-* classes -->
			            <div class="widget-user-header bg-black" style="background: url('/Aoide/views/dist/img/photo1.png') center center;">
			              <h3 class="widget-user-username">${ member.name }</h3>
			              <h5 class="widget-user-desc">${ member.account }</h5>
			            </div>
			            <div class="widget-user-image">
			              <!--<img class="img-circle" src="../dist/img/user3-128x128.jpg" alt="User Avatar">-->
			              <img class="img-circle" src="data:image/*;base64,${ member.picture }" alt="User Avatar">
			            </div>
			            <!-- =============================================== -->
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
			            <!-- / 3 widget cols -->
			            <!-- =============================================== -->
			            <div class="box-body">
			            	<label>Account</label>
		                    <div class="box-body-content">${member.account}</div>
		                    <br>
		                    <label>Name :</label>
		                    <div class="box-body-content">${member.name}</div>
			            	<br>
			            	<label>Email</label>
			            	<div class="box-body-content">${ member.email }</div>
			            	<br>
			            	<label>Introduction</label>
			            	<div class="box-body-content">${ member.introductionFilePath }</div>
			            </div>
			            <!-- /.box-footer no-padding -->
			            <!-- =============================================== -->
			          </div>
			          <!-- /.widget-user -->
    			</section>
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>