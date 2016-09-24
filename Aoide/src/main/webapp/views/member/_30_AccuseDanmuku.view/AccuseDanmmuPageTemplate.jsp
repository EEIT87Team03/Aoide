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
            
			<div class="box box-info">
            <div class="box-header">
              <h3 class="box-title">我來檢舉囉~~~~
                <small>請輸入檢舉原因~~</small>
              </h3>
              
            </div>
            <!-- /.box-header -->
            <form action="<c:url value='/SaveAccuseDanmukuServlet'/>" method="post">
            <div class="box-body pad">
              
                    <textarea id="editor1" name="replyContent" rows="10" cols="80">
                                           
                    </textarea>
              
            </div>
            <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
              </div>
              </form>
          </div>
			<input type="submit" class="btn btn-primary" value="Submit">
            
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>