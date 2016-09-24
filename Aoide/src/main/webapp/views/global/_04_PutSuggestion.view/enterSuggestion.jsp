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
			    </section>
			    <!-- /.content -->
			  <!-- /.content-wrapper -->
            <!-- ========================================= -->
			</div>
			<div class="col-xs-6 col-md-3"></div>
		</div>
    </div>
    
<!-- body-library  -->
<c:import url="/TestHTML/body_library.html"/>
</body>
</html>