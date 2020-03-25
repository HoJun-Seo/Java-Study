package Network;

import java.net.Socket;

public class ClientExample4 {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage : java ClientExmaple4v <user-name>");
			return;
			//이 프로그램은 명령행 파라미터로 대화명을 입력받는다.
		}
		try {
			Socket socket = new Socket("211.208.104.225", 9002); //서버와 연결을 맺는다.
			//메시지 송신 스레드와 메시지 수신 스레드를 생성해서 시작한다.
			Thread thread1 = new SenderThread2(socket, args[0]);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
