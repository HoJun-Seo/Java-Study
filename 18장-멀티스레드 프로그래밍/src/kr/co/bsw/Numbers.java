package kr.co.bsw;

import kr.co.asw.NumbersRunnable;
/*
 * 반드시 Runnable interface 를 이용하여 멀티 스레드 프로그램을 구현해야 하는 경우
 * list method 앞에 붙어있는 protected 키워드는 해당 메소드를 같은 패키지 안에서는 자유로이 호출할 수 있지만, 다른 패키지에서는 서브 클래스 안에서만 호출 할 수 있게 만든다.
 * 그런데 메인 스레드가 실행 시켜야 할 멀티 스레드가 다른 패키지에 속해 있는데, 해당 스레드에서 protected 키워드가 붙어있는 메소드를 호출할 경우,
 * 멀티 스레드가 실행되는 클래스는 메인 스레드가 실행되는 클래스의 서브클래스로 선언해야 한다.
 * 이 경우에는 자바에서는 다중 상속을 허용하지 않기 때문에 Thread class 를 상속받을수 없으므로, 반드시 Runnable interface 를 사용해야 한다.
 */
public class Numbers {
	public static void main(String[] args) {
		Thread thread = new Thread(new NumbersRunnable());
		thread.start();
	}
	protected void list(int start, int end) {
		for(int cnt = start; cnt <= end; cnt++) {
			System.out.printf("(%d)", cnt);
		}
	}
}
