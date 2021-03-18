<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script type="text/javascript">
	function fn_sendMember(){
		console.log('click');
		
		var frmMember = document.frmMember;
		var pwd = frmMember.pwd.value;
		var name = frmMember.name.value;
		var email = frmMember.email.value;
		
		if(pwd.length == 0 || pwd == ""){
			alert("비밀번호는 필수 입니다.");
		} else if(name.length == 0 || name == ""){
			alert("이름은 필수 입니다.");
		} else if(email.length == 0 || email == ""){
			alert("이메일은 필수 입니다.");
		} else {
			frmMember.method = "post";
			frmMember.action = "/WebTest/webTest/T_memService";
			frmMember.submit();
		}
	}
</script>
</head>
<body>
	<h2>회원 정보 수정</h2>
	<form name="frmMember">
		<table>
			<th>회원 정보 수정</th>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="${member.id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" value="${member.pwd}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${member.name}"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${member.email}"></td>
			</tr>
		</table>
		<input type="button" value="수정하기" onClick="fn_sendMember()" />
		<input type="reset" value="다시 입력" />
		<input type="hidden" name="command" value="updateOKMember" />
	</form>
</body>
</html>