<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<td><label for = "account">Account : </label></td>
				<td><span>${member.account}</span></td>
			</tr>
			<tr>
				<td><label for = "name">Name : </label></td>
				<td><span>${member.name}</span></td>
			</tr>
			<tr>
				<td><label for = "email">Email : </label></td>
				<td><span>${member.email}</span></td>
			</tr>
			<tr>
				<td><label for = "lastLogin">Last Login : </label></td>
				<td><span>${member.lastLoginDate}</span></td>
			</tr>
			<tr>
				<td><label for = "picture">Picture : </label></td>
				<td>
					<div>
						<img id = "current" src="data:image/*;base64,${member.picture}" width="200" height="200">
						<img src="#" id = "preview"  alt = "preview image" width = "200" height = "200" style = "display : none"/>
					</div>	
					<div>
						<input type = "file" id = "selectedFile" name = "selectedFile"><span id="status">
						<input type = "button" id = "upload" value = "Upload"></span><span id="progress"></span>
					</div>
				</td>
			</tr>
		</table>
	</div>
<script>
	var xhr = null;
	document.getElementById( "selectedFile" ).onchange = 
					function()
					{
						var selectedFile = this.files[0];
						var reader = new FileReader();	
						reader.onload = function( event )
										{
											document.getElementById( "preview" ).src = reader.result;
											//document.getElementById( "preview" ).src = event.target.result;
											document.getElementById( "preview" ).style.display = "block";
											document.getElementById( "current" ).style.display = "none";
											document.getElementById("status").innerHTML = this.files[ 0 ].name;
										};
						reader.readAsDataURL( selectedFile );
					};
	document.getElementById( "upload" ).onclick =	
					function()
					{
						var selectedFile = document.getElementById( "selectedFile" ).files[0];
						var formData = new FormData();
			            formData.append( "file", selectedFile );

						xhr = new XMLHttpRequest();
						xhr.upload.addEventListener( "progress", onProgressHandler, false );
						xhr.onload = function()
									 { 
										if ( this.status == 200 )
										{
// 											var img = document.createElement( "img" );
// 											img.src = window.URL.createObjectURL( this.response );
// 											img.onload = function(){ window.URL.revokeObjectURL( img.src ) }
// 											img.style.height = img.style.width = "300px";
// 											document.body.appendChild( img );
											alert( xhr.responseText );
										 }
											
									 };
					    xhr.open( "POST", "UploadImage" );
						//xhr.responseType = "blob";
						xhr.send( formData );
				
					};
	function onProgressHandler( event ) 
	{
		// Note: doesn't work with async=false.
		if ( event.lengthComputable )
	    {
			var progress = Math.round( event.loaded / event.total * 100 );
			document.getElementById("progress").innerHTML = " Progress " + progress + "%";
	    }
	}
</script>
</body>
</html>