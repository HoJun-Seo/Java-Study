<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 조사</title>
</head>
<body>
	<h2>[설문 조사]</h2>
	<hr>
	<c:forEach var="dto" items="${list}">
		<h4>${dto.question }</h4>
		<form action="${pageContext.request.contextPath}/survey_servlet/insert.do" method="get">
			<input type="radio" name="num" value="1" checked="checked" />${dto.answer1} <br>
			<input type="radio" name="num" value="2" /> ${dto.answer2} <br>
			<input type="radio" name="num" value="3" /> ${dto.answer3} <br>
			<input type="radio" name="num" value="4" /> ${dto.answer4} <br>
			<input type="hidden" name="survey_idx" value="${dto.survey_idx}"> <br>
			<input type="submit" value="투표">
			
		</form>
	</c:forEach>
</body>
</html>