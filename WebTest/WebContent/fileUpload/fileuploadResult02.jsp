<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<%@ page import="java.io.File" %>

<%--
lib 폴더
	commons-fileupload-xxx.jar
	commons-io-xxxx.jar
 --%>    
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
File currentDirPath = new File(upload_path);
DiskFileItemFactory factory = new DiskFileItemFactory();
factory.setRepository(currentDirPath);

//사이즈 크기 제한 계산 (byte) : 1024byte => 1KB , 1024KB => 1MB, 1024MB => 1GB
factory.setSizeThreshold(1024*1024*10);
ServletFileUpload upload = new ServletFileUpload(factory);

	try {
		// request 객체에서 매개변수를 List 로 가져온다.
		List<FileItem> items = upload.parseRequest(request);
		
		// 파일 업로드 창에서 업로드된 항목들을 하나씩 가져온다.
		for(int i = 0; i < items.size(); i++){
			FileItem fileitem = (FileItem)items.get(i);
			if(fileitem.isFormField()){
				// 폼 필드이면 전송된 매개변수 값을 출력
				System.out.println(
						fileitem.getFieldName() + "=" +
						fileitem.getString("utf-8")
					);
			} else {
				// 폼 필드가 아니면 파일 업로드 기눙울 수행
				System.out.println("매개변수 이름 : " + fileitem.getFieldName());
				System.out.println("파일 이름 : " + fileitem.getName());
				System.out.println("파일 크기 : " + fileitem.getSize() + " byte");
				
				// 업로드한 파일 이름을 가져옴
				if(fileitem.getSize() > 0){
					int idx = fileitem.getName().lastIndexOf("/");
					
					if(idx == -1){
						idx = fileitem.getName().lastIndexOf("/");
					}
					String fileName = fileitem.getName().substring(idx+1);
					File uploadFile = new File(currentDirPath + "/" + fileName);
					fileitem.write(uploadFile);
				} // if
			} // if
		} // for
		} catch(Exception e){
			e.printStackTrace();
		}
%>
<h2>파일업로드 를 처리하는 페이지</h2>
<hr>

</body>
</html>