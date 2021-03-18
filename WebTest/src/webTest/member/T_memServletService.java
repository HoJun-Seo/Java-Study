package webTest.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webTest.member.dao.T_memDAO;
import webTest.member.dto.T_mem;

/**
 * Servlet implementation class T_memServletService
 */
@WebServlet("/webTest/T_memService")
public class T_memServletService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// db 처리는 객체(모델)
		T_memDAO dao = new T_memDAO();
		
		// 공통된 기능 (회원정보 전체 조회)
		
		// command 인자 값 따라서 작업구분(입력, 삭제, 수정...)
		String command = request.getParameter("command");
		if(command == null) command = "작업구분 코드 0";
		System.out.println("작업구분 플러그 : " + command );
						
		// 회원 가입 처리조건
		if(command.equals("addMember") && command != null) {
			System.out.println("회원가입 요청입니다.");
							
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
							
			System.out.println("넘어온 id : " + id);
			System.out.println("넘어온 pwd : " + pwd);
			System.out.println("넘어온 name : " + name);
			System.out.println("넘어온 email : " + email);
							
			// 인자값을 DTO(vo) 에 저장
			T_mem vo = new T_mem();
			vo.setId(id);
			vo.setName(name);
			vo.setPwd(pwd);
			vo.setEmail(email);
							
			// db 에 입력하는 메소드 호출
			dao.addMember(vo);
		} else if(command.equals("delMember") && command != null) {
			System.out.println("==> 삭제 작업요청 입니다.");
					
			String id = request.getParameter("id");
			// id 를 값으로 db 삭제 요청
			dao.delMember(id);
		} else if(command.equals("updateMember") && command != null) {
			System.out.println("수정 작업 요청");
			
			String id = request.getParameter("id");
			T_mem idVo = dao.findMember(id);
			
			request.setAttribute("member", idVo);
			
			String page = "/view/t_memberModifyForm.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			
		} else if(command.equals("updateOKMember") && command != null) {
			System.out.println("수정 완료 요청");
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			T_mem memberVo = new T_mem();
			memberVo.setId(id);
			memberVo.setPwd(pwd);
			memberVo.setName(name);
			memberVo.setEmail(email);
			
			dao.updateOKMember(memberVo);
		} else if(command.equals("LoginMember") && command != null) {
			System.out.println("로그인 요청");
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			boolean success = dao.loginMember(id, pwd);
			if(success == true) System.out.println("로그인 성공");
			else {
				System.out.println("로그인 실패, 회원가입 페이지로 이동합니다.");
				String page = "/WebTest/view/t_memberForm.html";
				response.sendRedirect(page);
			}
			
		}
		
		
		
		List<T_mem> list = dao.listMembers();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><style>"
				+ "button{"
				+ "margin: 15px 32px;"
				+ "}"
				+ "</style></head><body>");
		out.print("<h2>회원정보</h2>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td width='100'>아이디</td><td width='100'>비밀번호</td><td width='100'>이름</td><td width='200'>이메일</td><td width='100'>가입일</td>");
		out.print("<td width='50'>삭제</td>");
		out.print("<td width='50'>수정</td>");
		
		for(T_mem memberVO : list) {
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			out.print(
					"<tr><td>" + id + "</td>" +
					"<td>" + pwd + "</td>" +
					"<td>" + name + "</td>" +
					"<td>" + email + "</td>" +
					"<td>" + joinDate + "</td>" +
					"<td><a href='/WebTest/webTest/T_memService?command=delMember&id="+id+"'>삭제</a></td>" +
					"<td><a href='/WebTest/webTest/T_memService?command=updateMember&id="+id+"'>수정</a></td></tr>"
					);
			
		}
		out.print("</table>");
		out.print("<a href='/WebTest/view/t_memberForm.html'>회원가입</a>");
		out.print("<button type=\"button\" onclick=\"location.href='/WebTest/view/LoginForm.html'\">로그인</button>");
		out.print("</body></html>");
		
		out.flush();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
