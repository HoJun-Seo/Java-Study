<%-- <%@page import="common.UtilityCookie"%>
<%@page import="java.util.Date" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 활용하여 방문 횟수 처리하는 웹 페이지</title>
</head>
<body>
<%
	// 쿠키값에 있는 방문 횟수 읽기 : 모듈을 하나 생성(클래스 형태)
	String count = UtilityCookie.getCookie(request.getCookies(), "count");
	int intcount = 0; // 방문횟수 계산
	
	// 방문시간 설정
	Date date = new Date();
	long now_time = date.getTime(); // 현재 시간 추출
	
	// 쿠키 값에 있는 방문시간 읽어오기
	String visitTime = UtilityCookie.getCookie(request.getCookies(), "visit_time");
	long visit_time = 0;
	// 첫 방문이 아닐 경우
	if (visitTime != "0"){
		// 스트링을 숫자형으로 변환 : Long.parseLong(스트링)
		visit_time = Long.parseLong(visitTime);
	}
	
	// 첫 방문인 경우
	if (count.equals("0")){
		// 첫방문: 초기값을 설정, 방문횟수:1, 현재방문시간 설정
		response.addCookie(new Cookie("count","1"));
		// 숫자를 문자형으로 변환 : Long.toString(숫자)
		response.addCookie(new Cookie("visitTime",Long.toString(now_time) ));
	} else {// 첫방문이 아닌 경우
		
		// 방문기간(시기): 현재 시간 - 방문했던 시간
		long period = now_time-visit_time;
		
		intcount = Integer.parseInt(count);
		
		// 일정 시간 경과 후 방문횟수 업데이트
		if (period > 3*1000){
			intcount++;
			// 쿠키 없데이트(방문횟수, 방문시간)
			response.addCookie(new Cookie("count", Integer.toString(intcount) ));
			response.addCookie(new Cookie("visit_time", Long.toString(now_time)));
		}
		out.print("<h3>방문횟수: "+intcount+"</h2>");
		
		// 방문 숫자를 이미지 숫자로 출력
		out.print("123".charAt(0));
		out.print("123".charAt(1));
		out.print("123".charAt(2));
		
		String imagecounter = Integer.toString(intcount);
		for(int i = 0; i < imagecounter.length(); i++){
			String img = "<img src='../images/num_"+imagecounter.charAt(i) + ".png'>";
			out.print(img);
		}
	}
%>
</body>
</html>