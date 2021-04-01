<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax File Upload 테스트</title>

<style>
	#dropZone {
		border: 5px solid red;
	    width: 70%;
	    height: 150px;
	    color: #92aab0;
	    text-align: center;
	    font-size: 24px;
	    padding-top: 20px;
	    margin-top: 10px;
	    margin-right: auto; margin-left: auto;
	}
	#fileList >div {
		border: 1px solid gray;
		padding: 5px; margin-bottom: 5px;
	}
	
</style>
<!-- jQuery 연결 -->
<script src="../script/jquery-3.6.0.min.js"></script>
<script>
//  전역 변수 선언

// 파일 리스트 번호
var fileIndex = 0;
// 등록할 전체 파일 사이즈
var totalFileSize = 0;
// 파일 리스트
var fileList = new Array();
// 파일 사이즈 리스트
var fileSizeList = new Array();
// 등록 가능한 파일 사이즈 MB : 
//(바이트 단위) : 5MB => 1024(바이트)*1024(키로바이트)*5(메가바이트)
var uploadSize = 50;
// 등록 가능한 총 파일 사이즈 MB
var maxUploadSize = 500; 

// html태그 로딩 
$(function() {
	console.log('jQuery Ok...');
	
	// 함수 호출
	fileDropDown();
});

// 파일 드롭 다운 : 이벤트 처리
function fileDropDown() {
	var dropZone = $('#dropZone'); 
	
	// Drop기능
	dropZone.on('dragenter', function(e){
		e.stopPropagation();		// 부모요소 전가되는 이벤트 처리 제거
		e.preventDefault();		// 기본 이벤트 제거
		// 드롭다운 영역 색상
		$(this).css('border-color','#e3f2fc');
	});
	
	dropZone.on('dragleave',function(e){
		e.stopPropagation(); 		// 부모요소 전가되는 이벤트 처리 제거
		e.preventDefault();		// 기본 이벤트 제거
		
		$(this).css('border-color', '#ffffff');
	});
	
	dropZone.on('dragover',function(e){
		e.stopPropagation(); 	// 부모요소 전가되는 이벤트 처리 제거
		e.preventDefault();		// 기본 이벤트 제거
		
		$(this).css('border-color', '#e3f2fc');
	});
	
	dropZone.on('drop',function(e){
		e.preventDefault();		// 기본 이벤트 제거
		
		$(this).css('border-color', '#ffffff');
		
		var files = e.originalEvent.dataTransfer.files;
		if (files != null) {
			if (files.length  < 1) {
				alert("업로드 불가");
				return;
			}
			
			// 정상 처리되면 수행하는 부분
			selectFile(files);
		} else {
			alert('ERROR');
		}
		
	});// drop()이벤트
	
}

// 파일 선택시 처리하는 함수
function selectFile(files){
	// 선택된 파일 등록
	if (files!=null){
		for (var i=0; i<files.length; i++){
			//파일 이름
			var fileName = files[i].name;
			// 파일이름과 확장자를 분리 : ex) test01.txt,  test001.abc.txt
			var fileNameArr = fileName.split("\."); // "."을 기준으로 분리, "\." =>점자체를의미
			// 확장자 추출
			var ext = fileNameArr[fileNameArr.length-1];
			// 파일 사이즈(단위:MB)
			var fileSize = files[i].size /1024/1024;
			
			// 특정 확장자는 업로드에서 제외시킴
			console.log("분리된 확장자:"+ext);
			// 자바스크립트에서 배열 기호 : [], var arr01 = [10,20,30]
			if ($.inArray(ext, ['exe','bat','sh','java','jsp','html','js','css','xml'])>=0){
				// 확장자 체크후 업로드가 제외는 확장자 추출
				alert("등록 불가 확장자");
				break; // 현재 반복문 제어 빠져나옴
			} else if (fileSize > uploadSize) {
				// 업로드 가능한 확장자 및 용량제한(50MB) 조건
				alert("용량 초과\n업로드 가능 용량 : "+uploadSize+" MB");
				break;
			} else {
				// 전체 파일 총 사이즈
				totalFileSize += fileSize;// 파일 사이즈 누적
				
				// 파일 배열에 넣기
				fileList[fileIndex] = files[i];
				// 파일 사이즈 배열에 넣기
				fileSizeList[fileIndex] = fileSize;
				
				// 업로드 파일 목록 생성(파일목록 처리하는 함수 호출)
				addFileList(fileIndex, fileName, fileSize);
				
				fileIndex++;
			}//if()
		}// for()
	} else {
		alert('ERROR');
	}
}//selectFile();

//업로드 파일 목록 생성(파일목록 처리하는 함수 저의)
function addFileList(fileIndex, fileName, fileSize){
	// <div id='fileTr_숫자'>파일이름/파일사이즈MB<a href="#" onclick='deleteFile(0); return false;'>삭제</a></div>
	var html ="";
	html += "<div id='fileTr_"+fileIndex+"'>";
	html += fileName+"/"+fileSize+" MB [";
	html += "<a href='#' onclick='deleteFile("+fileIndex+"); return false;'>삭제</a>]";
	html += "</div>";
	
	console.log('html출력 view 구성: '+html);
	$('#fileList').append(html);// 노드(태그) 추가
	$('#fileSize').html("<div>파일 총 용량 : "+totalFileSize+" </div>");// 노드(태그) 추가
	
}// addFileList()

// 업로드 파일 삭제
function deleteFile(fileIndex){
	// 전체 파일 사이즈 수정 (총사이즈에서 삭제파일크기 만큼 감소)
	totalFileSize -= fileSizeList[fileIndex];
	// 파일 배열에 파일 이름 제거
	delete fileList[fileIndex];
	// 파일 사이즈 배열에서 제거
	delete fileSizeList[fileIndex];
	// 업로드 파일 <div id='fileList'>태그에서 제거
	$("#fileTr_"+fileIndex).remove();
	$('#fileSize').html("<div>파일 총 용량 : "+totalFileSize+" </div>");// 노드(태그) 추가
	
}// deleteFile()

// 등록된 파일 업로드 처리
function uploadFile(){
	// 등록할 파일 리스트
	var uploadFileList = Object.keys(fileList);
	// 파일이 있는 체크
	if (uploadFileList.length == 0){
		alert("파일이 없습니다.");
		return;
	}
	// 용량을 500MB를 넘을 경우 업로드 불가
	if (totalFileSize > maxUploadSize) {
		// 파일 크기 제한 경고창
		alert("총 용량과\n총 업로드 가능 용량 : "+maxUploadSize+" MB");
		return;
	}
	
	// 제약 조건이 통과 업로드 여부 확인 절차
	if(confirm("등록 하시겠습니까?")){
		// 등록할 파일 리스트를 FormData로 데이터 입력
		var formData = new FormData();
		for(var i=0; i<uploadFileList.length; i++){
			formData.append('files', fileList[uploadFileList[i]]);
		}// for();
		
		var url = "ajax_fileuploadResult01.jsp";
		$.ajax({
			url: url,
			data: formData,
			type: 'POST',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			dataType: 'json',
			cache: false,
			success : function(result){
				if (result.data.length>0){
					alert("업로드 성공");
					location.reload();
				} else {
					alert("실패");
					location.reload();
				}
			}
		});
		
		
	}//if()
	
}// uploadFile()
</script>

</head>
<body>
<h2>드래그앤 드롭으로 파일업로드 (용량제한 및 파일확장자 제한)</h2>
<hr>
<form action=""  enctype="multipart/form-data" method="post">
		<div id="fileList">
				<div id="dropZone">파일을 드래그 하세요</div>
		</div>
		<div id="fileSize"></div>
</form>
<h3>
<a href="#" onclick="uploadFile(); return false;" >파일 업로드</a>
</h3>


</body>
</html>