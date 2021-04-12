<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='../include/board_header_jstl.jsp' %>          
<%@ include file='../include/board_header_cssjs.jsp' %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax이용해 서버와 JSON 자료 주고 받기</title>
</head>
<body>
<h3>Ajax이용해 서버와 JSON 자료 주고 받기</h3>
<hr />
JSON 자료 서버에 전송하기
<input type="button" value="전송" id="checkJson" />
<hr />
<h3>서버로 부터 받은 JSON자료 </h3>
<div id="output"></div>

<script type="text/javascript">
$(function() {
	console.log('jQuery Ok...');
	
	$('#checkJson').click(function() {
		var jsonStr = '{  "name"  : "홍길동", "age":"20", "gender":"남자","nickname":"날센돌이"  }';
		
		$.ajax({
			// 전송 방식 : post, get
			type: "post",
			// 동기식(false), 비동기식 (true)
			async: false, 
			 //  => "/webTest/json"
			url : "${path}/json",
			// 전송할 데이터 및 형식 : { 매개변수이름 : 보내낼 데이터}
			data : { jsonInfo :  jsonStr},
			// 정상적으로 요청이 되면 수행하는 함수
			success : function(data) {
				console.log("success...");
				// 받아오는 데이터가 JSON데이터이므로 파싱처리
				var jsonInfo = JSON.parse(data);
				var memberInfo = "서버로 부터 받은 회원정보<br>";
				memberInfo += "-------------<br>";
				
				for (var i in jsonInfo.members){
					memberInfo +="이름: "+jsonInfo.members[i].name+"<br>";
					memberInfo +="나이: "+jsonInfo.members[i].age+"<br>";
					memberInfo +="성별: "+jsonInfo.members[i].gender+"<br>";
					memberInfo +="별명: "+jsonInfo.members[i].nickname+"<br>";
					memberInfo +="<hr>"					
				}
				
				$('#output').html(memberInfo);
				
			},
			// 전송 실패
			error : function(data, textStatus) {
				alert('에러가 발생했습니다.');
			}
			
		});
	});
	
	
});
</script>
</body>
</html>