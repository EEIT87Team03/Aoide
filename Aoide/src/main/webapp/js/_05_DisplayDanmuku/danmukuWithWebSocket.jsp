<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		var wsUri = "ws://localhost:8080/Aoide/danmu";
    	var clientSocket = new WebSocket( wsUri );
    	var username = "";
    	
    	
    	//當網頁啟動時所觸發的方法
    	clientSocket.onopen = 
    			function()
    			{
    				//username = prompt( "Please enter your name", "Anonymous" );
    				//clientSocket.send( "[LOGIN] " + username );
    				<c:if test="${! empty member }">
    				memberId = ${member.memberId};
    				</c:if>
    				<c:if test="${empty member }">
    				memberId = 5;
    				</c:if>
    				
    				
    	 		};
    	 		
    	 			
		//當伺服器收到訊息時的方法    	 		
    	clientSocket.onmessage = 
    			function ( event )
    			{
    				//var message = event.data.split("&",2)[1];
    				var item = JSON.parse(event.data);
    				 /*var item = {
    			            info: message, //彈幕文字
    			            href: '/Aoide/AccuseDanmukuServlet?id=' + memberId + '&text=' + event.data.split("&",2)[0] , //點選彈幕的連結網址
    			            close: true, //是否顯示關閉的按鈕
    			            speed: 2, //延遲(秒)預設為6
    			            color: '#000000', //顏色，預設白色
    			            old_ie_color: '#ffffff', //ie低版兼容色,不能与网页背景相同,默认黑色 
    			        }*/
    				
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
        /*document.getElementById( "send" ).onclick = function()
        											{
        											var message = document.getElementById( "input" ).value;
        											var item = {
							    			            info: message, //彈幕文字
							    			            href: '/Aoide/AccuseDanmukuServlet?id=' + memberId + '&text=' + message , //點選彈幕的連結網址
							    			            close: true, //是否顯示關閉的按鈕
							    			            speed: 2, //延遲(秒)預設為6
							    			            color: '#000000', //顏色，預設白色
							    			            old_ie_color: '#ffffff', //ie低版兼容色,不能与网页背景相同,默认黑色 
							    			            'memberID' : memberId
							    			        }
							    			        var abc = JSON.stringify(item);
        												//var text = document.getElementById( "input" ).value;
        												//clientSocket.send( memberId + "&" + text);
        												console.log(abc);
        												clientSocket.send(abc);
        											};*/
        											
        											
        											
                               function sendDanmu( value ){
        											var message = value;
        											var item = {
							    			            info: message, //彈幕文字
							    			            href: '/Aoide/AccuseDanmukuServlet?id=' + memberId + '&text=' + message , //點選彈幕的連結網址
							    		 	            close: true, //是否顯示關閉的按鈕
							    			            speed: 2, //延遲(秒)預設為6
							    			            color: '#FFFFFF', //顏色，預設白色
							    			            old_ie_color: '#ffffff', //ie低版兼容色,不能与网页背景相同,默认黑色 
							    			            'memberID' : memberId
							    			        }
							    			        var abc = JSON.stringify(item);
        												//var text = document.getElementById( "input" ).value;
        												//clientSocket.send( memberId + "&" + text);
        												console.log(abc);
        												clientSocket.send(abc);
        											};
        											
        											
        											
       document.getElementById("input").addEventListener("keypress", function(event)
       																 {
       																 	 var message = document.getElementById( "input" ).value;
																		 if(event.keyCode == 13){
																				//alert("ENTER!");
																				sendDanmu( message );
																				document.getElementById("input").value="";
																		  }
	     															  }
	   													);
        											      											
       document.getElementById( "fire" ).addEventListener( "click", 
       														function()
       														{
       															sendDanmu( CKEDITOR.instances.missile.getData() );
       														}
       													 ); 
        