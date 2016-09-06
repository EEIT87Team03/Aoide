<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  
<script type="text/javascript" src="static/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="dist/js/jquery.barrager.js"></script>
<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css" media="screen" />
<link rel="stylesheet" type="text/css" href="dist/css/barrager.css">
-->
<script type="text/javascript" src="danmmu/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="danmmu/js/jquery.barrager.js"></script>
<link rel="stylesheet" type="text/css" href="danmmu/css/bootstrap.min.css" media="screen" />
<link rel="stylesheet" type="text/css" href="danmmu/css/barrager.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>彈幕之間</title>
</head>
<body>

	<div id = "chatRoom">
		<input type = "text" id = "input" name = "input" size = "40">
		<input type = "button" id = "send" value = "Send">
	</div>
	
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
    			            href: '/Aoide/PlayHistoryServlet?id='+memberId, //點選彈幕的連結網址
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