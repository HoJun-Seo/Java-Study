<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='../include/board_header.jsp' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 내용 보기</title>
<link rel="stylesheet" href="../board/css/style.css">
<style type="text/css">
	#reply_table{
		width: 500px;
		border: 0px solid gray;
		border-collapse: collapse;
	}
	td, td {
		border: 1px solid gray;
	}
</style>
</head>
<body>
	<h2>게시물 내용 보기</h2>
	<form action="" name="form1" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td > <input type="text" name="writer" id="writer" /> </td>
			</tr>
			<tr>
				<td>제목</td>
				<td> <input type="text" name="subject" id="subject" value="Re:${dto.subject }" /></td>
			</tr>
			<tr>
				<td>본문</td>
				<td>
					<textarea rows="5" cols="60"
						name="content" id="content">${dto.content }</textarea>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td> <input type="password" name="passwd" id="passwd" /> </td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="button" id="btnSave" value="확인">
				<input type="button" id="btnList" value="목록">
				<input type="hidden" name="num" value="${dto.num }">
				</td>
			</tr>
		</table>
	</form>
	<!-- jQuery 작성 -->
	<script type="text/javascript">
	// html 태그(DOM) 메모리에 정상적으로 로딩되면 수행
	$(function () {
		$('#btnSave').click(function () {
			console.log('확인 버튼');
			
			//항목에 대한 값의 유효성 검사
			var writer = $('writer').val();
			var subject = $('subject').val();
			var content = $('content').val();
			var passwd = $('passwd').val();
			
			if(writer == ""){
				alert('이름을 입력하세요');
				$('writer').focus();
				return;
			}
			if(subject === ""){
				alert('제목을 입력하세요');
				$('subject')focus();
				return;
			}
			if(content === ""){
				alert('내용을 입력하세요');
				$('content')focus();
				return;
			}
			if(passwd === ""){
				alert('비밀번호를 입력하세요');
				$('passwd')focus();
				return;
			}
			
			document.form1.action="${path}/board_servlet/insertReply.do";
			document.form1.submit();
		});
		$('btnList').click(function () {
			console.log('list');
			
			location.href="${path}/board_servlet/list.do";
		});
	});
	
	</script>
</body>
</html>