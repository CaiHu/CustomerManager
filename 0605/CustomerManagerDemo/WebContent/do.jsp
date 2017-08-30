<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册信息处理页面</title>
</head>
<body>
<%
	String txtName=request.getParameter("txtName");
	String selType=request.getParameter("selType");
	String CharacterEncoding=request.getCharacterEncoding();
	String serverName=request.getServerName();
	String remoteAddr=request.getRemoteAddr();
	String protocol=request.getProtocol();
	if("admin".equals(txtName)){
%>
	抱歉该账户<%=txtName %>已被占用，该<a href="index.jsp">返回</a>重新注册！
<% 		
	}else{
%>
	恭喜<%=txtName %>上仙注册成功，请牢记您的类型：<%=selType %>
<%
}	
%>
<%=CharacterEncoding %>
<%=serverName %>
<%=remoteAddr %>
<%=protocol %>
</body>
</html>