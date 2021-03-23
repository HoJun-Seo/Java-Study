<%@page import="webTest.member.dto.T_mem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	T_mem vo = new T_mem();
	vo.setId("k001");
	vo.setPwd("1234");
	vo.setName("홍길동");
	
	request.setAttribute("dto", vo);
%>
	<hr />
	<h3>memberDTO(VO)출력</h3>
	<jsp:forward page="memberDTO_result.jsp"></jsp:forward>
</body>
</html>