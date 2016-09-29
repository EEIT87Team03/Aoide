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
			   <div class="box">
	            <div class="box-header with-border">
	              <h3 class="box-title">${suggestion.title}</h3>
	            </div>
	            <!-- /.box-header -->
	            <div class="box-body">
	              <label>您的建議:</label>
	              <div class="box-body-content">
	              	${suggestion.suggestionContentFile}
	              </div>
	            </div>
	            <!-- /.box-body -->
	           </div>
	           <!-- /.box -->
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