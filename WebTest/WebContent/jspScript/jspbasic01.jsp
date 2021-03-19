<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "홍길동";
	public String getName(){
		return name;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp 변수 내용 : <%=name %></h1>
	<h1>계산식 : <%= (100+20)/3 %></h1>
	<hr>
	<a href="jspbasic02.jsp?name=<%= name%>">이름을 전송합니다.</a>
</body>
</html>

<!-- 
선언문 : jsp 에서 변수나 메소드 선언
스크립트 : jsp 에서 자바 코드를 작성
표현식 : 변수의 값, 계산식 결과 값
쿼리 스트링 : url?변수1=값&변수2=값...
 -->