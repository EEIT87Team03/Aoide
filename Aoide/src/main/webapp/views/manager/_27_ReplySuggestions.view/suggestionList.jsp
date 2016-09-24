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
		            <div class="box" >
			            <!-- Add the bg color to the header using any of the bg-* classes -->
			            <div class="box-header with-border">
			              <h3 class="box-title">編輯回覆表單</h3>
			            </div>
			            <!-- /.box-header -->
			            <!-- /.box-body -->
				        <div class="box-body">
				          <!-- /.table -->
				          <table class="table">
				            <thead>
				              <tr>
				              <th>No</th>
				              <th>Date</th>
				              <th>Title</th>
				              <th></th>
				            </tr>
				            </thead>
				            <tbody>
				             <c:forEach var="aSuggestion" items="${unreplySuggestionsList}">
				                <tr>
				                  <td>${aSuggestion.suggestionId}</td>
				                  <td>${aSuggestion.suggestDate}</td>
				                  <td>${aSuggestion.title}</td>
				                  <td><a href="<c:url value='/GenerateReplyPageServlet?id=${aSuggestion.suggestionId}'/>" class="btn btn-info" role="button">Reply</a></td>
				                </tr>
				              </c:forEach>
				            </tbody>
				          </table>
				          <!-- /.table -->
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