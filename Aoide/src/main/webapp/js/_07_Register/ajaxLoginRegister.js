
// login request with js
$( "#loginForm" ).submit(function( event ) {
	// stop request from form
	event.preventDefault();
	// Get some values from elements on the page:
  	var $form = $( this ),
  	account = $("#account").val(), 
  	password = $("#password").val(),
  	url = $form.attr( "action" );

  	/*
  	console.log(account);
  	console.log(password);
  	console.log(url);
	*/

  	// Send the data using post
    var posting = $.post( url, { account: account, password: password }, function(data){
    	console.log("data: " + data);
    	if(data == "loginSuccess"){
    		alert("welcome aoide");
    		$("#id02").hide();
    		$("#loginBtn").remove();
    		$("#regstBtn").remove();
    		
    	}else{
    		alert("please sign again");
    	}


    } );// end $.post()

} ); // end submit()