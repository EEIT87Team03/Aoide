<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  
  <!-- head_library -->
  <c:import url="/template/htmlBlocks/head_library.html"/>
  <!-- head_library -->
<title>UpdateFavorite(顯示所有最愛歌曲)</title>


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
        Updatefavorite
        <small>favorite</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="\Aoide\_14_Score.view\index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Song</a></li>
<!--         <li class="active">Fixed</li> -->
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">


      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title"></h3>
      

<title>評分評論</title>

					<div class="panel-body">

								<table class="table">
    						<thead>
    							<tr>
									<th>會員ID</th>
									<th>歌曲</th>
									<th>singer</th>
									
								</tr>
    						</thead>
    						<tbody>
								<c:forEach var = "favoriteVOList" items="${favoriteVOList}" varStatus="loop">
									<tr>
										<td>${favoriteVOList.memberId}</td>
										<td>${songIdList[loop.count-1]}</td>
										<td>${singers[loop.count-1]}</td>
										
									</tr>
								</c:forEach>
    						</tbody>
    					</table>

							


        
        <br>
                          
									
									
									
		

						<br>
					</div>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        
      
        <!-- /.box-body -->

        <!-- /.box-footer-->
    
      <!-- /.box -->


    <!-- /.content -->

  <!-- /.content-wrapper -->

  <!-- footer -->
  <c:import url="/template/htmlBlocks/footer.html"/>
  <!-- footer -->

  <!-- Control Sidebar -->
  <c:import url="/template/htmlBlocks/control_sidebar.html"/>
  <!-- Control Sidebar -->

<!-- ./wrapper -->

<!-- body_library -->
<c:import url="/template/htmlBlocks/body_library.html"/>
<!-- body_library -->
</body>
</html>





