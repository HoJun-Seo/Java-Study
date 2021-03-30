<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����¡ ���</title>
</head>
<body>
	<h2>����¡ ���</h2>
	<table>
		<tr>
			<td>NO</td>
			<td>��� ��ȣ</td>
			<td>��� �̸�</td>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.rn }</td>
				<td>${row.eno }</td>
				<td>${row.ename }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
				<c:if test="${curBlock > 1}">
					<a href="${pageContext.request.contextPath}/page_servlet/list.do?curPage=${prevPage}">[����]</a>
				</c:if>
				&nbsp;
				<c:forEach var="i" begin="${blockStart}" end="${blockEnd}">
					<a href="${pageContext.request.contextPath}/page_servlet/list.do?curPage=${i}">${i}</a>
				</c:forEach>
				<c:if test="${curBlock < totBlock}">
					<a href="${pageContext.request.contextPath}/page_servlet/list.do?curPage=${nextPage}">[����]</a>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>