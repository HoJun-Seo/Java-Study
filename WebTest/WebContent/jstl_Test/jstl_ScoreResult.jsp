<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 변환 결과</title>
</head>
<body>
	<h2>학점 결과</h2>
	<hr>
	<c:set var="score" value="${param.score}"></c:set>
	<c:choose>
		<c:when test="${score >= 0 && score <= 100}">
			<c:choose>
				<c:when test="${score >= 90 && score <= 100}">
					<h1><span style="color:red;">A학점</span>입니다.</h1>
				</c:when>
				<c:when test="${score >= 80 && score < 90}">
					<h1><span style="color:red;">B학점</span>입니다.</h1>
				</c:when>
				<c:when test="${score >= 70 && score < 80}">
					<h1><span style="color:red;">C학점</span>입니다.</h1>
				</c:when>
				<c:when test="${score >= 60 && score < 70}">
					<h1><span style="color:red;">D학점</span>입니다.</h1>
				</c:when>
				<c:otherwise>
					<h1><span style="color:red">F학점</span>입니다.</h1>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<h1>점수를 잘못 입력했습니다. 다시 입력하세요</h1>
			<a href="jstl_ScoreTest.jsp">점수 입력 창으로 이동</a>
		</c:otherwise>
		
	</c:choose>
</body>
</html>