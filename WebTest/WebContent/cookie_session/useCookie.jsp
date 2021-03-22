<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 사용하기</title>
</head>
<body>
	<h1>jsp 자바 코드로 쿠키 값 출력</h1>
	<hr>
	<%
		// 저장된 쿠키 값을 배열로 받아옴
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i = 0; i < cookies.length; i++){
				// 쿠키 변수(키)값이 id 인 값을 추출
				//.getName() : 쿠키 변수이름
				if(cookies[i].getName().equals("id")){
					out.print(cookies[i].getValue()+"<br>");
				}
				
				if(cookies[i].getName().equals("name")){
					out.print(cookies[i].getValue()+"<br>");
				}
				
				if(cookies[i].getName().equals("pwd")){
					out.print(cookies[i].getValue()+"<br>");
				}
			}
		}
	%>
	
	<hr>
	<h1>EL(표현 언어)로 쿠키값 출력</h1>
	<hr>
	아이디 : ${cookie.id.value} <br>
	비밀번호 : ${cookie.pwd.value} <br> 
	이름 : ${cookie.name.value} 
	<%-- 변수 값 출력 : ${변수 or 객체 멤버변수}, 수식의 결과 : ${수식} --%>
	<hr>
	<h3>
		<a href="deleteCookie.jsp">쿠키 삭제</a>
	</h3>
</body>
</html>