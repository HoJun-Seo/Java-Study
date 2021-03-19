<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체</title>
</head>
<body>

</body>
</html>

<!-- 
jsp 내장 객체
request : HttpServletRequest : 클라이언트의 요청 정보를 저장
response : ServletResponse : 응답 정보를 저장
out : javax.servlet.jsp.JspWriter : jsp 페이지에서 결과를 출력
session : javax.servlet.http.HttpSession : 세션정보(브라우저당 1개)
application : javax.servlet.ServletContext : 컨텍스트 정보를 저장
pageContext : javax.servlet.jsp.PageContext : jsp 페이지에 대한 정보
page : java.lang.Object : jsp 페이지의 서블릿 인스턴스를 저장
config : javax.servlet.Servletconfig : jsp 페이지에 대한 설정 정보
exception : java.lang.Exception : 예외 발생시 예외를 처리

 -->