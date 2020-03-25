package Network;

import java.net.ServerSocket;
import java.net.Socket;
/*
 * 송신과 수신을 동시에 하는 프로그램
 * 멀티 스레드 기술을 이용하면 송신과 수신을 동시에 하는 프로그램을 작성 할 수 있다. - 일대일 채팅 프로그램
 * 한 쪽은 클라이언트 프로그램을 사용해서 참여하고, 다른 한 쪽은 서버 프로그램을 사용해서 참여해야 한다.
 * 클라이언트/서버 프로그램 에서는 각각 키보드로부터 입력 받은 문자열을 상대방에게 송신하는 일과, 상대방으로부터 수신된 문자열을 모니터로 출력하는 일을 동시에 해야 한다.
 * 다시 말해, 클라이언트 프로그램과 서버 프로그램은 각각 아래와 같은 두 개의 스레드가 있어야 한다.
 * 1) 스레드 시작 -> 2) 키보드 입력을 기다린다("bye" 입력 시 4로 이동) -> 3) 입력된 문자열을 송신한다.(2-3 반복) -> 4) 소켓을 닫는다. -> 5) 스레드의 끝
 * 1) 스레드 시작 -> 2) 메시지를 수신한다.(연결이 끊기면 4로 이동) -> 3) 수신된 메시지를 출력한다.(2-3 반복) -> 4) 스레드의 끝
 */
public class ServerExample3 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9001);
			socket = serverSocket.accept();
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				serverSocket.close();
			}
			catch(Exception ignored) {
			}
		}
	}
}
