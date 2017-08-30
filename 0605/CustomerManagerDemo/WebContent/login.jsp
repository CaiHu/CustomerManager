<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<script type="text/javascript" src="js/md5.js"></script>

<script type="text/javascript">
	function refreshCode(){
		var codeImg=document.getElementById("codeImg");
		var d=new Date();
		codeImg.src="http://localhost:8080/CustomerManagerDemo/AuthImage?s="+d;
	}
	
	function submitForm(){
		if(form.account.value==''){
			alert("请输入用户账号！");
			form.userId.focus();
			return false;
		}
		if(form.pwd.value==''){			
			alert("请输入登录密码！");
			form.password.focus();
			return false;
		}
		document.myForm.submit();
	}
	
	function jiami(){
		var password=document.getElementById("pwd");
		alert(password.value);
		document.getElementById("pwd").value=hex_md5(password.value);
		
	}
</script>

</head>
<body>

<center>
<form action="LoginServlet" method="post" id="myForm">
	<table>
	<tr><td>账号：</td><td><input type="text" id="account" name="account"></td><td></td></tr>
	<tr><td>密码：</td><td><input type="password" id="pwd" name="pwd" onBlur="jiami();"></td><td></td></tr>
	<tr><td>验证码：</td><td><input type="text" id="checkCode" name="checkCode" /></td><td><img id="codeImg" src="http://localhost:8080/CustomerManagerDemo/AuthImage" onclick="refreshCode()" /></td></tr>
	<tr><td colspan="3"><input type="submit" value="登录" onclick="return submitForm(this.form);"/></td></tr>
	<tr><td><%=request.getAttribute("info") %></td></tr>
	</table>

</form>
</center>

</body>
</html>