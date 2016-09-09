<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script src="//cdn.ckeditor.com/4.5.10/basic/ckeditor.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Edit Member Info</title>
</head>
<body>
	<div>
	<form action="<c:url value='/EditInfoServlet'/>" method="post" >
		<table>
			<tr>
				<td><label for = "account">Account : </label></td>
				<td><span>${member.account}</span></td>
			</tr>
			<tr>
				<td><label for = "name">Name : </label></td>
				<td><input name="name" type="text" value="${member.name }">${errorMsg.nameError }</td>
			</tr>
			<tr>
				<td><label for = "email">Email : </label></td>
				<td><input  name="email" type="text" value="${member.email }">${errorMsg.emailError }</td>
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
						<input type = "file" accept="image/*" id = "selectedFile" name = "selectedFile"><span id="status"></span>
						<input type = "button" id = "upload" value = "Upload"><span id="progress"></span>
					</div>
				</td>
			</tr>
		</table>
		<p>Introduction: ${errorMsg.introductionError }</p>
		<textarea name="introduction"  id="introduction" rows="10" cols="80" >
           	${member.introductionFilePath}
        </textarea>
           <script>
               // Replace the <textarea id="editor1"> with a CKEditor
               // instance, using default configuration.
               CKEDITOR.replace( 'introduction' );
			</script>
		<input type="submit" value="Submit">
	</form>
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
											document.getElementById( "status" ).innerHTML = this.files[ 0 ].name;
											document.getElementById( "progress" ).innerHTML = "";
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