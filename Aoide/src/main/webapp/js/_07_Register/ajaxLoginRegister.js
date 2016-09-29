// check login request with js
$(function() {
  var url = "/Aoide/AjaxCheckMemberLoginServlet";

  $.get( url, function(data){
    console.log(data.isLogin)
    if ( data.isLogin == "true") {
        $("#loginBtn").hide();
        $("#regstBtn").hide();
        $("#logoutBtn").css('display','block');
        $("#memberLoginHead").css('visibility', 'visible');
    }
  }) // end $.get()
}) // end $.ready()


// login request with js
$( "#loginForm" ).submit(function( event ) {
	// stop request from form
	event.preventDefault();
	// Get some values from elements on the page:
	var $form = $( this ),
	account = $("#account").val(), 
	password = $("#password").val(),
	url = $form.attr( "action" );
	
	// clear the input value of account and password
	$("#account").val("");
	$("#password").val("");

  	/*
  	console.log(account);
  	console.log(password);
  	console.log(url);
	*/

  	// Send the data using post
    var posting = $.post( url, { account: account, password: password }, function(data){
    	console.log(data);

    	if(data.loginState == "loginSuccess"){
    		// alert("welcome Aoide");
    		$("#id02").hide();
    		$("#loginBtn").hide();
    		$("#regstBtn").hide();
    		// display the logout button
    		$("#logoutBtn").css('display','block');
    		$("#memberLoginHead").attr("src", data.pictureSource).css('visibility', 'visible');
    	}else{
    		// alert("Please sign again");
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
    		// alert("Register Success");
    		$("#id01").hide();
    		$("#regstBtn").remove();
    	}else{
    		// alert("Please register again");
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
    		// alert("Logout Success");
    		$("#logoutBtn").hide();
            $("#loginBtn").show();
            $("#regstBtn").show();
            $("#memberLoginHead").css('visibility', 'hidden');
    	}else{
    		// alert("Please Logout again");
    	}
    } );// end $.post()

} ); // end click()
