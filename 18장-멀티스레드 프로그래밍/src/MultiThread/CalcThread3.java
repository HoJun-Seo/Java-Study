package MultiThread;

public class CalcThread3 extends Thread{
	SharedArea sharedArea;
	public void run() {
		double total = 0.0;
		for(int cnt = 1; cnt < 1000000000; cnt += 2)
			if(cnt / 2 % 2 == 0)
				total += 1.0 /cnt;
			else
				total -= 1.0 / cnt;
		sharedArea.result = total * 4;
		sharedArea.isReady = true;
		synchronized (sharedArea) {
			sharedArea.notifyAll(); //기다리고 있는 모든 스레드로 신호를 보낸다.
		}
	}
}
