package webTest.sec01.ex02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("웹 페이지 시작");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student01 = new Student();
		student01.setName(request.getParameter("name"));
		student01.setKorean(Integer.parseInt(request.getParameter("korean")));
		student01.setEnglish(Integer.parseInt(request.getParameter("english")));
		student01.setMath(Integer.parseInt(request.getParameter("math")));
		
		int total = student01.getKorean() + student01.getEnglish() +
				student01.getMath();
		
		double average = total/3;
		
		request.setAttribute("name", student01.getName());
		request.setAttribute("total", total);
		request.setAttribute("average", average);
		
		// 
		String page = "student_result.jsp";
		// 페이지 전환(출력 페이지) => RequestDispatcher(페이지 분석)
		RequestDispatcher rd = request.getRequestDispatcher(page);
		// 페이지 이동
		rd.forward(request, response);
	}

}
