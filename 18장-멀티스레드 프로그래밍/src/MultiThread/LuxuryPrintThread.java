package MultiThread;
//파이를 예쁘게 출력하는 스레드 클래스
public class LuxuryPrintThread extends Thread{
	SharedArea sharedArea;
	public void run() {
		if(sharedArea.isReady != true) {
			synchronized (sharedArea) {
				try {
					sharedArea.wait();
				}
				catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		System.out.println("*** pi = " + sharedArea.result + " ***");
	}
}
