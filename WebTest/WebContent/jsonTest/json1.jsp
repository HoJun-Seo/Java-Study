<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/pagination_header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON Test 01</title>
</head>
<body>
<h3>JSON 자료 출력</h3>
<hr />
JSON : 
<input type="button" value="이름출력" id="checkJson" />
<input type="button" value="나이 출력" id="checkJson2" />
<input type="button" value="회원정보 출력" id="checkJson3" />
<input type="button" value="회원정보 출력2" id="checkJson4" />
<hr />
<div id="output"></div>
<div id="output2"></div>
<div id="output3"></div>
<div id="output4"></div>


<script>
function name() {
	console.log('jQuery Ok...');
	
	$('#checkJson').click(function() {
		var jsonStr = '{  "name"  :  ["홍길동","동순이","동길이홍"]   }';
		// name[0],name[1],name[2],
		
		// JSON기능인 parse()메서드를 이용해 JSON자료형을 가져옴
		var jsonInfo = JSON.parse(jsonStr);
		var output = "회원 이름 <br>";
		for (var i in jsonInfo.name){// i는 인텍스 번호을 의미
			output += jsonInfo.name[i] + "<br>";
		}
		$('#output').html(output);
	});
	
	$('#checkJson2').click(function() {
		var jsonStr1 = '{  "age"  :  [20,25,28]   }';
		
		// JSON기능인 parse()메서드를 이용해 JSON자료형을 가져옴
		var jsonInfo = JSON.parse(jsonStr1);
		var output2 = "회원 나이 <br>";
		for (var i in jsonInfo.age){
			output2 += jsonInfo.age[i] + "<br>";
		}
		$('#output2').html(output2);
	});
	
	$('#checkJson3').click(function() {
		var jsonStr3 = '{  "name"  : "홍길동", "age":"20", "gender":"남자","nickname":"날센돌이"  }';
		
		// JSON기능인 parse()메서드를 이용해 JSON자료형을 가져옴
		var jsonInfo = JSON.parse(jsonStr3);

		var output3 = "회원 정보 <br>";
		output3 +="===<br>"
		output3 +="이름: "+jsonInfo.name+"<br>";
		output3 +="나이: "+jsonInfo.age+"<br>";
		output3 +="성별: "+jsonInfo.gender+"<br>";
		output3 +="별명: "+jsonInfo.nickname+"<br>";

		$('#output3').html(output3);
	});

	$('#checkJson4').click(function() {
		// { 키 : [객체배열구조 데이터] } => { 키:  [ {객체1},{객체2},{객체3}...{객체n}]   }
		var jsonStr4 = 
		'{ "member" : [ ' +
			'{  "name"  : "홍길동", "age":"20", "gender":"남자","nickname":"날센돌이"  }, '+
			'{  "name"  : "동길이", "age":"30", "gender":"남자","nickname":"바보돌이"  }, '+
			'{  "name"  : "동순이", "age":"25", "gender":"여자","nickname":"날센순이"  }' +
		' ] }' ;
		// member[0],member[1],member[2],...
		
		// JSON기능인 parse()메서드를 이용해 JSON자료형을 가져옴
		var jsonInfo = JSON.parse(jsonStr4);

		var output4 = "회원 정보2 <br>";
		output4 +="===<br>";

		for (var i in jsonInfo.member){// i는 인덱스 번호
			output4 +="이름: "+jsonInfo.member[i].name+"<br>";
			output4 +="나이: "+jsonInfo.member[i].age+"<br>";
			output4 +="성별: "+jsonInfo.member[i].gender+"<br>";
			output4 +="별명: "+jsonInfo.member[i].nickname+"<br>";
			output4 +="<hr>"
		}

		$('#output4').html(output4);
	});
	
	
	
}
</script>
</body>
</html>
<!-- 
자료형식 : { "key": "값"}
수(Number) : 정수, 실수(고정, 부동소수점)
문자열 : 문자열, 제어문자("\n","\b",.....)
배열 : 배열은 "[]" 대괄호로 표시, ex) {"num": [10,20,30,..]}
객체 : JSON객는 중괄호 {} 표시  
{
	"name": "홍길동",
	"age" : "16",....
}
객체를 배열로 표현 : [ {...},{...},...{...} ] 


 -->