<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	session.setAttribute("address", "부산 광역시");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름은 <%=name %> 입니다.
	<a href="session2.jsp">두번째 페이지로 이동</a>
</body>
</html>