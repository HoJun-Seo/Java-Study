package MultiThread;

public class PrintThread3 extends Thread{
	SharedArea sharedArea;
	public void run() {
		if(sharedArea.isReady != true) {
			try {
				synchronized (sharedArea) {
					sharedArea.wait(); //동기화 블록 내에서 wait method 호출, 다른 스레드에서 신호가 올 때 까지 기다린다.
				}
			}
			catch(InterruptedException e) { //wait method 가 발생하는 익셉션을 처리한다.
				System.out.println(e.getMessage());
			}
		}
		System.out.println(sharedArea.result);
	}
}
