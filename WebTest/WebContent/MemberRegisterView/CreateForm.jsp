<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_addMember(){
		
		var createMember = document.getElementById('CreateMember');
		var id = createMember.id.value;
		var pwd = createMember.pwd.value;
		var name = createMember.name.value;
		var RRN1 = createMember.input1.value;
		var RRN2 = createMember.input2.value;
		
		if(id.length == 0 || id == ""){
			alert("아이디는 필수 입니다.");
		} else if(pwd.length == 0 || pwd == ""){
			alert("비밀 번호는 필수 입니다.");
		} else if(name.length == 0 || name == ""){
			alert("이름은 필수 입니다.");
		} else if(RRN1.length == 0 || RRN1 == ""){
			alert("주민등록 번호는 필수 입니다.");
		} else if(RRN2.length == 0 || RRN2 == ""){
			alert("주민등록 번호는 필수 입니다.");
		} else {
			createMember.submit();
		}
	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/WebTest/MemberRegister/MemberServlet" method="post" id="CreateMember">
		<table>
			<th>회원 가입</th>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>주민 등록번호</td>
				<td><input type="text" name="input1" maxlength="6">-<input type="text" name="input2" maxlength="7"></td>
				
			</tr>
		</table>
		<input type="button" value="가입하기" onClick="fn_addMember()" />
		<input type="reset" value="다시 입력" />
		<input type="hidden" name="command" value="addMember" />
	</form>
</body>
</html>