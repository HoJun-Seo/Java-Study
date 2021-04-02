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
<link rel="stylesheet" href="../board/css/style.css">
</head>
<body>
	<h2>게시물 목록</h2>
	<hr>
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
				<td>${dto.num}</td>
				<td>${dto.writer}</td>
				<td>${dto.subject}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.readcount}</td>
				<td>${dto.filename}</td>
				<td>${dto.down}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>