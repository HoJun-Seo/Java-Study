package threadChap01;

public class ThreadTest01 {

	public static void main(String[] args) {
		System.out.println("main 쓰레드");
		System.out.println("main 쓰레드");
		
		System.out.println("main: "+ Thread.currentThread().getName());
		System.out.println("-----");
		
		ThreadExtend t1 = new ThreadExtend();
		
		Runnable r1 = new RunnableImple();
		Thread t2 = new Thread(r1);
		
		// start()메서드를 통해 run()메서드를 호출함.
		t1.start();
		t2.start();
		
		System.out.println("-----");
		System.out.println("main: "+ Thread.currentThread().getName());

	}

}


// Thread클래스로 부터 상속을 받는 방법
class ThreadExtend extends  Thread{
	public void run() {
		System.out.println("Thread 상속");
		for (int i=0; i<10; i++) {
			System.out.println("Thread Extend : "+i+"name : "+Thread.currentThread().getName());
			// 쓰레드가 수행하는 동안 1초동안 잠시 중단 시킴
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
// Runnable인터페이스 구현하는 방법
class RunnableImple  implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable 구현");
		for (int i=0; i<10; i++) {
			System.out.println("Runnable implements : "+i+"name : "+Thread.currentThread().getName());
			// 쓰레드가 수행하는 동안 1초동안 잠시 중단 시킴
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}



/*
프로세스 : 실행중인 프로그램을 의미
모든 프로세스안에는 작업을 수행하는 스레드 단위가  존재함.

하나의 프로세스는 여러개의 스레드를 가질 수 있음.
멀티 스레드 장점.
cpu, 메모리를 효율적으로 사용
사용자에 대한 응답성이 높음
작업을 스레드 단위로 분리해서 실행시간을 줄일 수 있다.
  
  
  1.방법 -> Thread 클래스 상속
  2.방법 -> Runnable 인터페이스 구현
 */