package pagination;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/page_servlet/*")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		System.out.println("클라이언트 요청 URL : " + url);
		
		if(url.contains("list.do")) {
			
			EmpDAO dao = new EmpDAO();
			// --- 페이지에 대한 레코드 범위 계산
			int curPage = 1; // 현재 페이지
			if(request.getParameter("curPage") != null) {
				curPage = Integer.parseInt(request.getParameter("curPage"));
			}
			// 전체 페이지 계산 : 1페이지 10개의 레코드
			int page_scale = 10; 
			
			// 총 레코드 개수 / 10 = 결과값에 자리올림
			// 991/10 = 99.1 => 99.1+1 => 자리올림(Math.ceil()) 시켜서 100개로 계산
			int totCount = dao.recordCount();
			int totPage = (int)Math.ceil((totCount)*1.0/page_scale); // 소수점 이하 있으면 자리 올림
			System.out.println("총 레코드 수 : " + totCount + ", 총 페이지 수 : " + totPage);
			
			// 레코드 시작 번호, 마지막 번호(페이지 별로 구분)
			int start = (curPage-1)*page_scale+1; //(1-1)*10+1 => 1
			int end = start+page_scale-1; 
			
			// ---- 페이지 블록 갯수 : 1 블럭에 표시할 페이지 수 계산
			// 1 블럭에 보여질 페이지 갯수(묶음) : ex) 1 블럭 10페이지 단위로 표시
			int block_scale = 10;
			// 블럭의 총 갯수 계산 : 전체 페이지 / 1 블럭에 보여질 페이지 수
			int tot_block = (int)Math.ceil(totPage*1.0/block_scale);
			
			//현재 페이지에 대한 블럭 범위의 계산
			int cur_block = (int)Math.ceil((curPage-1)/block_scale)+1;
			int block_start = (cur_block-1) * block_scale+1; // 블럭의 시작 페이지 번호
			int block_end = block_start + block_scale-1; // 블럭의 끝 페이지 번호
			
			// 페이지 블럭에서 이전, 다음 표시 여부 계산 : 첫 블럭에서 이전 표시 안함, 마지막 블럭에서는 다음 표시안함
			//현재 블럭의 마지막 번호가 전체 페이지 마지막 번호 보다 크면 현재 마지막 블럭 번호를 마지막 페이지 번호로 설정
			int prev_page = (cur_block-2) * block_scale + 1; // 이전 블럭 시작 페이지 계산
			int next_page = (cur_block * block_scale) + 1;
			
			System.out.println("이전 블럭 시작페이지 번호 : " + prev_page +
					", 현재 블럭 시작페이지 번호 : " + ((cur_block-1) * block_scale + 1));
			System.out.println("다음 블럭 시작페이지 번호 : " + next_page + 
					", 현재 블럭 시작페이지 번호 : " + ((cur_block-1) * block_scale + 1));
			
			// 리스트 조회 호출
			List<EmpDTO> list = dao.empList(start, end);
			
			// 페이지 네비게이션 관련 정보
			request.setAttribute("list", list);
			request.setAttribute("totPage", totPage);
			request.setAttribute("totBlock", tot_block);
			request.setAttribute("curBlock", cur_block);
			request.setAttribute("blockStart", block_start);
			request.setAttribute("blockEnd", block_end);
			request.setAttribute("prevPage", prev_page);
			request.setAttribute("nextPage", next_page);
			
			String page = "/pagination/list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
