/**
 * for memberInfo.jsp
 */
	var xhr = null;
	var imageType = /image.*/;
	var selectedFileButton = document.getElementById( "selectedFile" );
	var uploadFileButton = document.getElementById( "upload" );
	var previewImage = document.getElementById( "preview" );
	var currentImage = document.getElementById( "current" );
	var displayProgressSpan = document.getElementById("progress");
	
	selectedFileButton.onchange = 
					function()
					{
						var selectedFile = this.files[0];
						if ( selectedFile.type.match( imageType ) ) 
						{
							uploadFileButton.disabled = false;
							var reader = new FileReader();
							reader.onload = function( event )
											{
												previewImage.src = reader.result;
												//document.getElementById( "preview" ).src = event.target.result;
												previewImage.style.display = "block";
												currentImage.style.display = "none";
												displayProgressSpan.innerHTML = "";
											};
							reader.readAsDataURL( selectedFile );
						}
						else
						{
							uploadFileButton.disabled = true;
							alert( "Wrong File Type!!" );
						}
						
					};
	uploadFileButton.onclick =	
					function()
					{
						var selectedFile = selectedFileButton.files[0];
						
						if ( selectedFile != null )
						{
							var formData = new FormData();
				            formData.append( "file", selectedFile );
	
							xhr = new XMLHttpRequest();
							xhr.upload.addEventListener( "progress", onProgressHandler, false );
							xhr.onload = function()
										 { 
											if ( ( this.status == 200 ) && ( xhr.responseText == "Success" ) )
											{
												//var img = document.createElement( "img" );
												//img.src = window.URL.createObjectURL( this.response );
												//img.onload = function(){ window.URL.revokeObjectURL( img.src ) }
												//img.style.height = img.style.width = "300px";
												//document.body.appendChild( img );
												displayProgressSpan.innerHTML = "Upload Success";
											}
											else
											{
												displayProgressSpan.innerHTML = "Upload Fail";
											}
										 };
						    xhr.open( "POST", "/Aoide/UploadImage" );
							xhr.send( formData );
						}
						else
						{
							alert( "No file to upload!!" );
						}
					};
					
	function onProgressHandler( event ) 
	{
		// Note: doesn't work with async=false.
		if ( event.lengthComputable )
	    {
			var progress = Math.round( event.loaded / event.total * 100 );
			displayProgressSpan.innerHTML = progress + "%";
	    }
	}