package Basic_class;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateFormatExample2 {
	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		//Date class 는 구 버전의 클래스라서 시간대에 관한 정보를 저장할 수 없다.
		//그렇기 때문에 Calendar 객체로부터 Date 객체를 만드는 과정에서 Calendar 객체가 가지고 있던 시간대에 정보가 손실된다.
		//이런 문제점을 보완하려면 SimpleDateFormat class의 setTimeZone method 를 이용해서 시간대를 다시 설정해야 한다.
		String str = dateFormat.format(calendar.getTime());
		System.out.println(str);
	}
}
