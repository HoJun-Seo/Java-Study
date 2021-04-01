<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 파일 업로드 처리하는 라이브러리 : cos.jar -->    
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.io.File" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 처리하는 부분</title>
</head>
<body>
<%
// 실제 업로드 처리 하는 로직

// 업로드 할 폴더 지정
String upload_path = "c:/upload_test";

// 사이즈 크기 제한 계산 (byte) : 1024byte => 1KB , 1024KB => 1MB, 1024MB => 1GB
int size = 1024*1024*10; // 10MB 용량을 계산

	try {
	
		// 실제 파일 업로드 처리하는 객체 : 객체 생성시 업로드 처리됨.
		// MultipartRequest 객체 = new 생성자(필요한 인자1,...);
		MultipartRequest multi = new MultipartRequest(
					// 기존의 request객체를 확장하여 업로드가 가능한 객체
					request,	
					// 파일 업로드할 폴더
					upload_path,
					// 파일 용량 제한(최대 용량)
					size,
					// 한글 인코딩
					"utf-8",
					// 파일 중복시 자동으로 숫자를 붙여  퍄일명 재정의
					new DefaultFileRenamePolicy()
				);
				
		} catch(Exception e){
			e.printStackTrace();
		}
%>

</body>
</html>