<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Object type EL 표현 언어 사용</title>
</head>
<body>
<%
	// 리스트에 객체 저장
	ArrayList<String> items = new ArrayList<>();
	items.add("오렌지");
	items.add("사과");
	items.add("포도");
	items.add("레몬");
	
	// 출력할 값 request 객체에 저장
	request.setAttribute("items", items);
	// 출력방식1 : 
	RequestDispatcher rd = request.getRequestDispatcher("object_result.jsp");
	rd.forward(request, response);
	
%>
	<!-- 출력방식2 : JSP 액션 -->
	<jsp:forward page="object_result2.jsp"></jsp:forward>
</body>
</html>