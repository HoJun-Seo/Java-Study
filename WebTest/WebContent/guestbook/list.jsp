<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String ctxpath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 리스트</title>
<style type="text/css">
	@charset "UTF-8";
		* { margin: 0; padding: 0;}
		table {
			width: 800px;
			border: 1px solid gray;
			border-collapse: collapse;
		}
		th,td {
			border: 1px solid gray;
			text-align: center;
			height: 30px;
		}
		a { text-decoration: none;} 
		#title { margin-top: 20px; margin-bottom: 20px;}
</style>
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	
/*
	$(function () {
		console.log('Ok...');
		
		var passwd = $('#passwd');
		$('#btnOK').click(function () {
			if(passwd.val()==''){
				alert('비밀번호를 입력하세요');
				passwd.focus();
				return;
			}
			var formArray = $(this).parent().parent().parent().parent().parent();
			console.log(formArray.attr('name'));
		});
		
		var formName = $('#form${dto.idx}').attr('id');
	});
	*/
	
</script>
</head>
<body>
	<h1>방명록 리스트</h1>
	<hr>
	<input type="button" value="글쓰기" onclick='location.href="<%=ctxpath %>/guestbook/write.jsp"' />
	${list.size()} 개의 글이 있습니다.
	<c:forEach var="dto" items="${list }">
		<form action="${pageContext.request.contextPath }/guestbook_servlet/passwd_check.do" name="form1">
			<input type="hidden" name="idx" value="${dto.idx}" />
			<table>
				<tr>
					<td>이름</td>
					<td>${dto.name}</td>
					<td>날짜</td>
					<td>${dto.post_date}</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td colspan="3">${dto.email}</td>
				</tr>
				<tr>
					<td colspan="4">${dto.content }</td>

				</tr>
				<tr>
					<td colspan="4">
						<input type="password" name="passwd">
						<input type="submit" id="btnOK" value="수정/삭제">
					</td>
				</tr>
			</table>
		</form>
		<br>
	</c:forEach>
</body>
</html>