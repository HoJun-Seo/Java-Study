<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 테스트</title>
</head>
<body>
<h3>파일 업로드(FileUpload:cos.jar)</h3>
<hr>
<form action="fileuploadResult01.jsp" method="post"  enctype="multipart/form-data">
	이름: <input type="text"  name="name"/><br>
	제목: <input type="text"  name="subject"/><br>
	파일1:<input type="file"   name="file1" /><br>
	파일2:<input type="file"   name="file2"/><br>
	
	<input type="submit" value="업로드" />
</form>
</body>
</html>