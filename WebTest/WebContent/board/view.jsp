<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='../include/board_header.jsp' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 내용 보기</title>
<link rel="stylesheet" href="../board/css/style.css">
<style type="text/css">
	#reply_table{
		width: 500px;
		border: 0px solid gray;
		border-collapse: collapse;
	}
	td, td {
		border: 1px solid gray;
	}
</style>
</head>
<body>
	<h2>게시물 내용 보기</h2>
	<form action="" name="form1" method="post">
		<table>
			<tr>
				<td>날짜</td>
				<td>${dto.reg_date}</td>
				<td>조회수</td>
				<td>${dto.readcount}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td colspan="3">${dto.writer }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.subject }</td>
			</tr>
			<tr>
				<td>본문</td>
				<td colspan="3">${dto.content }</td>
			</tr>
			<tr>
				<td>첨부 파일</td>
				<td colspan="3">${dto.filename }</td>
			</tr>
			<tr>
				<td>비밀 번호</td>
				<td colspan="1">
					<input type="password" name="passwd" id="passwd" />
						${dto.passwd }
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="hidden" name="num" value="${dto.num}"/>
					<input type="button" value="수정/삭제" id="btnEdit" />
					<input type="button" value="답변" id="btnReply" />
					<input type="button" value="목록" id="btnList" />
				</td>
			</tr>
		</table>
		<!-- 댓글 쓰기 폼 -->
		
		<br> <br>
		<table id="reply_table">
			<tr>
				<td>
					<input type="text" idd="writer" placeholder="이름" />
					<input type="password" name="comment_passwd" placeholder="">
				</td>
				<td></td>
			</tr>
			<tr>
				<td>
					<textarea name="content" id="content" 
						rows="3" cols="50" placeholder="댓글 내용을 입력하세요"></textarea>
				</td>
				<td> <input type="button" value="확인" /> </td>
			</tr>
		</table>
		<br>
		<div id="commentList">
			<!-- jQuery 작성 -->
			<script type="text/javascript">
				// html 태그(DOM) 메모리에 정상적으로 로딩되면 수행
				$(function () {
					console.log('jQuery Ok...');
					
					// 댓글 목록조회 하는 함수 호출
					commen_list();
					
					// 댓글 입력 버튼 클릭 시
					$('#btnSave').click(function () {
						console.log('댓글 입력버튼...');
						
						// 입력란 빈 공백 체크
						if($('#writer').val().length == 0){
							alert('이름을 입력 해주세요');
							$('#writer').focus();
							return;
						} else if(('#content').val() == 0) {
							alert('댓글을 입력해주세요');
							$('#content').focus();
							return;
						}
						
						// 서버에 전송할 매개변수 및 인자값 설정
						// 1. var param = "매개변수 = 인자값 & 매개변수 = 인자값 & ...."
						var param = "board_num" + ${dto.num} + "&writer=" + $('#writer').val()
							+ "&content=" + ${'#content'}.val();
						/* console.log("요청 url:" + ); */
						
						// ajax : 비동기 처리
						$.ajax({
							type: "post",
							url: '${path}/board_servlet/comment_addd.do',
							data: param,
							success: function () {
								console.log('댓글 입력 정상처리 되었습니다.');
								
								// 이름 입력란 clear
								$('#writer').val('');
								// 댓글 내용 clear
								$('#content').val('');
								// 포커스 이름에 맞춤
								$('#writer').focus();
								
								// 댓글 입력 후 댓글 내용 조회 처리하는 함수 호출
							}
						});
					})
				});
				// 게시물 번호에 대한 댓글 목록 조회 기능 요청
				function commen_list() {
					// 게시물 번호를 매개변수 값으로 설정 : 게시물 번호로 댓글 조회해야 하기 때문
					var param = "board_number=${dto.num}";
					
					// Ajax 비동기 처리 : 콜백 함수 처리
					$.ajax({
						type: "get",
						url: "${path}/board_servlet/comment_reply.do",
						data: param,
						success: function (result) {
							console.log('success...');
							
							// 댓글 조회내용을 추가
							$('#commentList').html(result);
						}
					}); // ajax()
				}
			</script>
		</div>
	</form>
</body>
</html>