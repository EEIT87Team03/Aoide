
// login request with js
$( "#loginForm" ).submit(function( event ) {
	// stop request from form
	event.preventDefault();
	// Get some values from elements on the page:
  	var $form = $( this ),
  	account = $("#account").val(), 
  	password = $("#password").val(),
  	url = $form.attr( "action" );

  	console.log(account);
  	console.log(password);
  	console.log(url);


  	// Send the data using post
    var posting = $.post( url, { account: account, password: password }, function(){

    	console.log("success");

    } );// end $.post()

} ); // end submit()