<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 파일 생성</title>
</head>
<body>
<%
	// Cookie("쿠키변수(키)", "데이터(값)")
	Cookie cookie1 = new Cookie("id", "kim");
	Cookie cookie2 = new Cookie("pwd", "1234");
	// 인코딩 설정이 되어 있지않은 경우 URLEncoder 클래스를 활용할 것
	Cookie cookie3 = new Cookie("name", "홍길동");
	
	response.addCookie(cookie1);
	response.addCookie(cookie2);
	response.addCookie(cookie3);
%>
쿠키가 생성 되었습니다.
<a href="useCookie.jsp">쿠키 확인</a>
</body>
</html>