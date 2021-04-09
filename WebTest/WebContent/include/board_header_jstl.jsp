<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%-- jstl 연결하기 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 공동으로 사용되는 내용 변수로 설정하기 --%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="css_path"    value="${path }/board/css/" /> 