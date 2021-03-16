package webTest.sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("init() 메소드 호출");
    }
    
    @Override
    public void destroy() {
    	System.out.println("destroy() 메소드 호출");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 메소드 호출");
		// 인코딩 제대로 안 하면 한글 다 깨져서 나온다.
		request.setCharacterEncoding("utf-8");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String nick = request.getParameter("nick"); 
		
		System.out.println("아이디 : " + user_id);
		System.out.println("비밀번호 : " + user_pw);
		System.out.println("닉네임 : " + nick);
		
		String[] subject = request.getParameterValues("subject");
		for(String str : subject) {
			System.out.println("선택한 과목 : " + str);
		}
		
		System.out.println("-----");
		
		Enumeration<String> enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String[] values = request.getParameterValues(name);
			for(String value : values) {
				System.out.println("name = " + name + ", value = " + value);
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 메소드 호출");
		doGet(request, response);
	}

}
