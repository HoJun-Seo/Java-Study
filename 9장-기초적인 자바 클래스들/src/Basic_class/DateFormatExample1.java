package Basic_class;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DateFormatExample1 {
	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
		//SimpleDateFormat 객체를 생성한 후, 그 객체에 대해 format 메소드를 호출하여 날짜와 시간을 포맷한다.
		String str = dateFormat.format(calendar.getTime());
		//GregorianCalendar 객체를 Date 객체로 만들어서 format 메소드에 넘겨준다.
		System.out.println(str);
	}
}
