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
  
  <!-- _05_DisplayDanmuku_library_css -->
  <c:import url="/views/global/_05_DisplayDanmuku/_05_DisplayDanmuku_library_css.html"/>
  <!-- _05_DisplayDanmuku_library_css -->
  
<title>Home</title>
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
        Fixed Layout
        <small>Blank example to the fixed layout</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Layout</a></li>
        <li class="active">Fixed</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="callout callout-info">
        <h4>Tip!</h4>

        <p>Add the fixed class to the body tag to get this layout. The fixed layout is your best option if your sidebar
          is bigger than your content because it prevents extra unwanted scrolling.</p>
      </div>
      
      
      <div id = "chatRoom">
		<input type = "text" id = "input" name = "input" size = "40">
		<input type = "button" id = "send" value = "Send">
	  </div>
      
      
      
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Title</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-body">
          Start creating your amazing application!
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          Footer
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

<!-- _05_DisplayDanmuku_library -->
<c:import url="/views/global/_05_DisplayDanmuku/_05_DisplayDanmuku_library.html"/>
<!-- _05_DisplayDanmuku_library -->

<script>
		var wsUri = "ws://localhost:8080/Aoide/danmu";
    	var clientSocket = new WebSocket( wsUri );
    	var username = "";
    	
    	
    	//當網頁啟動時所觸發的方法
    	clientSocket.onopen = 
    			function()
    			{
    				username = prompt( "Please enter your name", "Anonymous" );
    				//clientSocket.send( "[LOGIN] " + username );
    				memberId = ${member.memberId};
    				
    	 		};
    	 		
		//當伺服器收到訊息時的方法    	 		
    	clientSocket.onmessage = 
    			function ( event )
    			{
    				var message = event.data;
    				
    				 var item = {
    			            info: message, //彈幕文字
    			            href: '/Aoide/AccuseDanmukuServlet?id=' + memberId + '&text=' + message , //點選彈幕的連結網址
    			            close: true, //是否顯示關閉的按鈕
    			            speed: 10, //延遲(秒)預設為6
    			            color: '#000000', //顏色，預設白色
    			            old_ie_color: '#ffffff', //ie低版兼容色,不能与网页背景相同,默认黑色 
    			        }
    				
    				$('body').barrager(item); 
    				
        		};
        		
       	//瀏覽器關閉時候觸發的方法
        clientSocket.onclose = 
            		function()
            		{
        				displayText( "[Connection problem occur]" );
        				displayText( "[Ready State] " + clientSocket.readyState );
            			clientSocket.send( "[LOGOUT] " + username );
            			removeFromUserList( username );
            	 	};
       //伺服器出錯時觸發的方法
        clientSocket.onerror =
                	function( event )
                	{
        				displayText( "[Connection problem occurs]" );
        				displayText( clientSocket.readyState );
                		clientSocket.send( "[LOGOUT] " + username );
                		removeFromUserList( username );
                	};
        
        //註冊按鈕事件：將文字編輯框內的文字發送至伺服器
        document.getElementById( "send" ).onclick = function()
        											{
        												var text = document.getElementById( "input" ).value;
        												clientSocket.send( text );
        											};
        											      											
        function displayText( message )
        {
        	var text = document.createTextNode( message + "\n" );
        	var displayArea = document.getElementById( "output" );
        	displayArea.appendChild( text );
        }
        
        function setUserList( listString )
        {
        	var userList = document.createTextNode( listString );
			document.getElementById( "users" ).appendChild( userList );
        }
        
        function addToUserList( username )
        {
        	var user = document.createTextNode( username + "\n" );
			document.getElementById( "users" ).appendChild( user );
        }
        
        function removeFromUserList( username )
        {
        	var userList = document.getElementById( "users" ).value;
        	document.getElementById( "users" ).value= userList.replace( username + "\n", "" );
        }
        
	</script>
</body>
</html>