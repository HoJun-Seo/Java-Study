package MultiThread;
//파이를 소수점 두 자리까지 출력하는 클래스
public class SimplePrintThread extends Thread{
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
		System.out.printf("%.2f \n", sharedArea.result);
	}
}
