package Basic_class;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarExample2 {
	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar(); //파라미터 없는 생성자를 이용해 객체 생성
		TimeZone timeZone = TimeZone.getTimeZone("Europe/London"); //원하는 시간대를 timeZone 객체에 전달
		calendar.setTimeZone(timeZone); //해당 객체를 현재 시간대로 지정
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		int amPm = calendar.get(Calendar.AM_PM);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		String sAmPm = amPm == Calendar.AM ? "오전" : "오후";
		System.out.printf("%d년 %d월 %d일 %s %d시 %d분 %d초", year, month, date, sAmPm, hour, min, sec);
	}
}
