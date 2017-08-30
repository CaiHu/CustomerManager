<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script type="text/javascript">
	function refreshCode(){
		var codeImg=document.getElementById("codeImg");
		var d=new Date();
		codeImg.src="http://localhost:8080/CustomerManagerDemo/AuthCode?s="+d;
	}
</script>

</head>
<body>

<center>
<form action="LoginServlet" method="post">
	<table>
	<tr><td>账号：</td><td><input type="text" id="account" name="account"></td><td></td></tr>
	<tr><td>密码：</td><td><input type="password" id="pwd" name="pwd"></td><td></td></tr>
	<tr><td>确认密码：</td><td><input type="password" id="repwd" name="repwd"></td><td></td></tr>
	<tr><td>验证码：</td><td><input type="text" id="checkCode" name="checkCode"></td><td><img id="codeImg" src="http://localhost:8080/CustomerManagerDemo/AuthCode" /></td></tr>
	<tr><td colspan="3"><input type="submit" value="注册" /></td></tr>
	</table>

</form>
</center>

</body>
</html>