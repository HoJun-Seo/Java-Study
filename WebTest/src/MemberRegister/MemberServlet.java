package MemberRegister;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberRegister.dao.MemberAccess;
import MemberRegister.dto.MemberData;


@WebServlet("/MemberRegister/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberAccess dao = new MemberAccess();
		
		String command = request.getParameter("command");
		
		if(command.equals("LoginMember") && command != null) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			String result = dao.findMember(id,pwd);
			
			request.setAttribute("result", result);
			String page = "/MemberRegisterView/LoginResult.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		else if(command.equals("addMember") && command != null) {
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String RRN1 = request.getParameter("input1");
			String RRN2 = request.getParameter("input2");
			
			String RRN = RRN1+RRN2;
			
			MemberData md = new MemberData();
			md.setId(id);
			md.setPassword(pwd);
			md.setName(name);
			md.setRegister_number(RRN);
			
			dao.addMember(md);
			String page = "/WebTest/MemberRegisterView/MemberLoginForm.html";
			response.sendRedirect(page);
		}
		else if(command.equals("Agreement") && command != null) {
			String page = "/MemberRegisterView/CreateForm.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
