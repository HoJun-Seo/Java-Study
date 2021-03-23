<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 점수 입력 페이지</title>
</head>
<body>
	<h1>시험 점수 입력해 주세요</h1>
	<hr>
	<form action="jstl_ScoreResult.jsp">
		시험점수 : <input type="number" name="score" min="0" max="100">
		<input type="submit" value="학점 변환">
	</form>
</body>
</html>