<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키값 삭제하기</title>
</head>
<body>
	<%
		// 쿠키값 삭제하는 메소드나 설정 값 없음 
		// 쿠키를 똑같은 이름으로 생성하여 유효시간(초 단위)을 0 으로 설정하는 방식으로 삭제
		
		Cookie cookie = new Cookie("id","111"); // 쿠키 중복 생성(덮어 쓰기)
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	%>
	<h3>id에 해당되는 쿠키 값이 삭제 되었습니다.</h3>
	<h3><a href="useCookie.jsp">쿠키 확인</a></h3>
</body>
</html>