<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한 줄 메모 ver1.0</title>
<link href="../css/memo.css" rel="stylesheet"/>
<style type="text/css">
	table {
		width: 400px;
	}
	th,td{
		text-align: left; padding: 5px;
	}
	#btn{
		text-align: center;
	}
</style>
<script src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function () {
		console.log("jQuery Ok...");
		
		$('#btnUpdate').click(function () {
			console.log('btnUpdate...');
		});
		$('#btnDelete').click(function () {
			console.log('btnDelete...');
		})
	})
	
</script>
</head>
<body>
	<h2>메모글 보기</h2> <hr>
	<form action="form1" name="form1" method="post">
		<table>	
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="writer" id="writer" value="${dto.writer}" />
				</td>
			</tr>
			<tr>
				<td>메모</td>
				<td><input type="text" name="memo" id="memo" value="${dto.memo}" /></td>
			</tr>
			<tr>
				<td colspan="2" id="btn">
					<input type="hidden" name="idx" id="idx" value="${dto.idx }" />
					<input type="button" value="수정" id="btnUpdate" />
					<input type="button" value="삭제" id="btnDelete" />
				</td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>