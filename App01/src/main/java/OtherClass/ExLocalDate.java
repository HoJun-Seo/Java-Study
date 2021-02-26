package OtherClass;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExLocalDate {
	public static void main(String[] args) {
		
		LocalDate date1 = LocalDate.now();
		System.out.println(date1);
		
		LocalDate date2 = LocalDate.parse("1945-08-05");
		System.out.println(date2);
		
		System.out.printf("%s는 %s", date1.getYear(), date1.isLeapYear() ? "윤년" : "평년");
		System.out.println("3일 후 : " + date1.plusDays(3));
		System.out.println("3일 전 : " + date1.minusDays(3));
		System.out.println("1년 후 : " + date1.plusDays(1));
		
		System.out.println("-- LocalTime --");
		LocalTime time1 = LocalTime.now();
		System.out.println(time1);
		
		System.out.println("시간 : " + time1.getHour());
		System.out.println("분 : " + time1.getMinute());
		System.out.println("초 : " + time1.getSecond());
		
		System.out.println("현재 : " + time1 + ", 100초 후 : " + time1.plusSeconds(120));
		System.out.println("현재 : " + time1 + ", 360초 후 : " + time1.plusMinutes(360));
		
		System.out.println("-- LocalTime 에서 ZondId 를 이용해서 지리적 기준으로 날짜와 시간을 출력");
	}
}
