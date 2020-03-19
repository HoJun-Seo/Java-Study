package MultiThread;
/*
 * 스레드 간의 신호 전송 - 스레드는 공유 영역을 통해 데이터를 주고 받을 수 있을 뿐 만 아니라, 직접 신호를 주고 받을 수도 있다.
 * 스레드와 스레드가 신호를 주고받기 위해서는 notify method 와 wait method 를 사용해야 한다.
 * notify method 는 다른 스레드에게 신호를 보내는 메소드이고, wait method 는 그런 신호가 오기를 기다리는 메소드이다.
 * 두 메소드 모두 java.lang.Object class 에 속하며, 호출 방법은 obj.notify();, obj.wait(); 과 같다.
 * notify method 와 wait method 를 호출할 때, 두 메소드는 java.lang.Object class 에 선언되어 있기 때문에 어떤 객체에 서든 호출 할 수 있으나
 * 두 메소드를 같은 객체에 대해 호출해야만 서로 신호를 주고 받을 수 있다., 그렇기 때문에 이 객체는 신호를 주고받는 두 스레드가 공유 할 수 있는 객체여야 한다. 
 */
public class MultiExample7 {
	public static void main(String[] args) {
		CalcThread2 thread1 = new CalcThread2();
		PrintThread3 thread2 = new PrintThread3();
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		thread1.start();
		thread2.start();
	}
}
/*
 * notify method 와 wait method 는 다른 메소드 들 과는 달리 반드시 동기화 블록이나, 동기화 메소드 내에서 호출 되어야 한다.
 * 그리고 그 동기화는 메소드가 호출되는 객체에 대해 이루어져야 한다.
 */
