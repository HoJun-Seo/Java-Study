<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
</head>
<body>
	<h2>구구단 출력</h2> <hr>
	<c:set var="dan" value="${param.dan}"></c:set>
	<table border="1" width="500" align="center">
		<tr align="center">
			<td colspan="2"><c:out value="${dan}" />단 출력</td>
		</tr>
		<c:forEach var="i" begin="1" end="9" step="1">
			<c:if test="${i%2 == 0}">
				<td align="center" bgcolor="#ccff66"></td>
			</c:if>
			<tr>
				
				<td align="center" width="200">${dan*i}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>