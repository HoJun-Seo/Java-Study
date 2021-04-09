<%@page import="board.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='../include/board_header_jstl.jsp' %>    
<%@ include file='../include/board_header_cssjs.jsp' %>
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
	<!-- 검색 폼 -->
	<form action="${path }/board_servlet/searchList.do">
		<select name="search_option" id="">
			<option value="writer">이름</option>
			<option value="subject">제목</option>
			<option value="content">본문</option>
			<option value="all">이름+제목+본문</option>
		</select>
		<input type="text" name="keyword" />
		<input type="submit" value="조회" />
	</form>
	<button id="btnWrite">글쓰기</button>
	<div id="board_list_table">
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
						<c:forEach var="i" begin="1" end="${dto.re_level }">&nbsp;</c:forEach>
						<c:if test="${dto.re_level != 0 }">
							<img src="${path}/board/images/천구의 결합6.png" width="15px" />
						</c:if>
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
		<tr>
			<td colspan="3">
				<c:if test="${curBlock > 1}">
					<a href="${pageContext.request.contextPath}/board_servlet/list.do?curPage=${prevPage}">[이전]</a>
				</c:if>
				&nbsp;
				<c:forEach var="i" begin="${blockStart}" end="${blockEnd}">
					<a href="${pageContext.request.contextPath}/board_servlet/list.do?curPage=${i}">${i}</a>
				</c:forEach>
				<c:if test="${curBlock < totBlock}">
					<a href="${pageContext.request.contextPath}/board_servlet/list.do?curPage=${nextPage}">[다음]</a>
				</c:if>
			</td>
		</tr>
		</table>
	</div>
	<div id="page_nav"></div>
</body>
</html>