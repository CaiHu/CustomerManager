<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成二维码</title>
</head>
<body>
	<center>
		<div>
		<form action="GenQRCodeServlet" method="post">
		客户姓名：<input type="text" id="customername" name="customername"/>
		<br />
		客户类型：
		<select name="selType">
		<option value="supply">
			供应
		</option>
		<option value="requirement">
			需求
		</option>
		<option>
			所有
		</option>
		</select>
		<br />
		建立时间：<input type="text" id="starttime" name="starttime" /><br />
		供求产品：<textarea rows="20" cols="20" name="product"></textarea><br />
		客户手机：<input type="text" id="mobile" name="mobile" /><br />
		客户电话：<input type="text" id="tel" name="tel" /><br />
		<input type="submit" values="添加" />
		<input type="reset" values="取消" />
		</form>
		<hr />
		二维码：
		<img src="img/<%=request.getAttribute("imgPath") %>" />
		<hr />
		二维码解析：
		客户姓名：<%=request.getParameter("customername") %><br />
		客户类型：<%=request.getParameter("selType") %><br />
		建立时间：<%=request.getParameter("starttime") %><br />
		供求产品：<%=request.getParameter("product") %><br />
		客户手机：<%=request.getParameter("mobile") %><br />
		客户电话：<%=request.getParameter("tel") %><br />
		</div>
	</center>
</body>
</html>