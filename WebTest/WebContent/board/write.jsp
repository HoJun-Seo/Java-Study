<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/board_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
<link rel="stylesheet" href="css/style.css"> 
</head>
<body>
	<h2>게시물 작성</h2>
	<hr>
	<form action="" name="form1" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td> <input type="text" name="writer" id="writer" /> </td>
			</tr>
			<tr>
				<td>제목</td>
				<td> <input type="text" name="subject" id="subject" /> </td>
			</tr>
			<tr>
				<td>본문</td>
				<td> <textarea name="content" id="content" cols="60" rows="5"></textarea> </td>
			</tr>
			<tr>
				<td>첨부 파일</td>
				<td> <input type="file" name="file1" /> </td>
			</tr>
			<tr>
				<td>비밀 번호</td>
				<td> <input type="password" name="passwd" id="passwd" /> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="btnSave" value="확인" />
					<input type="button" id="btnList" value="목록" />
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(function () {
			$('#btnSave').click(function () {
				console.log('확인 버튼');
				
				// 항목에 대한 값의 유효성 검사
				var writer = $('#writer').val();
				var subject = $('subject').val();
				var content = $('content').val();
				var passwd = $('passwd').val();
				
				if(writer == ""){
					alert('이름을 입력하세요');
					$('#writer').focus();
					return;
				}
				if(subject == ""){
					alert('제목을 입력하세요');
					$('#subject').focus();
					return;
				}
				if(content == ""){
					alert('내용을 입력하세요');
					$('#content').focus();
					return;
				}
				if(passwd == ""){
					alert('비밀번호 를 입력하세요');
					$('#passwd').focus();
					
					// 정규식 표현으로 비밀번호 규칙 체크(구글링으로 긁어오자.)
					return;
				}
				
				// 서블릿에 요청(db 입력처리)
				document.form1.action="${path}/board_servlet/insert.do";
				document.form1.submit();
			});
			$('#btnList').click(function () {
				console.log('목록 버튼');
				
				location.href="${path}/board_servlet/list.do";
			})
		})
	</script>
</body>
</html>