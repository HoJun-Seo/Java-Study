package webTest.sec01.ex02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webTest.sec01.dto.WonCalc;

/**
 * Servlet implementation class WonCalcServlet
 */
@WebServlet("/calc/calc.do")
public class WonCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static float USD_RATE = 1131.76F;
	private static float JYP_RATE = 10.36F;
	private static float CNY_RATE = 174.11F;
	private static float GBP_RATE = 1564.75F;
	private static float EUR_RATE = 1348.63F;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
	@Override
	public void destroy() {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		// 1. 클라이언트로 부터 넘어온 자료를 변수(객체)에 저장
		float won = Float.parseFloat(request.getParameter("won"));
		String op = request.getParameter("operator");
		
		System.out.println("원 : " + won);
		System.out.println("변환 : " + op);
		
		// 2. 계산 처리
		WonCalc calc = new WonCalc();
		String result = calc.calculate(won, op);
		// 3. 계산 결과를 저장
		request.setAttribute("result", result);
		request.setAttribute("won", won);
		// 4. 출력 화면에 전송
		String page = "/view/WonConvertResult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/*
	private static String calculate(float won, String op) {
		String result = "";
		if(op.equals("dollar")) {
			result = String.format("%.6f", won/USD_RATE);
		} else if(op.equals("en")) {
			result = String.format("%.6f", won/JYP_RATE);
		} else if(op.equals("wian")) {
			result = String.format("%.6f", won/CNY_RATE);
		} else if(op.equals("pound")) {
			result = String.format("%.6f", won/GBP_RATE);
		} else if(op.equals("euro")) {
			result = String.format("%.6f", won/EUR_RATE);
		}
		return result;
	} */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
