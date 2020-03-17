package MultiThread;

public class MultiThreadExample2 {
	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new DigitThread();
		Thread thread3 = new AlphabetThread();
		//3개의 스레드를 만들어서 시작한다.
		thread1.start();
		thread2.start();
		thread3.start();
		//주의 : 하나의 스레드 객체레 대해 start method 를 두 번 호출해서는 안된다. - 스레드 객체는 생성되고 나서 딱 한번만 사용할 수 있기 때문
		//하나의 스레드 객체에 대해 start method 를 두 번 호출 한다면 java.lang.llegalThreadStateException 을 발생한다. 
	}
}
