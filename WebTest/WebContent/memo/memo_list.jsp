<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한 줄 메모</title>
<style type="text/css">
		* { margin: 0; padding: 0;}
		table {
			width: 800px;
			border: 1px solid gray;
			border-collapse: 
		}
		th,td {
			border: 1px solid gray;
			text-align: center;
			height: 30px;
		}
		a { text-decoration: none;} 
		#title { margin-top: 20px; margin-bottom: 20px;}

</style>
</head>
<body>
	<h2 id="title">메모 리스트</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>메모</th>
			<th>날짜</th>
		</tr>
		<!-- 자료를 출력 -->
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.idx}</td>
				<td>${row.writer}</td>
				<td>
					<a href="${pageContext.request.contextPath}/memo_servlet/view.do?idx=${row.idx}">${row.memo}</a>
				</td>
				<td>${row.post_date}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>