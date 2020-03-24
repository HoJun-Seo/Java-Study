package Network;

import java.net.Socket;

public class ClientExample3 {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("211.208.104.225", 9001);
			//두 스레드를 생성한다.
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			//두 스레드를 생성한다.
			//두 스레드를 시작한다.
			thread1.start();
			thread2.start();
			//두 스레드를 시작한다.
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
