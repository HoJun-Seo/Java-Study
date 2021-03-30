<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>페이징 구현</title>
<link rel="stylesheet" href="../css/memo.css"/>
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function () { //html 요소 정상적으로 로딩되면 처리하는 함수(메소드)
		console.log('jQuery Ok....');
	
		// Ajax 처리하는 함수(메소드)
		list();
	});
	function list() {
		console.log('list() Ok....');
		
		$.ajax({
			url : "${pageContext.request.contextPath}/page_servlet/list.do",
			success : function (result) {
				console.log('ajax 정상처리');
				
				$('#result').html(result);
			}
		});
	}
</script>
</head>
<body>
	<h2>페이지 구현</h2>
	<hr>
	<div id="result"></div>
</body>
</html>