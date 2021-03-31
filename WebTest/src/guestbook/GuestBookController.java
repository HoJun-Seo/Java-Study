package guestbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestBookDAO;
import guestbook.dto.GuestBookDTO;


@WebServlet("/guestbook_servlet/*")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		System.out.println("요청 url : " + url);
		
		//db 처리하는 객체 생성 : dao 객체
		GuestBookDAO dao = new GuestBookDAO();
		
		if(url.contains("list.do")) {
			// 방명록 리스트를 받음
			List<GuestBookDTO> items = dao.getList();
			
			// view 페이지에서 출력할 자료 보관
			request.setAttribute("list", items);
			
			// view 페이지 이동
			String page = "/guestbook/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		else if(url.contains("insert.do")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			String content = request.getParameter("content");
			
			GuestBookDTO dto = new GuestBookDTO(name, email, passwd, content);
			dao.setInsert(dto);
			
			response.sendRedirect(request.getContextPath()+"/guestbook_servlet/list.do");
		}
		else if(url.contains("passwd_check.do")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			String passwd = request.getParameter("passwd");
			System.out.println("idx : " + idx + ", passwd : " + passwd);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("idx", idx);
			map.put("passwd", passwd);
			
			boolean result = dao.passwdCheck(map);
			
			String page ="";
			if(result) {
				GuestBookDTO dto = new GuestBookDTO();
				// 수정 페이지에 적용될 자료를 얻어옴
				dto = dao.gbDetail(idx);
				
				request.setAttribute("dto", dto);
				page = "/guestbook/edit.jsp";
				
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			} else {
				page = request.getContextPath()+"/guestbook_servlet/list.do";
				response.sendRedirect(page);
			}
		}
		else if(url.contains("update.do")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			String content = request.getParameter("content");
			
			GuestBookDTO dto = new GuestBookDTO(name, email, passwd, content);
			dto.setIdx(idx);
			
			dao.gbUpdate(dto);
			
			String page = "/guestbook_servlet/list.do";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		else if(url.contains("delete.do")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			dao.gbDelete(idx);
			System.out.println("idx : " + idx);
			
			String page = "/guestbook_servlet/list.do";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		else if(url.contains("search.do")) {
			// 검색 옵션
			String searchkey = request.getParameter("searchkey");
			// 검색 키워드
			String search = request.getParameter("search");
			System.out.println("검색옵션 : " + searchkey + ", 검색 키워드 : " + search);
			
			List<GuestBookDTO> items = dao.searchList(searchkey, search);
			
			request.setAttribute("list", items);
			request.setAttribute("searchkey", searchkey);
			request.setAttribute("search", search);
			
			String page = "/guestbook/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
