<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息添加</title>
<script>
	function clearTips(){
		var tips=document.getElementById("tips");
		tips.innerHTML="";
	}
	function submitForm(){
		var selType=document.getElementById("typinfo");
		if(selType.value=="all"){
			alert("请选择客户类型！");
		}else{
			document.form1.submit();
		}
	}
</script>
</head>
<body>
<center>
<form action="CustomerServlet?method=add" method="post" name="form1">
<a href="CustomerServlet?method=queryAll">查询所有客户信息</a><br />
客户姓名：<input type="text" name="txtName" onfocus="clearTips()"/><br>
客户类型：
<select name="selType" id="typinfo">
<option value="all">所有</option>
<option value="req">需求</option>
<option value="sup">供应</option>
</select><br>
建立时间：<input type="text" name="txtDateTime"><br>
供求产品：<textarea name="txtProduct" rows="8" cols="20"></textarea><br>
手机号码：<input type="text" name="txtMobile"><br>
电话号码：<input type="text" name="txtTel"><br>
<input type="submit" value="添加" />
<input type="reset" value="取消" />
<br>
<%
	String tips=(String)request.getAttribute("tips");
	if(null==tips){}else{
%>
<div id="tips"><%=tips %></div>
	<%} %>	
	

</form>
</center>
</body>
</html>