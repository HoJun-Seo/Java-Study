<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>특정 영역에 드래그 하여 파일 업로드</title>
<style>
	#dropzone {
		border: 2px solid red;
	    width: 70%;
	    height: 150px;
	    color: #92aab0;
	    text-align: center;
	    font-size: 24px;
	    padding-top: 20px;
	    margin-top: 10px;
	    margin-right: auto; margin-left: auto;
	}
	
</style>
<!-- jQuery 연결 -->
<script src="../script/jquery-3.6.0.min.js"></script>
<script>
	$(function() {
		console.log('jQuery Ok..');
		
		// 태그요소를  스크립트 객체 변수에 저장
		var obj = $('#dropzone');
		
		// 객체에 대한 이벤트 처리 방법
		// 1. obj.on('click', function(){});
		// 2. obj.click(function(){});
		
		obj.on('dragenter', function(e){
			e.stopPropagation();		// 부모요소 전가되는 이벤트 처리 제거
			e.preventDefault();		// 기본 이벤트 제거
			
			$(this).css('border-color','blue');
			console.log('dragenter event ...');
		});
		obj.on('dragleave',function(e){
			e.stopPropagation(); 		// 부모요소 전가되는 이벤트 처리 제거
			e.preventDefault();		// 기본 이벤트 제거
			
			$(this).css('border-color', 'green');
			console.log('dragleave event ...');
		});
		obj.on('dragover',function(e){
			e.stopPropagation(); 	// 부모요소 전가되는 이벤트 처리 제거
			e.preventDefault();		// 기본 이벤트 제거
			
			console.log('dragover event ...');
		});
		
		obj.on('drop',function(e){
			e.preventDefault();		// 기본 이벤트 제거
			
			$(this).css('border','2px dotted #8296c2');
			console.log('drop event ...');
			
			var files = e.originalEvent.dataTransfer.files;
			if (files.length < 1) return;
			
			// 함수 호출
			F_FileMultiUpload(files, obj);
		});
		
		// 파일 멀티 업로드 처리하는 함수 정의
		function F_FileMultiUpload(files, obj){
			
			var result = confirm(files.length + "개의 파일을 업로드 하시겠습니까?");
			console.log('업로드 여부: '+result);
			
			if (result){
				var data = new FormData();
				for(var i=0; i<files.length; i++){
					data.append('file', files[i]);
				}
				
				// 업로드 처리 하는 로직으로 보내기
				
				var url = "fileuploadResult01.jsp";
				console.log('url:'+url);
				$.ajax({
					url: url,
					method: 'post',
					data: data,
					dataType: 'json',
					processData: false,
					contentType: false,
					success : function(res){
						console.log('업로드 성공되었습니다.');
						
						//  함수 호출
						F_FileMultiUpload_Callback(res.files);
					}
				});// $.ajax();
				
				
			}// if()
		}// fun()
		
		// 콜백 함수 정의
		function F_FileMultiUpload_Callback(files) {
			for(var i=0; i<files.length; i++){
				console.log(files[i].file_nm+" - "+files[i].file_size);
			}
		}
	
	});
</script>

</head>
<body>
<h2>특정 영역에 드래그 하여 파일 업로드</h2>
<hr>
<div id="dropzone">
	Drag Drop file Here
</div>

</body>
</html>