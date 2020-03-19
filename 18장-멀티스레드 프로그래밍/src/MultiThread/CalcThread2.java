package MultiThread;

public class CalcThread2 extends Thread{
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
			sharedArea.notify(); //동기화 블록 내에서 notify method 호출, 기다리고 있는 스레드 에게 신호를 보낸다.
		}
	}
}
