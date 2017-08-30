<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,cn.lihao.customer.bean.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息管理系统</title>
</head>
<body>
<center>
<fieldset>
<legend>客户信息管理系统</legend>
<form action="CustomerServlet?method=queryAll" method="post">
<div>

客户姓名：<input type="text" name="txtName" />
产品供应：<input type="text" name="txtProduct" />
用户类型：<select name="selType">
<option value="all">所有</option>
<option value="req">需求</option>
<option value="sup">供应</option>
</select>
创建日期从<input type="text" name="txtFromDate" />
到<input type="text" name="txtToDate" />
<input type="submit" value="搜索" />
</div>
</form>
</fieldset>
<div>
<table border="1">
<thead><tr><th>客户编号</th><th>客户姓名</th><th>产品供求</th><th>客户类型</th><th>建立日期</th><th colspan="2">编辑</th></tr></thead>

<tbody>
<!-- <tr><td>1</td><td>司音</td><td>扇子</td><td>供应</td><td>2017-3-13</td><td>编辑</td><td><a onclick="return confirm('确认删除吗？');">删除</a></td></tr> -->
<%
	ArrayList<Customer> cList=(ArrayList<Customer>)request.getAttribute("cList");
	Customer c=new Customer();
	if(null==cList||cList.size()<=0){%>
	<tr>无数据</tr>
	<%}else{
		for(int i=0;i<cList.size();i++){
			c=(Customer)cList.get(i);
			
			%>
			<tr>
			<td><%=c.getCustomer_ID() %></td>
			<td><%=c.getCustomer_Name() %></td>
			<td><%=c.getCustomer_Info() %></td>
			<td><%=c.getCustomer_Type() %></td>
			<td><%=c.getCustomer_Date() %></td>
		
			<td><a href="CustomerServlet?method=modify&id=<%=c.getCustomer_ID()%>">编辑</a></td>
			<td><a href="CustomerServlet?method=delete&id=<%=c.getCustomer_ID()%>" onClick="return Confirm('确认删除吗？')">删除</a></td>
			</tr>
		<% }
	}
		%>
		
		
		
	

</tbody>

<tfoot></tfoot>

</table>
</div>
</center>
</body>
</html>