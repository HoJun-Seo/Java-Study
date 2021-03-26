package survey;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.dao.SurveyDAO;
import survey.dto.SurveyDTO;
import survey.dto.SurveyResultDTO;
import survey.dto.SurveySummerDTO;


@WebServlet("/survey_servlet/*")
public class SurveyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI().toString();
		System.out.println("클라이언트 요청 : " + url);
		
		SurveyDAO dao = new SurveyDAO();
		
		if(url.contains("input.do")) {
			System.out.println("-- input.do 처리중... --");
			
			/* int survey_idx = Integer.parseInt(request.getParameter("survey_idx")); */ 
			//SurveyDTO dto = dao.viewQuestion(1);			
			//request.setAttribute("dto", dto);
			List<SurveyDTO> list = dao.viewAllQuestion();
			
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/survey/survey_input.jsp");
			rd.forward(request, response);
		} 
		else if(url.contains("insert.do")) {
			System.out.println("--- insert.do 처리중... ---");
			int num = Integer.parseInt(request.getParameter("num"));
			int survey_idx = Integer.parseInt(request.getParameter("survey_idx"));
			
			System.out.println("survey_idx : " + survey_idx + ", num : " + num);
			
			SurveyResultDTO dto = new SurveyResultDTO();
			dto.setSurvey_idx(survey_idx);
			dto.setNum(num);
			
			dao.insertSurvey(dto);
			response.sendRedirect(request.getContextPath()+"/survey/input_result.jsp");
		}
		else if(url.contains("survey_result.do")) {
			System.out.println("-- survey_result.do 처리중 --");
			int survey_idx = Integer.parseInt(request.getParameter("survey_idx"));
			System.out.println("survey_idx : " + survey_idx);
			
			List<SurveySummerDTO> items = dao.listSummary(survey_idx);
			request.setAttribute("list", items);
			System.out.println("");
			
			RequestDispatcher rd = request.getRequestDispatcher("/survey/survey_result.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
