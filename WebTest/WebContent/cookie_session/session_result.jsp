<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 값 출력</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	String pwd = (String)session.getAttribute("pwd");
	String name = (String)session.getAttribute("name");
	int age = (Integer)session.getAttribute("age");
	double height = (Double)session.getAttribute("height");
%>
아이디 : <%= id %> <br>
비밀번호 : <%= pwd %> <br>
이름 : <%= name %> <br>
나이 : <%= age %> <br>
신장 : <%= height %>
<hr>
<h1>EL(표현 언어)사용하여 세션값 출력</h1>
아이디 : ${sessionScope.id } <br>
비밀번호 : ${sessionScope.pwd } <br>
이름 : ${sessionScope.name } <br>
신장 : ${sessionScope.height } <hr>
세션 id : <%=session.getId() %>
</body>
</html>