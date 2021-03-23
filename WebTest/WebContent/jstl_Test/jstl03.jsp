<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl core : choose</title>
</head>
<body>
	<c:set var="season" value="봄"></c:set>

	<c:choose>
		<c:when test="${season=='봄'}">
			<img src="../images/num_0.png" />
		</c:when>
		<c:when test="${season=='여름'}">
			<img src="../images/num_1.png" />
		</c:when>
		<c:when test="${season=='가을'}">
			<img src="../images/num_2.png" />
		</c:when>
		<c:when test="${season=='겨울'}">
			<img src="../images/num_3.png" />
		</c:when>
		<c:otherwise>기타 모든 경우</c:otherwise>
		
	</c:choose>
</body>
</html>