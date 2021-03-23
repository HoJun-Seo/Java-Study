<%@page import="webTest.member.dto.T_mem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DTO(VO) 출력 결과</title>
</head>
<body>
<%
	T_mem dto = (T_mem)request.getAttribute("dto");
%>
	<h3>member</h3>
	<hr>
	이름 : <%=dto.getName() %>
	아이디 : <%=dto.getId() %>
	비밀번호 : <%=dto.getPwd() %>
	<hr>
	<h3>EL 표현</h3>
	<hr>
	이름 : ${dto.name} <br>
	아아디: ${dto.id} <br>
	비밀번호 : ${dto.pwd} 
</body>
</html>