package File;

import java.util.GregorianCalendar;
/*
 * 지금까지 사용해왔던 System.out.println, System.out.print, System.out.printf 메소드가 PrintStream class 의 사용 예
 * System class 에 속하는 필드인 out 은 PrintStream type 의 필드이다.
 * System.out.println 과 같은 method 릐 사용방법을 자세히 알고 싶다면 PrintStream class 의 api 규격서를 찾아보면 된다.
 */
public class PrintStreamExample1 {
	public static void main(String[] args) {
		System.out.println("	*** 성적표 ***		");
		System.out.printf("%3s : %3d %3d %3d %5.1f \n", "김지영", 92, 87, 95, 91.3f);
		System.out.printf("%3s : %3d %3d %3d %5.1f \n", "박현식", 100, 90, 88, 92.7f);
		System.out.printf("%3s : %3d %3d %3d %5.1f \n", "최민재", 75, 88, 85, 82.7f);
		System.out.printf("작성일자 : %1$tY년 %1$tm월 %1$td일", new GregorianCalendar());
	}
}
