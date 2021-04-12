package json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		System.out.println("요청 url: "+ url);
		
		String jsonInfo = request.getParameter("jsonInfo");
		
		// json데이터를 처리하기 위해 JSONParse객체를 생성
		JSONParser jsonParse = new JSONParser();
		try {
			// 전송된 JSOn데이터를 파싱시킴
			JSONObject jsonObject = (JSONObject) jsonParse.parse(jsonInfo);
			
			System.out.println("전송받은 회원정보\n");
			System.out.println("=========");
			System.out.println("이름:"+jsonObject.get("name"));
			System.out.println("나이:"+jsonObject.get("age"));
			System.out.println("성별:"+jsonObject.get("gender"));
			System.out.println("별명:"+jsonObject.get("nickname"));
			
			// 배열을 저장할 배열 객체 선언
			JSONObject totalObject = new JSONObject();
			// memberInfoJSON객체를 저장할 배열 선언
			JSONArray membersArray = new JSONArray();
			// 회원 정보가 저장될 JSON객체 선언
			JSONObject memberInfo = new JSONObject();
			
			memberInfo.put("name", "홍길동");
			memberInfo.put("age", "20");
			memberInfo.put("gender", "남자");
			memberInfo.put("nickname", "날쌘돌이");
			membersArray.add(memberInfo);// 배열에 회원정보 추가
			
			memberInfo.put("name", "홍길순");
			memberInfo.put("age", "25");
			memberInfo.put("gender", "여자");
			memberInfo.put("nickname", "날쌘순이");
			membersArray.add(memberInfo);// 배열에 회원정보 추가
			
			// memeber라는 name으로 memberArray를 value로 저장
			totalObject.put("members", membersArray);
			
			// JSONObject를 문자열로 변환
			String jsonInfoStr = totalObject.toJSONString();
			System.out.println(jsonInfoStr);
			
			
			// 요청에 대한 응답
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			// JSON데이터를  브라우저로 전송
			writer.print(jsonInfoStr);
			
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}