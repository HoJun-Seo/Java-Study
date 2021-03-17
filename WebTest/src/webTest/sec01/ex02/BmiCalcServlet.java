package webTest.sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webTest.sec01.dto.BmiCalc;


@WebServlet("/bmi/bmi.do")
public class BmiCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		
		System.out.println("이름 : " + name);
		System.out.println("키 : " + height);
		System.out.println("체중 : " + weight);
		
		// BMI 지수 계산식 : 체중 / ((신장 / 100) * (신장 / 100))
		DecimalFormat df = new DecimalFormat("##0.00");
		BmiCalc bmicalc = new BmiCalc(name, height, weight);
		double bmi = bmicalc.bmiCalcProcess();
		
		String result = bmicalc.getResult();
		
		// request 객체 데이터 보관
//		request.setAttribute("name", name);
//		request.setAttribute("height", height);
//		request.setAttribute("weight", weight);
//		request.setAttribute("result", result);
//		request.setAttribute("bmi", df.format(bmi));
		
		// 화면으로 전송
//		String page = "/view/bmi_result.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher(page);
//		rd.forward(request, response);
		
		// ajax 비동기 처리에 대한 응답 처리
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(
					"<h2>BMI 지수 계산 결과</h2>" +
					"BMI : " + String.format("%.2f", bmi) + "<br>" +
					"<h2 style = 'color:red'> 결과 : " + result + "</h2>"
				);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
