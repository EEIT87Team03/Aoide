
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
    		alert("welcome Aoide");
    		$("#id02").hide();
    		$("#loginBtn").remove();
    		$("#regstBtn").remove();
    		// display the logout button
    		$("#logoutBtn").show();
    	}else{
    		alert("please sign again");
    	}
    } );// end $.post()
} ); // end submit()

// register request with js
$( "#regstForm" ).submit(function( event ) {
	// stop request from form
	event.preventDefault();
	// Get some values from elements on the page:
  	var $form = $( this ),
  	name = $("#name2").val(), 
  	email = $("#email2").val(),
  	account = $("#account2").val(),
  	password = $("#password2").val(),
  	url = $form.attr( "action" );

  	/*
  	console.log(name);
  	console.log(email);
  	console.log(account);
  	console.log(password);
  	console.log(url);
    */
  	
  	// Send the data using post
    var posting = $.post( url, { name: name,email: email, account: account, password: password }, function(data){
    	console.log("data: " + data);
    	if(data == "regstSuccess"){
    		alert("Register Success");
    		$("#id01").hide();
    		$("#regstBtn").remove();
    	}else{
    		alert("please register again");
    	}
    } );// end $.post()
} ); // end submit()

// logout request with js
$( "#logoutBtn" ).click(function() {
	var url = "/Aoide/AjaxLogoutServlet";
	// Send the get request
    var posting = $.get( url, function(data){
    	console.log("data: " + data);
    	if(data == "logoutSuccess"){
    		alert("Logout Success");
    		$("#logoutBtn").remove();
    	}else{
    		alert("Please Logout again");
    	}
    } );// end $.post()

} ); // end click()	