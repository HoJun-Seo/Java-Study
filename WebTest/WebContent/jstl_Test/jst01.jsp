<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl core</title>
</head>
<body>
	<h2>변수</h2>
	<hr>
	<c:set var="cnt" value="100" />
	<c:set var="name" value="홍길동" />
	cnt: ${cnt}, name: ${name}
	<c:remove var="cnt"/> remove cnt: ${cnt} <br>
	<hr>
	<c:if test="${name == '홍길동' }">
		당신의 이름은 ${name} 입니다.
	</c:if>
	<c:if test="${true}">
		항상 참 입니다.
	</c:if>
	<c:if test="${5>2}">
		5 > 2 : 참 입니다.
	</c:if>
	<c:if test="${cnt >= 100}">cnt값(${cnt})이 100 보다 같거나 크다.</c:if>
	<hr>
	<%
		int[] nums = {100,200,300,400,500};
		List<String> dataList = new ArrayList<>();
		dataList.add("hello");
		dataList.add("world");
		dataList.add("안녕");
		//forEach var = "개별변수" items = "집합변수"
	%>
	<c:set var="num" value="<%=nums %>"></c:set>
	<c:forEach var="i" items="${num }">
		i = ${i} <br>
	</c:forEach>
	<h3>List 구조</h3>
	<c:set var="list" value="<%=dataList %>"></c:set>
	<c:forEach var="data" items="${list}">
		${data} <br>
	</c:forEach>
	<hr>
	<c:set var="fruits" value="사과,파인애플,바나나,망고,귤"></c:set>
	<c:forTokens var="token" items="${fruits}" delims=",">
		${token} <br>
	</c:forTokens>
	<hr>
	<c:forEach var="i" begin="1" end="10" step="2" varStatus="loop">
		5*${i} = ${5*i} , 반복횟수 : ${loop.count} <br>
	</c:forEach>
</body>
</html>

<!-- 
	코어 : 접두어 - c
	변수지원, 흐름제어, 반복문 처리, URL 처리
	
	국제화 : 접두어 - fmt
	지역, 메시지 형식, 숫자 및 날짜 형식
	
	XML: 접두어 - x
	XML 코어, 흐름제어 XML 변환
	
	데이터베이스 : 접두어 - sql
	SQL 처리
	
	함수 : 접두어 - fn
	컬렉션 처리, 문자열 처리
 -->