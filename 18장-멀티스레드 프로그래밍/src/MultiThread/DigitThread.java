package MultiThread;

public class DigitThread extends Thread{
	public void run() {
		for(int cnt = 0; cnt < 10; cnt++) {
			System.out.println(cnt);
		}
	}
}
