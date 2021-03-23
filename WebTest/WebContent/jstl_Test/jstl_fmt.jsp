<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Date date = new Date();
	out.print("<h3>기본 날짜 형식 : " + date + "</h3>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포매팅 태그 라이브러리</title>
</head>
<body>
	<h1>포매팅(날짜) : fmt</h1> 
	<hr>
	<c:set var="date2" value="<%=new Date() %>"></c:set>
	<fmt:formatDate value="${date2 }"/> <br>
	<fmt:formatDate value="${date2 }" type="date"/> <br>
	<fmt:formatDate value="${date2 }" type="time"/> <br>
	<fmt:formatDate value="${date2 }" pattern="yyyy-MM-dd HH:mm:ss"/> <br>
	<fmt:formatDate value="${date2 }" dateStyle="full"/> <br>
	<fmt:formatDate value="${date2 }" dateStyle="long"/> <br>
	<h1>포매팅(숫자) : fmt</h1> <hr>
	<hr>
	<c:set var="num2" value="1234.5678"></c:set>
	<fmt:formatNumber value="${num2}" type="number" groupingUsed="true"></fmt:formatNumber> <br>
	<fmt:formatNumber value="${num2}" type="currency" currencySymbol="$" groupingUsed="true"></fmt:formatNumber> <br>
	<fmt:formatNumber value="${num2}" pattern="#,###,###.00" groupingUsed="true"></fmt:formatNumber> <br>
	<hr>
	한국 현재시간 :
	<fmt:formatDate value="${date2}" type="both" dateStyle="full" timeStyle="full"/> <hr>
	<fmt:timeZone value="America/New York">
		뉴욕 시간 :
		<fmt:formatDate value="${date2}" type="both" dateStyle="full" timeStyle="full"/>
	</fmt:timeZone>
</body>
</html>