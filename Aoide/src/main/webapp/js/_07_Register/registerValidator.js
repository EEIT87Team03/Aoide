window.onload = function ()/*regist function*/
{
    document.getElementById("name").onblur = checkName;
    document.getElementById("email").onblur = checkEmail;
    document.getElementById("account").onblur = checkAccount;
    document.getElementById("password").onblur = checkPassword;
    document.getElementById("rePassword").onblur = checkRePassword;
}

function checkName()
{
    var inputName = document.getElementById("name").value;

    if (inputName == "")
    {
        document.getElementById("nameError").innerHTML = "請輸入使用者名稱";
    } 
    else
    {
        document.getElementById("nameError").innerHTML = "";
    }
}

function checkEmail()
{
    var inputEmail = document.getElementById("email").value;

    if (!inputEmail.match("^(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3})$"))
    {
        document.getElementById("emailError").innerHTML = "請輸入有效e-mail";
    }
    else
    {
        document.getElementById("emailError").innerHTML = "";
    }
}

function checkAccount()
{
    var inputAccount = document.getElementById("account").value;
    
    if (inputAccount.length < 5)
    {
        document.getElementById("accountError").innerHTML = "請輸入有效帳號名稱";
    }else if(inputAccount.length >= 5)
    {
    	$.post( "/Aoide/CheckAccountServlet", { account: inputAccount }, function( data ) {
    	  console.log( data );
    	  if(data == 'used')
      	  {
      		  console.log( 'in used block' );
      		  document.getElementById("accountError").innerHTML = "帳號已被使用";
      	  }
    	  else
    	  {
    	      document.getElementById("accountError").innerHTML = "";
    	  }
    	}, "text");
    }

}

function checkPassword()
{
    var inputPassword = document.getElementById("password").value;

    if (!inputPassword.match("^([a-zA-Z0-9]{6,18}?)$"))
    {
        document.getElementById("passwordError").innerHTML = "請輸入有效密碼";
    }
    else
    {
        document.getElementById("passwordError").innerHTML = "";
    }
}

function checkRePassword()
{
    var inputRePassword = document.getElementById("rePassword").value;

    if (inputRePassword != document.getElementById("password").value)
    {
        document.getElementById("rePasswordError").innerHTML = "密碼不符";
    }
    else
    {
        document.getElementById("rePasswordError").innerHTML = "";
    }
}




