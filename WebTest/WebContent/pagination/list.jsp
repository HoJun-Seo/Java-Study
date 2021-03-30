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
			<td></td>
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
					<a href="${pageContextPath.request.contextPath}
					/page_servlet/list.do?curPage=${prevPage}">[����]</a>&nbsp;
				</c:if>
				<c:forEach var="i" begin="${blockStart}" end="${blockEnd}">
					<a href="${pageContextPath.request.contextPath}
					/page_servlet/list.do?curPage=${i}">
					${i}
					</a> &nbsp;
				</c:forEach>
				<c:if test="${curBlock < totBlock}">
					<a href="${pageContextPath.request.contextPath}
					/page_servlet/list.do?curPage=${nextPage}">[����]</a>&nbsp;
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>