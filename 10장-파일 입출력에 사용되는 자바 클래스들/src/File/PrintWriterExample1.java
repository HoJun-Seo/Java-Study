package File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
/*
 * 파일 출력 클래스 중 데이터를 보기 좋게 포맷해서 출력하는 기능이 있는 클래스 - PrintWriter, PrintStream
 * PrintStream - 문자 스트림과 바이트 스트림의 구분이 없었던 초기버전(보통은 PrintWriter class 를 사용하나 필요시 PrintStream class 를 사용할 수도 있음)
 * PrintWriter - 문자 스트림 용으로 새롭게 만들어진 클래스
 * PrintWriter class 사용 - 객체를 생성할 때 생성자 파라미터로 파일의 경로명을 넘겨주면 그 파일이 열리고 데이터를 출력 할 수 있는 상태가 된다.
 * 예) PrintWriter writer = new PrintWriter("output.txt");
 * 생성된 객체에 대해서는 print, println, printf method 를 호출하여 데이터를 출력 할 수 있다.
 * write method 와는 달리 데이터를 있는 그대로 출력하는 게 아니라 문자열로 바꾸거나 포맷해서 출력한다.
 * 예) writer.println(12); - "12" 라는 문자열을 출력, writer.println(10000L) - "10000" 이라는 문자열을 출력
 * printf method 에서는 포맷 명세자(format specifier) 가 사용되는데, 보통 파라미터 순서대로 치환되는 것이 기본이나
 * % 문자 다음에 파라미터 순번과 $ 표시를 쓰면 치환되는 순서를 바꿀 수 있다. - argument index
 * 예) writer.printf("%1$d 는 16진수로 %1$x.", 100); - "100 은 16진수로 64" 라는 문자열을 출력
 * argument index 는 날짜와 시간을 포맷할 때 특히 유용하다.
 * Calendar 타입의 객체가 표현하는 연, 월, 일 을 포맷하는 포맷 명세자는 각각 %tY, %tm, %td 인데 이 포맷 명세자에 argument index 를 지정하면
 * Calendar 객체 하나만 가지고도 연, 월, 일 을 모두 포맷할 수 있다.
 */
public class PrintWriterExample1 {
	public static void main(String[] args) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output3.txt");
			writer.println("	*** 성적표 ***		");
			writer.printf("%3s : %3d %3d %3d %5.1f \n", "김지영", 92, 87, 95, 91.3f);
			writer.printf("%3s : %3d %3d %3d %5.1f \n", "박현식", 100, 90, 88, 92.7f);
			writer.printf("%3s : %3d %3d %3d %5.1f \n", "최민재", 75, 88, 85, 82.7f);
			writer.printf("작성일자 : %1$tY년 %1$tm월 %1$td일", new GregorianCalendar());
		}
		catch(IOException ioe) {
			System.out.print("파일로 출력할 수 없습니다.");
		}
		finally {
			try {
				writer.close();
			}
			catch(Exception e) {
			}
		}
	}
}
