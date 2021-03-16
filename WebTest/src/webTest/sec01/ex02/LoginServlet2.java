package webTest.sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩 설정("utf-8")
		// config 패키지의 Encoding 클래스에서 따로 인코딩을 해준다.
//		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		
		// 웹 페이지 출력 : html, text, xml 등 형식
		// 자바 I/O 스트림 중 outputstream 생성
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "<html>";
		data += "<body>";
		data += "아이디 : " + id;
		data += "<br>";
		data += "비밀번호 : " + pw;
		data += "</body>";
		data += "</html>";
		
		System.out.println(data);
		
		// 화면(웹 페이지) 출력
		out.print(data);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		doGet(request, response);
	}

}
