<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 작성</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function () {
		console.log('jQuery Ok....');
		
		// 전송 버튼 클릭시 항목별 유효성 검사
		$('#btnOK').click(function () {
			var name = $('#name');
			var email = $('#email');
			var passwd = $('#passwd');
			var content = $('#content');
			
			if(name.val() == ''){
				alert('이름을 입력해주세요');
				name.focus();
				return;
			}
			if(email.val() == ''){
				alert('이메일을 입력해주세요');
				email.focus();
				return;
			}
			if(passwd.val() == ''){
				alert('패스워드를 입력해주세요');
				passwd.focus();
				return;
			}
			if(content.val() == ''){
				alert('내용을 입력해주세요');
				content.focus();
				return;
			}
			
			// action 에서 설정된 url 로 값을 전송
			document.form1.submit();
			
		});
	});
</script>
</head>
<body>
	<h1>방멍록 작성</h1>
	<hr>
	<form action="${pageContext.request.contextPath }/guestbook_servlet/insert.do"
		name="form1" id="form1" method="post">
			<table>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" id="name" size="40">
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" id="email" size="40">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="passwd" id="passwd" size="40">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea rows="5" cols="55" name="content" id="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="btnOK" value="확인">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>