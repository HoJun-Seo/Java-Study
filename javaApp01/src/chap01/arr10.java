package chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arr10 {

	public static void main(String[] args) {
		// 타입 추론
		
		var a1 = 200;
		var b2 = 12.456;
		
		var students = new String[] {
				"스노우화이트", "멀린", "레지나", "애버러지", "잭", "아더", "한스"
		};
		
		System.out.println(Arrays.toString(students));
		
		List<String> student3 = new ArrayList<String>();
		student3.add("홍길동");
		student3.add("홍길순");
		student3.add("동순이");
		
		List<String> students4 = Arrays.asList("서울", "부산", "대구", "광주", "창원");
		
		System.out.println("students3 : " + student3);
		System.out.println("students4 : " + students4);
	}

}
