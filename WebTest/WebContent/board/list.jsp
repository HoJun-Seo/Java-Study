<%@page import="board.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='../include/board_header.jsp' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
<script type="text/javascript">
	$(function () {
		console.log('jQuery Ok...');
		$('#btnWrite').on('click', function () {
			location.href="${path}/board_servlet/write.do";
		});
	});
</script>
<link rel="stylesheet" href="../board/css/style.css">
</head>
<body>
	<h2>게시물 목록</h2>
	<hr>
	<button id="btnWrite">글쓰기</button>
	<table border="1" width="600px">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
			<td>첨부 파일</td>
			<td>다운로드</td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.rn}</td>
				<td>${dto.writer}</td>
				<td> 
					<a href="${path}/board_servlet/view.do?num=${dto.num}">
						${dto.subject}
						<c:if test="${dto.comment_count > 0 }">
							(${dto.comment_count})
						</c:if>
					</a>
				</td>
				<td>${dto.reg_date}</td>
				<td>${dto.readcount}</td>
				<!-- 첨부 파일 크기가 0 보다 크면 아이콘 표시 -->
				<td>
					<c:if test="${dto.filesize > 0 }">
						<a href="${path}/board_servlet/download.do?num=${dto.num}">
						<img src="${path}/board/images/천구의 결합6.png" width="50" id="download" /></a>
					</c:if>
					<c:if test="${dto.filesize == 0 }">
						<a href="${path}/board_servlet/download.do?num=${dto.num}">
							${dto.filename}
						</a>
					</c:if>
				</td>
				<td>${dto.down}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>