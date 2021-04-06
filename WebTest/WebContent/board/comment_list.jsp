<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='../include/board_header.jsp' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 댓글 리스트 출력 -->
<table>
	<c:forEach var="row" items="${list}">
		<tr>
			<td>
				${row.writer} / ${row.reg_date} (
				<fmt:formatDate value="${row.reg_date }"
						pattern="yyyy-MM-dd hh:mm:ss"/>
				)
				${row.content}
			</td>
			<td>
				<button id="btnCommentDel">삭제</button>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>