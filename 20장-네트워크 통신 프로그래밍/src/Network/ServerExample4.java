package Network;

import java.net.ServerSocket;
import java.net.Socket;
/*
 * 여러 클라이언트와 동시에 통신하는 서버 프로그램
 * 서버 소켓은 한 클라이언트와 연결을 맺고 있는 동안 다른 클라이언트로부터 연결 요청이 들어오면 또 다른 연결을 맺을 수 있다. - 여러 명이 참여하는 채팅 프로그램
 * 여러 명이 참여하는 채팅 프로그램에서는 사용자들이 각각 클라이언트 프로그램을 하나씩 가지고 채팅에 참여하고, 서버 프로그램은 클라이언트로부터 받은 메시지를 모든 사용자에게 다시 보내는 역할만 한다.
 * 서버 프로그램에서 서버 소켓을 통해 클라이언트 프로그램과 맺은 연결을 가지고 새로운 스레드를 시작하고, 서버 소켓은 다시 다른 연결 요청이 들어오기를 기다린다.
 * 1) 스레드의 시작 -> 2) 서버 소켓을 생성한다. -> 3) 연결 요청이 들어오면 소켓을 생성한다. -> 4) 소켓을 가지고 새 스레드를 시작한다.(3-4반복)
 * 4 --> 5) 스레드의 시작 -> 6) 한 클라이언트로부터 메시지를 수신한다.(연결이 끊어지면 8로 이동) -> 7) 모든 클라이언트로 메시지를 송신한다.(6-7반복) -> 8) 소켓을 닫는다. -> 9) 스레드의 끝
 * 위 흐름의 5번째 부터 생성되는 스레드는 하나만 존재하는 것이 아니라 클라이언트 프로그램으로부터 연결 요청이 올 때마다 하나씩 생성되어서, 서버 프로그램이 동시에 여러 클라이언트 프로그램과 통신을 할 수 있게 된다.
 */
public class ServerExample4 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9002); //서버 소켓을 생성한다.
			while(true) {
				Socket socket = serverSocket.accept(); //클라이언트로부터 연결 요청이 오면 소켓을 생성한다.
				//생성된 소켓을 가지고 새로운 스레드를 생성해서 시작한다.
				Thread thread = new PerClientThread(socket);
				thread.start();
				//생성된 소켓을 가지고 새로운 스레드를 생성해서 시작한다.
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
