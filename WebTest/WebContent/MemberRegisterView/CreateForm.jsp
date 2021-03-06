<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
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
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
  margin-bottom: 5px;
}
.form button:hover,.form button:active,.form button:focus {
  background: #43A047;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}
.form .register-form {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}
body {
  background: #76b852; /* fallback for old browsers */
  background: -webkit-linear-gradient(right, #76b852, #8DC26F);
  background: -moz-linear-gradient(right, #76b852, #8DC26F);
  background: -o-linear-gradient(right, #76b852, #8DC26F);
  background: linear-gradient(to left, #76b852, #8DC26F);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}
</style>
</head>
<body>
	<div class="login-page">
  		<div class="form">
	<form action="/WebTest/MemberRegister/MemberServlet" method="post" id="CreateMember" class="register-form">
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
		<button type="button" onClick="fn_addMember()" >가입하기</button>
		<button type="reset">다시 입력</button>
		<input type="hidden" name="command" value="addMember" />
	</form>
	</div>
</div>
</body>
</html>