<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	Integer dan = Integer.parseInt(request.getParameter("dan"));

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
</head>
<body>
	<table border="1" width="800">
		<tr>
			<td colspan="2" width="50%"><%=dan %>단</td>
		</tr>
		<% for(int i=1; i<10; i++){ %>
		<tr>
			<td align="center"><%=dan %>x<%=i %></td><td align="center"><%=dan*i %></td>
		</tr>
		<%} %>
	</table>
	<div id="head">
		<span></span>
		<span></span>
		<span></span>
	</div>
	
</body>
</html>