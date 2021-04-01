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
String name = "";
String subject ="";
String file_name1 ="";
String file_name2="";
long fileSize1 = 0;
long fileSize2 = 0;

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
		
				// 업로된 정보을 출력하기 위한 내용
				name =  multi.getParameter("name");
				subject = multi.getParameter("subject");
				System.out.println(name+","+multi.getParameter("name"));
				
				
				Enumeration files = multi.getFileNames();
				
				// 방법1.
				// 매개변수에 있는 객체이름을 읽어오기
				String fName1 = (String) files.nextElement();
				String fName2 = (String) files.nextElement();
				// 객체속성에서 매개변수 값 읽어오기
				file_name1 = multi.getFilesystemName(fName1);
				file_name2 = multi.getFilesystemName(fName2);
				
				// String file을 FileSystem파일시스템객체로  전환
				File f1 = multi.getFile(fName1);
				File f2 = multi.getFile(fName2);
				// 파일시스템에 대해서 파일크기 추출
				fileSize1 = (long)f1.length();
				fileSize2 = (long)f2.length();
				
				/* 방법2.
				while(files.hasMoreElements()){
					String fName1 = (String) files.nextElement();
					File f1 = multi.getFile(fName1);
					fileSize1 = (long)f1.length();
				}
				*/
				
				/* 방법3.
				file_name1 = multi.getFilesystemName("file1");
				File f1 = multi.getFile(file_name1);
				fileSize1 = (long)f1.length();
				
				file_name2 = multi.getFilesystemName("file2");
				File f2 = multi.getFile(file_name2);
				fileSize2 = (long)f2.length();
				*/
				
		} catch(Exception e){
			e.printStackTrace();
		}
%>
<h2>파일업로드을 처리하는 페이지</h2>
<hr>
이름 :<%=name %><br> 
제목 : <%=subject %><br>
파일1 name : <%=file_name1 %><br>
파일1 size : <%=fileSize1%><br>
파일2 name :<%=file_name2 %><br>
파일2 size : <%=fileSize2 %><br>
</body>
</html>