<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
	<title>_21_EnterDanmuku(輸入檢舉原因頁面.....)</title>
	<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
  			<div class="col-lg-1">.col-lg-1</div>
  			<div class="col-lg-10">
  				<div class="panel panel-primary">
  					<div class="panel-heading">你要檢舉的ID:${accused_id}</div>
  					<div class="panel-body">你要檢舉的內文:${accused_text}</div>
					<div class="panel-footer">
				    	<form action="<c:url value='/SaveAccuseDanmukuServlet'/>" method="post">
				            <textarea name="replyContent" id="replyContent" rows="10" cols="80">
				           			被檢舉人ID: ${accused_id}<br>
				           			被檢舉的彈幕內容:${accused_text}<br>
				                	檢舉原因:..........................................
				            </textarea>
				            <script>
				                // Replace the <textarea id="editor1"> with a CKEditor
				                // instance, using default configuration.
				                CKEDITOR.replace( 'replyContent' );
				            </script>
				            <input class="btn btn-primary" type="submit" value="Submit">
				        </form> 
					</div>				
				</div>
				
  			</div>
  			<div class="col-lg-1">.col-lg-1</div>
		</div>
	</div>

</body>
</html>