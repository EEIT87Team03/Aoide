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
			
			<section class="content">
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