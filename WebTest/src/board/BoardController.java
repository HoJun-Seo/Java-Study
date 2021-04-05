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
import board.dto.BoardDTO;
import common.Constants;


@WebServlet("/board_servlet/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		System.out.println("요청 URL : " + url);
		
		BoardDAO dao = new BoardDAO();
		
		// 클라이언트로 부터 요청한 url 을 분석하여 조건에 맞게 처리
		if(url.contains("list.do")) {
			//db 요청 처리하여 결과값 반환하여 저장
			List<BoardDTO> list = dao.boardList();
			// 뷰 페이지에 결과값을 전송하기 위해 request 에 자료보관
			request.setAttribute("list", list);
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
			response.sendRedirect(request.getContextPath()+page);
		} else if(url.contains("insert.do")) {
			System.out.println("insert.do 처리중....");
			
			// 폼에서 넘어온 인자 값을 보관하는 DTO 생성
			BoardDTO dto = new BoardDTO();
			
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

			try {
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
			
			int num = Integer.parseInt(request.getParameter("num"));
			
			// 조회 횟수 증가처리
			dao.plusReadCount(num);
			
			// 상세 페이지에 넣을 게시글 내용 읽기
			BoardDTO dto = dao.view(num);
			request.setAttribute("dto", dto);
			
			String page = "/board/view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		
	} 
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
