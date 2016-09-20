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
<title>Share Song</title>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">


<link rel="canonical" href="http://www.example.com" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>share Song</title>



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
        Score
        <small>share Song</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="\Aoide\_14_Score.view\index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Song</a></li>
<!--         <li class="active">Fixed</li> -->
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
<script type="text/javascript" src="../static/js/jquery-3.1.0.min.js"></script>



<!--     FB function -->

	<script>
		window.___gcfg = {
			lang : 'en-US',
			parsetags : 'onload'
		};
	</script>
	
  <script >
  window.___gcfg = {
    lang: 'zh-CN',
    parsetags: 'onload'
  };
</script>
<!-- 將這個標記放在標頭中，或放在內文結尾標記前面。 -->
<script src="https://apis.google.com/js/platform.js" async defer>
  {lang: 'zh-TW'}
</script>
  
	<!-- Load Facebook SDK for JavaScript -->
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

<script type="text/javascript" src="https://apis.google.com/js/plusone.js">
  {lang: 'zh-TW'}
</script>

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title"></h3>
      

<title>Share</title>
<!-- <script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script> -->
<!-- <!-- Latest compiled and minified CSS --> 
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" -->
<!-- 	crossorigin="anonymous"> -->

<!-- <!-- Optional theme --> 
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" -->
<!-- 	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" -->
<!-- 	crossorigin="anonymous"> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<div class="container"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-lg-1"></div> -->
<!-- 			<div class="col-lg-10"> -->
<!-- 				<div class="panel panel-primary"> -->
<!-- 					<div class="panel-heading"> -->
<!-- 						<a href=""></a> -->
<!-- 					</div> -->
					<div class="panel-body">

						<table class="table">
							
							<tbody>

				

	
						

									<th>SongId</th>
									<th>SongName</th>
									
									<th>ShareLink</th>
									<th>FB Share</th>
									<th>Google+ Share</th>

						
						
					
							
								<c:forEach var="song" items="${getSong}">
									<tr>

										<td>${song.songId}</td>
                                        <td>${song.name}</td>

										<%--  			    				      <td><a href="<c:url value='/GenerateReplyPageServlet?id=${iscore.songId}'/>" class="btn btn-info" role="button">評分</a></td> --%>


										<%--                                          <td> <a href="getScore.jsp" value='/GenerateReplyPageServlet?id=${iscore.scoreValue}' class="btn btn-info" role="button">分享</a></td> --%>

										<td><form>
												<a href=<c:url value='/ShareServlet.member?id=${song.songId}'/> 
													value='/SelectOne'
													class="btn btn-info" role="button" 
													onClick=" var name = prompt('網址.' , 'You link here') ; " >分享</a>




											</form></td>
								
										<td><form>
												<a class="btn btn-info" role="button" id="otherid" src="http://tomcat.apache.org/images/tomcat.png"
													href="javascript: void(window.open('http://www.facebook.com/share.php?u='.concat(encodeURIComponent('http://tomcat.apache.org/'))));">FB分享</a>
											</form></td>
										<td><form>
										<g:plusone href='http://tomcat.apache.org/' src="http://tomcat.apache.org/images/tomcat.png"></g:plusone>
											</form></td>

									</tr>
								</c:forEach>
							</tbody>
									
						
						</table>

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





