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
<title>Score Comment</title>
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
        Song Comment
        <small>For your Comment to this!</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="\Aoide\_14_Score.view\index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="\Aoide\_14_Score.view\getScore1.jsp">ScoreSong</a></li>
        <li class="active"></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="callout callout-info">
       &nbsp;&nbsp;<table >AVG : ${scoreVO.scoreValue}</table>
      </div>
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Comment</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
<!--             <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove"> -->
<!--               <i class="fa fa-times"></i></button> -->
          </div>
        </div>
        <div class="box-body" >
        <!-- Latest compiled and minified CSS -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->

<!-- Optional theme -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"> -->
</head>

<!-- 	<div class="container" style="text-align:left"> -->
<!-- 		<div class="row"> -->
<!--   			<div class="col-lg-1"></div> -->
<!--   			<div class="col-lg-10"> -->
<!--   				<div class="panel panel-primary"> -->
<!--   					<div class="panel-heading"><a href= ""></a></div> -->
<!--   					<div class="panel-body"> -->
    				
    					<table class="table">
    						<thead>
    							<tr>
    							    <th>MemberId</th>
    							    <th>Date</th>
    							    <th>ScoreValue</th>
									<th>CommentFile</th>
								</tr>
    						</thead>
    						<tbody>
 								<c:forEach var="commentValue" items="${fucks}">  
			    					<tr>
			    					    <td>${commentValue.memberId}</td>
			                            <td>${commentValue.date}</td>
			                            <td>${commentValue.scoreValue}</td>
			    						<td>${commentValue.comment}</td>


<%--                 <td> <a href="Aoide\repository\Aoide\src\main\webapp\template\index.jsp" value='/CommentServlet?id=${commentValue.memberId}' class="btn btn-info" role="button">  <span class="glyphicon glyphicon-share-alt"></span>回首頁</a></td>   --%>
                    
    
  </tr>  
 			    				        
 			   			 
		    					</c:forEach>   
    						</tbody>
    					</table>
    					<br>
 		    				<a class="btn btn-info" role="button" href="${header['referer']}">回前頁</a><br>
    				
    				
  					</div>
				</div>
  			</div>
  			<div class="col-lg-1"></div>
		</div>
	</div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
      
        </div>
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
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
</body>
</html>