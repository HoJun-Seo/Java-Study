package MultiThread;
/*
 * critical section
 * 멀티 스레드 프로그램에서 스레드 들이 번갈아 실행되는 스케쥴은 자바 가상 기계에 의해 임의로 정해진다.
 * 그렇기 때문에 때로는 적절치 못한 순간에 다른 스레드로 제어가 넘어가서 예기치 못한 문제가 발생 할 수 있다.
 * 이런 문제는 주로 공유 데이터를 사용하는 부분에서 일어나는데, 이런 부분을 critical section 이라고 부른다.
 * critical section 이 문제를 일으키지 않도록 하려면 그 부분이 실행되는 동안 다른 스레드가 공유 데이터를 사용 할 수 없도록 만들어야 하는데, 
 * 그렇게 하는 것을 critical section 의 동기화(synchronization) 이라고 한다.
 */
public class MultiThreadExample5 {
	public static void main(String[] args) {
		SharedArea2 area = new SharedArea2();
		area.account1 = new Account("111-111-1111", "이몽룡", 20000000);
		area.account2 = new Account("222-222-2222", "성춘향", 10000000);
		TransferThread thread1 = new TransferThread(area);
		PrintThread2 thread2 = new PrintThread2(area);
		thread1.start();
		thread2.start();
	}
}
/*
 * 멀티 스레드 프로그램에서 말하는 동기화는 공유 데이터 사용 중에 그 공유 데이터를 다른 스레드가 사용하지 못하도록 만드는 것을 의미한다.
 * 하지만 공유 데이터를 사용한다고 해서 항상 문제가 발생하는 것은 아니기 때문에 해당 프로그램에서와 같이 critical section 에 대해서만 동기화가 필요하다.
 * critical section 을 동기화 할 때는 synchronized 라는 키워드를 사용해야 한다.
 * synchronized (공유 객체){
 * 		- critical section -
 * }
 * 이렇게 키워드를 붙여서 블록으로 묶은 부분을 동기화 블록(synchronized block) 이라고 부른다.
 * 동기화 블록을 만들때는 위와 같이 공유 객체를 지정해야 하는데, 자바 가상 기계는 동기화 블록을 구분하기 위해 공유 객체를 사용한다.
 * 다시 말해서 자바 가상 기계는 같은 공유 객체에 대한 동기화 블록은 서로 중첩되지 않게 끔 스케쥴을 조정하지만, 다른 공유 객체에 대한 동기화 블록에 대해서는 그런 처리를 하지 않는다.
 */
