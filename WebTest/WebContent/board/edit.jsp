<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<%@ include file='../include/board_header.jsp' %>    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 내용 수정</title>
</head>
<body>
<h2>게시물 수정</h2>
<hr>
<form action="" 
			name="form1" 
			enctype="multipart/form-data" 
			method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="writer" id="writer" value="${dto.writer }"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text"  name="subject"  id="subject" value="${dto.subject }"/></td>
		</tr>
		<tr>
			<td>본문</td>
			<td>
				<textarea 
					name="content" 
					id="content" 
					cols="60" rows="5">${dto.content }</textarea>
				</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<div>
				<c:if test="${dto.filesize > 0 }">
					${dto.filename } (${dto.filesize/1024}) KB
				</c:if>
				</div>
				<input type="file"  name="file1" />
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="passwd" id="passwd"/>
				<c:if test="${param.passwd_error == 'y' }">
					<span style="color:red;font-size:10px">비밀번호가 일치하지 않습니다.</span>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="hidden" name="num" value=${dto.num }>
				<input type="button"  id="btnUpdate" 	value="수정"/>
				<input type="button"  id="btnDelete" 	value="삭제"/>
				<input type="button"  id="btnList" 		value="목록"/>
			</td>
		</tr>
	</table>
</form>

<!--  jQuery -->
<script>
	$(function() {
		console.log('jQuery Ok...');
		
		
		// 수정 버튼
		$('#btnUpdate').click(function() {
			console.log('update');
			
			document.form1.action ="${path}/board_servlet/update.do?command=1";
			document.form1.submit();
		});
		// 삭제 버튼
		$('#btnDelete').click(function() {
			console.log('delete');
			
			if (confirm('삭제하시겠습니까?')) {
				document.form1.action ="${path}/board_servlet/update.do?command=2";
				document.form1.submit();	
			}
			
		});
		// 목록 버튼
		$('#btnList').click(function name() {
			console.log('list');
			
			document.form1.action ="${path}/board_servlet/list.do";
			document.form1.submit();
			
		});
		
	});

</script>
</body>
</html>