<%@ page 	language="java" 
					contentType="text/html; charset=UTF-8"   
					pageEncoding="UTF-8"  
					buffer="none"
					%>

 <%--
 스타일시트 변경 사항이 적시 반영이 잘 안될 경우
  버퍼값을 사용하지 않음을 설정 : buffer="none"  
  --%>
<%-- 스타일 시트 연결하기 --%> 
<link rel="stylesheet"  href="${css_path}style.css" />

<%-- 자바스크립트 관련 연결 --%>
<script src="${path}/script/jquery-3.6.0.min.js"></script>



					
<%--

출력버퍼
jsp페이지가 생성하는 출력내용을 곧바로 웹에 전송하지 않고, 버퍼에 저장했다가 
한꺼번에 전송됨.
 - 데이터 전송성능향상
 - jsp실행도중 버퍼를 지우고 새로운 내용을 보여줄 수있음
 - 버퍼가 다 차기 전가지는 헤더 변경 가능
 - 버퍼크기가 "8kb"이내일 때 평균적으로 가장 높은 성능 보여줌.
 - autoFlush="true" : 버퍼가 꽉 차면 내용을 전송, 
   "false": 버퍼가 꽉차면 예외발생 후 작업을 중지시키고 에러 페이지 출력
 
 - buffer="none": 버퍼 사용하지 않음
 --%>