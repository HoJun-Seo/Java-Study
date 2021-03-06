package board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dao.BoardDAO;
import board.dto.BoardCommentDTO;
import board.dto.BoardDTO;
import common.Constants;
import pagination.EmpDAO;


@WebServlet("/board_servlet/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		System.out.println("요청 URL : " + url);
		
		BoardDAO dao = new BoardDAO();
		
		// 클라이언트로 부터 요청한 url 을 분석하여 조건에 맞게 처리
		if(url.contains("list.do")) {
			
			
			// --- 페이지에 대한 레코드 범위 계산
			int curPage = 1; // 현재 페이지
			if(request.getParameter("curPage") != null) {
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			// 전체 페이지 계산 : 1페이지 10개의 레코드
			int page_scale = 10; 
			
			int totCount = dao.recordCount();
			int totPage = (int)Math.ceil((totCount)*1.0/page_scale); // 소수점 이하 있으면 자리 올림
			System.out.println("총 레코드 수 : " + totCount + ", 총 페이지 수 : " + totPage);
			
			// 레코드 시작 번호, 마지막 번호(페이지 별로 구분)
			int start = (curPage-1)*page_scale+1; //(1-1)*10+1 => 1
			int end = start+page_scale-1; 
						
			// ---- 페이지 블록 갯수 : 1 블럭에 표시할 페이지 수 계산
			// 1 블럭에 보여질 페이지 갯수(묶음) : ex) 1 블럭 10페이지 단위로 표시
			int block_scale = 10;
			// 블럭의 총 갯수 계산 : 전체 페이지 / 1 블럭에 보여질 페이지 수
			int tot_block = (int)Math.ceil(totPage*1.0/block_scale);
					
			//현재 페이지에 대한 블럭 범위의 계산
			int cur_block = (int)Math.ceil((curPage-1)/block_scale)+1;
			int block_start = (cur_block-1) * block_scale+1; // 블럭의 시작 페이지 번호
			int block_end = block_start + block_scale-1; // 블럭의 끝 페이지 번호
						
			// 페이지 블럭에서 이전, 다음 표시 여부 계산 : 첫 블럭에서 이전 표시 안함, 마지막 블럭에서는 다음 표시안함
			//현재 블럭의 마지막 번호가 전체 페이지 마지막 번호 보다 크면 현재 마지막 블럭 번호를 마지막 페이지 번호로 설정
			int prev_page = (cur_block-2) * block_scale + 1; // 이전 블럭 시작 페이지 계산
			int next_page = (cur_block * block_scale) + 1;
						
			System.out.println("이전 블럭 시작페이지 번호 : " + prev_page +
					", 현재 블럭 시작페이지 번호 : " + ((cur_block-1) * block_scale + 1));
			System.out.println("다음 블럭 시작페이지 번호 : " + next_page + 
					", 현재 블럭 시작페이지 번호 : " + ((cur_block-1) * block_scale + 1));
			
			//db 요청 처리하여 결과값 반환하여 저장
			List<BoardDTO> list = dao.boardList(start, end);
			// 뷰 페이지에 결과값을 전송하기 위해 request 에 자료보관
			request.setAttribute("list", list);
			request.setAttribute("totPage", totPage);
			request.setAttribute("totBlock", tot_block);
			request.setAttribute("curBlock", cur_block);
			request.setAttribute("blockStart", block_start);
			request.setAttribute("blockEnd", block_end);
			request.setAttribute("prevPage", prev_page);
			request.setAttribute("nextPage", next_page);
			
			String page = "/board/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		} else if(url.contains("write.do")) {
			System.out.println("write.do 처리중...");
			
			// 게시물 작성 뷰 페이지에 이동 시킴
			// 1. 전송할 값이 있을 경우 포워드
//			String page = "/board/write.jsp";
//			RequestDispatcher rd = request.getRequestDispatcher(page);
//			rd.forward(request, response);
			
			// 2. 전송할 값이 없을 경우
			String page = "/board/write.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if(url.contains("insert.do")) {
			System.out.println("insert.do 처리중....");
			
			// 폼에서 넘어온 인자 값을 보관하는 DTO 생성
			BoardDTO dto = new BoardDTO();
			

			try {
				
				// 파일 업로드 기능
				File uploadDir = new File(Constants.UPLOAD_PATH);
				if(!uploadDir.exists()) {
					// 폴더가 없으면 생성
					uploadDir.mkdir();
				}
				// upload 라이브러리 사용하여 파일 업로드 처리 : cos.jar
				MultipartRequest multi = new MultipartRequest(request,
						Constants.UPLOAD_PATH,
						Constants.MAX_UPLOAD,
						"utf-8",
						new DefaultFileRenamePolicy()
					);
				
				String filename = "";
				int filesize = 0;
				
				Enumeration files = multi.getFileNames();
				// 요소가 있는지 유무 체크, 있으면 반복문 처리
				while(files.hasMoreElements()) {
					// 요소 검색하여 추출
					String file1 = (String)files.nextElement();
					// 요소의 파일 추출 : file 에 저장된 값을 추출 :
					// file1 에 있는 value 값
					filename = multi.getFilesystemName(file1);
					File f1 = multi.getFile(file1);
					if(f1 != null) filesize = (int)f1.length();
					System.out.println("filesize:" + filesize);
					
					// 폼에 작성한 내용(인자값) 받아서 dto 저장
					String writer = multi.getParameter("writer");
					String subject = multi.getParameter("subject");
					String content = multi.getParameter("content");
					String passwd = multi.getParameter("passwd");
					// 클라이언트의 ip 주소
					String ip = request.getRemoteAddr();
					
					dto.setWriter(writer);
					dto.setSubject(subject);
					dto.setContent(content);
					dto.setPasswd(passwd);
					dto.setIp(ip);
					
					if(filename == null || filename.equals("")) {
						filename = "-";
					}
					dto.setFilename(filename);
					dto.setFilesize(filesize);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("dto : " + dto.toString());
			
			dao.insert(dto);
			response.sendRedirect(request.getContextPath()+"/board_servlet/list.do");
		} else if(url.contains("download.do")) {
			System.out.println("download.do 처리중...");
			
			int num = Integer.parseInt(request.getParameter("num"));
			// db 파일을 검색
			String filename = dao.getFileName(num);
			System.out.println("num : " + num + ", filename : " + filename);
			// 파일 이름을 가지고 다운로드
			// 서버에서 파일을 읽어서 클라이언트에게 보내는 기능(input/output)
			String path = Constants.UPLOAD_PATH+"/"+filename;
			System.out.println("다운로드 파일경로 및 파일명 : " + path);
			byte[]b = new byte[4096];
			
			FileInputStream fis = new FileInputStream(path);
			//마임 타입(파일의 종류) 설정
			String mineType = getServletContext().getMimeType(path);
			if(mineType == null) { // null 이면 기본값 부여(범용 타입)
				mineType = "application/octect-stream; charset=utf-8";
			}
			// 파일 이름에 한글이 포함된 경우 처리
			// 스트림.getBytes('문자셋')스트림을 바이트 배열로 저장
			// new String(바이트배열, '문자셋') : "ms949(윈도우에서 사용되는 문자셋), 8859_1 : 서유럽언어"
			filename = new String(filename.getBytes("utf-8"), "8859_1");
			
			// 헤드에 첨부파일 정보 표시
			response.setHeader("Content-Disposition", "attachment;filename="+filename);
			ServletOutputStream out = response.getOutputStream();
			
			int numRead;
			while(true) {
				numRead = fis.read(b, 0, b.length);
				if(numRead == -1) { // 더 이상 읽을 내용이 없으면 반복문 빠져나옴
					break;
				}
				out.write(b, 0, numRead); // 클라이언트에 전송
			}
			// 리소스 해제(정리)
			out.flush(); out.close(); fis.close();
			
			// 다운로드 횟수 처리
			dao.plusDown(num);
//			response.sendRedirect(request.getContextPath()+"/board_servlet/list.do");
		}
		else if(url.contains("view.do")) {
			System.out.println("view.do 처리중...");
			String message = request.getParameter("message");
			
			int num = Integer.parseInt(request.getParameter("num"));
			
			// 조회 횟수 증가처리
			dao.plusReadCount(num);
			
			// 상세 페이지에 넣을 게시글 내용 읽기
			BoardDTO dto = dao.view(num);
			request.setAttribute("dto", dto);
			request.setAttribute("message", message);
			
			String page = "/board/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if(url.contains("comment_reply.do")) {
			System.out.println("comment_reply.do 처리중....");
			
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			System.out.println("게시물 번호 : " + board_num);
			
			// 댓글 List 조회 요청
			List<BoardCommentDTO> list = dao.commentList(board_num);
//			System.out.println("댓글 : " + list.toString());
			
			// 댓글 내용을 저장해서 view 페이지에 전달
			request.setAttribute("list", list);
			
			String page = "/board/comment_list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		} else if(url.contains("comment_add.do")) {
			System.out.println("comment_add.do 처리중...");
			
			// 인자로 넘어온 값을 dto 에 저장
			BoardCommentDTO dto = new BoardCommentDTO();
			// 게시글 번호
			dto.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
			// 댓글 작성자
			dto.setWriter(request.getParameter("writer"));
			dto.setContent(request.getParameter("content"));
			
			// 게시물 번호에 대한 댓글 내용 저장하기 요청
			dao.commentAdd(dto);
			
		} else if(url.contains("passwd_check.do")) {
			System.out.println("passwd_check.do 처리 중...");
			
			int num = Integer.parseInt(request.getParameter("num"));
			String passwd = request.getParameter("passwd");
			
			// 인자로 넘어온 비번, 게시물 번호 체크
			String result = dao.passwdCheck(num, passwd);
			
			String page ="";
			if(result != null) {
				// 비번 일치 : 수정, 삭제
				request.setAttribute("dto", dao.view(num));
				
				page ="/board/edit.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			} else {
				// 비번 불일치 : 에러 메시지 전달
				page = request.getContextPath() + "/board_servlet/view.do?num=" + num + "&message=error";
				response.sendRedirect(page);
			}
		} else if(url.contains("update.do")) {
			System.out.println("passwd_check.do 처리중...");
			
			int num = Integer.parseInt(request.getParameter("num"));
			String passwd = request.getParameter("passwd");
			
			System.out.println("비번:"+passwd+",게시물번호:"+num);
			
			// 인자로 넘어온 비번, 게시물 번호 체크
			String result = dao.passwdCheck(num, passwd);
			System.out.println("passwd check result: "+result);
			
			String page = "";
			
			if (result != null) {
				// 비번 일치 : 수정, 삭제 작업을 처리
				request.setAttribute("dto", dao.view(num));
				
				page = "/board/edit.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			} else {
				// 비번 불일치: 에러메시지 전달
				page = request.getContextPath()+
						"/board_servlet/view.do?num="+num+"&message=error";
				response.sendRedirect(page);
			}// if()
			
		} else if (url.contains("update.do")) {
			System.out.println("update.do 처리중...");
			
			// command=1: 수정처리, command=2: 삭제처리
			int command = Integer.parseInt(request.getParameter("command"));
			
			// 폼에서 넘어온 인자 값을 보관하는 DTO생성
			BoardDTO dto = new BoardDTO();
			
			// ----------------------- //
			// 파일 업로드 기능
			// ----------------------- //
			try {
				
					//File uploadDir = new File("c:/upload_test");
					File uploadDir = new File(Constants.UPLOAD_PATH);
					if (!uploadDir.exists()) {
						// 폴더가 없으면 생성
						uploadDir.mkdir();
					}
					
					// upload 라이브러리 사용하여 파일 업로드 처리: cos.jar
					MultipartRequest multi = new MultipartRequest(
							request, 
							Constants.UPLOAD_PATH,
							Constants.MAX_UPLOAD,
							"utf-8",
							new DefaultFileRenamePolicy()
							);
				
					// 파일이름 , 파일 사이즈 기본값 설정
					String filename ="";
					int filesize = 0;
				
					Enumeration files = multi.getFileNames();
					while(files.hasMoreElements()) {
						String file1 = (String) files.nextElement();
						filename = multi.getFilesystemName(file1);
						File f1 = multi.getFile(file1);
						if (f1 != null) filesize = (int)f1.length();
						System.out.println("filesize: "+filesize);
					}// while()					
				
					// 폼에 작성한 내용(인자값) 받아서 dto저장
					// 게시물 번호 
					int num = Integer.parseInt(multi.getParameter("num"));
					// 비번
					String passwd = multi.getParameter("passwd");
					
					String writer = multi.getParameter("writer");
					String subject = multi.getParameter("subject");
					String content = multi.getParameter("content");
					String ip = request.getRemoteAddr();
					
					
					dto.setNum(num);
					dto.setWriter(writer);
					dto.setSubject(subject);
					dto.setContent(content);
					dto.setPasswd(passwd);
					dto.setIp(ip);
					
					if (filename == null || filename.equals("")) {
						
						// 수정폼에서 첨부파일내용이 없으면 입력시에 저장된 파일정보를 수정에서
						// 그대로 사용
						BoardDTO dto2 = dao.view(num);
						
						String fName = dto2.getFilename();
						int fSize = dto2.getFilesize();
						int fDown = dto2.getDown();
						
						dto.setFilename(fName);
						dto.setFilesize(fSize);
						dto.setDown(fDown);
						
					} else {
						// 수정폼에서 넘어온 파일이름, 파일크기 정보를 dto에 저장
						dto.setFilename(filename);
						dto.setFilesize(filesize);
					}
					
					//------------------------------- //
					// 수정 전 비밀 번호 체크 후 처리
					//------------------------------- //
					
					String result = dao.passwdCheck(num, passwd);
					String page ="";
					
					if (result != null) {
						
						// 비번 일치 : db 수정,삭제
						if (command==1) {
							// 수정 처리
							dao.update(dto);
						} else if (command==2) {
							// 삭제처리
							dao.delete(num);
						}
						
						page = request.getContextPath()+ "/board_servlet/list.do";
						response.sendRedirect(page);
						
					} else {
						// 비번 불일치 : 에러 메시지 처리
						request.setAttribute("dto", dto);
						
						page = "/board/edit.jsp?passwd_error=y";
						RequestDispatcher rd = request.getRequestDispatcher(page);
						rd.forward(request, response);
						
					}
					
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}// try()
			
			System.out.println("dto : "+dto.toString());				
		}  else if(url.contains("reply.do")) {
			System.out.println("reply.do 처리 중..");
			
			// 원글 게시물 번호 받아옴
			int num = Integer.parseInt(request.getParameter("num"));
			
			// 원글 게시물 기본 정보 db 요청
			BoardDTO dto = dao.view(num);
			dto.setContent("==== 게시물 내용 ====\n" + dto.getContent());
			
			// 답글 작성하기로 보냄
			request.setAttribute("dto", dto);
			String page = "/board/reply.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
			// 게시물 작성 원리와 동일
		} else if(url.contains("insertReply.do")) {
			System.out.println("insertReply.do");
			
			int num = Integer.parseInt(request.getParameter("num"));
			
			BoardDTO dto = dao.view(num);
			System.out.println("원글 계층구조" + dto.getNum() + 
					", ref : " + dto.getRef() + ", re_step : " + dto.getRe_step() + 
					", re_level : " + dto.getRe_level());
			
			// 원글의 계층번호 구조를 참조하여 답글에 대한 계층번호 설정
			// 원글 ref(원글에 대한 그룹)
			int ref = dto.getRef();
			// 원글 계층번호 보다 순서 1단계 아래로 설정
			int re_step = dto.getRe_step() + 1;
			// 원글 계층번호 보다 level 을 1단곌 깊게 설정
			int re_level = dto.getRe_level() + 1;
			
			// 게실물 작성 원리와 동일
			String writer = request.getParameter("writer");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String passwd = request.getParameter("passwd");
			
			dto.setWriter(writer);
			dto.setSubject(subject);
			dto.setContent(content);
			dto.setPasswd(passwd);
			
			dto.setRef(ref);
			dto.setRe_step(re_step);
			dto.setRe_level(re_level);
			
			// 첨부파일 관련 정보는 기본값으로 설정
			dto.setFilename("-");
			dto.setFilesize(0);
			dto.setDown(0);
			
			// 1. 답변글에 대한 출력 순번 조정
			// (같은 그룹의 기존 게시물은 +1 로 모두 update 처리해야함)
			dao.updateStep(ref, re_step);
			
			// 2. 답글 내용 db에 저장
			dao.reply(dto);
			
			response.sendRedirect(
					request.getContextPath() +
					"/board_servlet/list.do");
		}
		else if(url.contains("searchList.do")) {
			
			String searcch_option = request.getParameter("search_option");
			String keyword = request.getParameter("keyword");
			
			// 키워드 통한 검색(필터링)
			List<BoardDTO> list = dao.searchList(searcch_option, keyword);
			request.setAttribute("list", list);
			
			String page = "/board/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
