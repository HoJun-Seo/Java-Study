package System;
/*
 * System class 의 currentTimeMillis method 는 시스템 시계로부터 현재 시각을 읽어오는 메소드이다.
 * 이 메소드는 시스템 시계로부터 현재 시각을 읽어서 밀리세컨드 단위로 리턴하는 메소드이다.
 * 이 메소드의 리턴값은 long 타입이기 때문에 아래와 같은 방법으로 호출할 수 있다.
 * long time = System.currentTimeMillis(); - 시스템 시계로부터 현재 시각을 읽어오는 메소드
 * 이 메소드는 앞에서 공부했던 Calendar, GregorianCalendar class 와는 달리 시스템 시각을 그대로 리턴하기 때문에
 * 날짜와 시간 표시에는 거의 사용되지 않고, 프로그램의 실행 시간 측정에 주로 사용된다.
 */
public class SystemExample11 {
	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();//현재 시각 측정
		double total = 0.0;
		for(int cnt = 1; cnt < 1000000000; cnt += 2)
			if(cnt / 2 % 2 == 0)
				total += 1.0 / cnt;
			else 
				total -= 1.0 / cnt;
		double pi = total * 4;
		//원주율 pi 의 근사값을 계산
		long time2 = System.currentTimeMillis(); //현재 시간 측정
		System.out.println("result = " + pi);
		System.out.printf("계산에 %d ms 가 소요되었습니다.", time2 - time1); //두 시각의 차를 출력
	}
}
