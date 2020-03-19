package MultiThread;

public class MultiThreadExample8{
	public static void main(String[] args) {
		CalcThread3 thread1 = new CalcThread3();
		PrintThread3 thread2 = new PrintThread3();
		SimplePrintThread thread3 = new SimplePrintThread();
		LuxuryPrintThread thread4 = new LuxuryPrintThread();
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		thread3.sharedArea = obj;
		thread4.sharedArea = obj;
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
