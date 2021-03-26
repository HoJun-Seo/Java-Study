<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 시작페이지</title>
</head>
<body>
<%
	// 설문 문항이 표시되고 응답할 수 있는 화면으로 이동
	String ctxPath = request.getContextPath();
	response.sendRedirect(ctxPath+"/survey_servlet/input.do");
%>
</body>
</html>