<%@ page language="java" contentType="text/html; charset=UTF-8" import="cn.lihao.customer.bean.Customer"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息修改</title>
</head>
<body>
<center>
<form action="CustomerServlet?method=update" method="post">
<%
	Customer c=(Customer)request.getAttribute("cus");
%>
<input type="hidden" name="id" value="<%=c.getCustomer_ID() %>" />
客户姓名：<input type="text" name="txtName" value="<%=c.getCustomer_Name() %>"/><br>

<%
	if("sup".equals(c.getCustomer_Type())){%>
		客户类型：
	<select name="selType">
	<option value="all">所有</option>
	<option value="req" selected="selected">需求</option>
	<option value="sup">供应</option>
	</select><br>
		
<% 	}else if("req".equals(c.getCustomer_Type()))  {%>
	客户类别：
	<select name="selType">
	<option value="all">所有</option>
	<option value="req" selected="selected">需求</option>
	<option value="sup">供应</option>
	</select><br>
	<%} %>

建立时间：<input type="text" name="txtDateTime" value="<%=c.getCustomer_Date()%>"><br>
供求产品：<textarea name="txtProduct" rows="8" cols="20"><%=c.getCustomer_Info()%></textarea><br>
手机号码：<input type="text" name="txtMobile" value="<%=c.getCustomer_Mobile()%>"><br>
电话号码：<input type="text" name="txtTel" value="<%=c.getCustomer_Tel()%>"><br>
<input type="submit" value="修改" />
<input type="reset" value="取消" />
</form>
</center>
</body>
</html>		