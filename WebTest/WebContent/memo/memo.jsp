<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄 메모장 ver1.0</title>
<script src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	// html 태그 요소 이벤트 처리하기 위해 loading 시킴
	$(function () {
		console.log('jQuery Ok...');
		
		// html 태그 로딩 후 자동호출
		list();
		
		// 확인 버튼 클릭 시 처리 : 한 줄 메모를 db에 저장
		$('#btnSave').click(function () {
			console.log('확인 버튼 클릭');
			
			//입력 처리요청
			insert();
		});
	}); // jQuery()
	
	function insert() {
		var writer = $('#writer').val();
		var memo = $('#memo').val();
		// writer=123&memo=1245 : url 방식으로 전달
		var param = "writer="+writer+"&memo="+memo;
		
		$.ajax({
			type: "post",
			url : "${pageContext.request.contextPath}/memo_servlet/insert.do",
			data : param, //전송할 인자
			success : function () { // 정상 처리되었을 때 자동수행
				console.log('메모글 정상적으로 입력되었음');
			
				// 입력된 db 확인
				list();
				$('#writer').val('');
				$('#memo').val('');
			}
		}); // ajax()
	}
	
	// list() 함수정의 : 한 줄 메모 목록 => ajax() : 비동기식 처리
	function list() {
		$.ajax({
			type: "get", 
			/* url: "/WebTest/memo_servlet/list.do", */ 
			url: "${pageContext.request.contextPath}/memo_servlet/list.do",
			success: function (result) {
				// 정상적으로 처리되면 수행하는 메소드
				/* $('#result').text() */
				$('#result').html(result);
			} 
		}); // ajax()
	}
</script>
</head>
<body>
	<h2>한줄 메모장</h2> <hr>
	이름 : <input type="text" id="writer" size="10" /> <br>
	메모 : <input type="text" id="memo" size="10" /> <br>
	<input type="button" id="btnSave" value="확인" />
	<br>
	<h3>메모 리스트</h3>
	<div id="result"></div>
</body>
</html>