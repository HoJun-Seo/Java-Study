<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = request.getParameter("name");
	int score = Integer.parseInt(request.getParameter("score"));
	
	String result;
	if(score >= 90){ 
		result = "A"; 
	} else if(score >= 80){ 
		result = "B";
	} else if(score >= 70){ 
		result = "C";
	} else if(score >= 60){ 
		result = "D";
	} else { 
		result = "F";
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 결과</title>
</head>
<body>
	<h1>이름 : <%=name %></h1>
	<h1>시험 점수 : <%= score %></h1>
	<hr>
	학점 : <%=result %> 학점 입니다.
</body>
</html>