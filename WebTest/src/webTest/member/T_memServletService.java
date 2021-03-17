package webTest.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// db 처리는 객체(모델)
		T_memDAO dao = new T_memDAO();
		List<T_mem> list = dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td width='100'>아이디</td><td width='100'>비밀번호</td><td width='100'>이름</td><td width='200'>이메일</td><td width='100'>가입일</td>");
		
		for(int i = 0; i < list.size(); i++) {
			T_mem memberVO = (T_mem) list.get(i);
			
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
					"<td>" + joinDate + "</td></tr>"
					);
			
		}
		out.print("</table></body></html>");
//		for(T_mem vo : list) {
//			
//		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
