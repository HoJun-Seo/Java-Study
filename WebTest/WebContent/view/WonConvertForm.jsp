<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환율 계산기</title>
</head>
<body>
	<h2>환율 계산기</h2>
	<hr>
	<form action="/WebTest/calc/calc.do" method="get">
		원화 : <input type="text" name="won">
		<select name="operator">
			<option value="dollar">달러</option>
			<option value="en">엔화</option>
			<option value="wian">위안</option>
			<option value="pound">파운드</option>
			<option value="euro">유로</option>
		</select>
		<input type="submit" value="변환"/>
	</form>
</body>
</html>