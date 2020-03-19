package MultiThread;
/*
 * 대기하고 있는 모든 스레드로 신호를 보내는 notifyAll method
 * 때로는 한 스레드가 여러 스레드로 한꺼번에 신호를 보내야하는 경우도 있다, 그럴때는 notify method 대신에 notifyAll method 를 사용한다.
 * notifyAll method 는 같은 객체에 대해 호출된 모든 wait method 로 신호를 보내는 메소드이다. -> obj.notifyAll(); : wait 하고 있는 모든 스레드에게 신호를 보내는 메소드 
 */
public class MultiThreadExample8{
	public static void main(String[] args) {
		CalcThread3 thread1 = new CalcThread3();
		PrintThread3 thread2 = new PrintThread3();
		SimplePrintThread thread3 = new SimplePrintThread();
		LuxuryPrintThread thread4 = new LuxuryPrintThread();
		MonitorThread thread5 = new MonitorThread(thread1); //모니터링 스레드 생성 - thread1 스레드의 상태를 모니터링 한다.
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		thread3.sharedArea = obj;
		thread4.sharedArea = obj;
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
