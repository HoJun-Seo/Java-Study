package common;


import javax.servlet.http.Cookie;

public class UtilityCookie {
	
	// 쿠키 배열에서 쿠키 찾는 함수
	// 객체 생성없이 클래스 이름으로 메소드 접근
	public static String getCookie(Cookie[] cookies, String name) {
		String result = ""; // 검색 결과값 보관
		
		String statue = "false";
		if(cookies != null) {
			for(int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals(name)) {
					result = cookies[i].getValue();
					statue = "true";
				}
			}
		}
		System.out.println("statue : " + statue);
		if(statue.equals("false")) {
			return "0";
		} else {
			return result;	
		}
		
	}
}
