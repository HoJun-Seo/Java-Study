package memo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.dao.MemoDAO;
import memo.dto.MemoDTO;

@WebServlet("/memo_servlet/*")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 요청");
		String url = request.getRequestURL().toString();
		System.out.println("요청한 클라이언트 : " + url + "," + url.indexOf("list.do"));
		
		// db 작업 처리를 위한 db 처리 서비스 DAO 생성
		MemoDAO dao = new MemoDAO(); 
		
		// url 입력시 특정 문자열을 이용하여 작업구분
		if(url.indexOf("list.do") != -1) {
			System.out.println("list.do 처리중...");
			
			// 한 줄 메모 내용 조회 기능을 요청 : MemoDAO
			List<MemoDTO> list = dao.listMemo();
			
			// list 객체를 request 객체 보관
			request.setAttribute("list", list);
			
			// view page url 연결
			String page ="/memo/memo_list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		else if(url.indexOf("insert.do") != -1) {
			System.out.println("insert.do 처리중...");
			
			String writer = request.getParameter("writer");
			String memo = request.getParameter("memo");
			
			System.out.println("넘어온 자료 : " + writer + ","+memo);
			
			MemoDTO dto = new MemoDTO(writer, memo);
			
			// dao 에 메모추가 서비스 요청
			dao.insertMemo(dto);
		}
		else if(url.indexOf("view.do") != -1) {
			System.out.println("view.do 처리중...");
			
			String idx = request.getParameter("idx");
			MemoDTO dto = dao.viewMemo(idx);
			
			request.setAttribute("dto", dto);
			
			String page = "/memo/memo_view.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		}
		else if(url.contains("update.do")) {
			System.out.println("update.do 처리중...");
			
			int idx = Integer.parseInt(request.getParameter("idx"));
			String writer = request.getParameter("writer");
			String memo = request.getParameter("memo");
			
			MemoDTO dto = new MemoDTO();
			dto.setIdx(idx);
			dto.setWriter(writer);
			dto.setMemo(memo);
			
			// dao 에 db 수정처리 요청
			dao.updateMemo(dto);
			// 페이지 이동 : 웹 페이지 적용하는 방식
			/* response.sendRedirect("/WebTest/memo/memo.jsp"); */
			response.sendRedirect(request.getContextPath()+"/memo/memo.jsp");
			
		}
		
		else if(url.contains("delete.do")) {
			System.out.println("delete.do 처리중...");
			
			int idx = Integer.parseInt(request.getParameter("idx"));
			
			// db 서비스 요청 : 삭제
			dao.deleteMemo(idx);
			
			response.sendRedirect(request.getContextPath()+"/memo/memo.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 요청");
		doGet(request, response);
	}

}
