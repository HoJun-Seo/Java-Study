package OtherClass;

import java.util.Calendar;

public class ExCalendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		System.out.println("년도 : " + cal.get(cal.YEAR));
		System.out.println("월 : " + (cal.get(cal.MONTH)+1));
		System.out.println("일 : " + cal.get(cal.DATE));
		
		System.out.println("연 기준 몇째주 : " + cal.get(cal.WEEK_OF_YEAR));
		System.out.println("월 기준 몇째주 : " + cal.get(cal.WEEK_OF_MONTH));
		
		System.out.println("일자 : " + cal.get(cal.DAY_OF_MONTH));
		System.out.println("연도 기준 날짜 : " + cal.get(cal.DAY_OF_YEAR));
		
		System.out.println("----");
		System.out.println("오전 오후 : " + cal.AM_PM);
		System.out.println("시 : " + cal.get(cal.HOUR)); 
		System.out.println("시(24) : " + cal.get(cal.HOUR_OF_DAY)); // 0 ~ 23
		System.out.println("분 : " + cal.get(cal.MINUTE));
		System.out.println("초 : " + cal.get(cal.SECOND));
	}

}
