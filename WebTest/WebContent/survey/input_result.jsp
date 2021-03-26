<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 조사</title>
</head>
<body>
	<h3>설문에 응답해 주셔서 감사합니다.</h3>
	<hr>
	<a href="${pageContext.request.contextPath}/survey_servlet/input.do">설문 메인화면</a>
	<a href="${pageContext.request.contextPath}/survey_servlet/survey_result.do?survey_idx=1">투표결과 통계보기</a>
</body>
</html>