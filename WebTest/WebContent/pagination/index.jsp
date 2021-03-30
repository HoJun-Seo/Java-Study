<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����¡ ����</title>
<link rel="stylesheet" href="../css/memo.css"/>
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function () { //html ��� ���������� �ε��Ǹ� ó���ϴ� �Լ�(�޼ҵ�)
		console.log('jQuery Ok....');
	
		// Ajax ó���ϴ� �Լ�(�޼ҵ�)
		list();
	});
	function list() {
		console.log('list() Ok....');
		
		$.ajax({
			url : "${pageContext.request.contextPath}/page_servlet/list.do",
			success : function (result) {
				console.log('ajax ����ó��');
				
				$('#result').html(result);
			}
		});
	}
</script>
</head>
<body>
	<h2>������ ����</h2>
	<hr>
	<div id="result"></div>
</body>
</html>