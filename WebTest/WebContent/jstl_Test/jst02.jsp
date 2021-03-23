<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>
<c:url var="url1" value="/jstl_uriTest/member1.jsp">
	<c:param name="id" value="hong" />
	<c:param name="pwd" value="123" />
	<c:param name="name" value="홍길동" />
</c:url>
<c:redirect url="/jstl_uriTest/member1.jsp">
	<c:param name="id" value="${'dong'}" />
	<c:param name="pwd" value="${'111'}" />
	<c:param name="name" value="${'동순이'}" />
</c:redirect>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl core : url, redirect, out</title>
</head>
<body>
	contextPath: ${ctxPath}
	<hr>
	<a href="${url1}">회원 정보출력</a>
	<a href="${url2}">회원 정보출력</a>
</body>
</html>