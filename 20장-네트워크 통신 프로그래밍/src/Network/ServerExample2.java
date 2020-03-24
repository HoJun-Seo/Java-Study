package Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * TCP/IP 프로토콜에서는 데이터 전송의 기본 단위가 바이트이기 때문에, 문자 데이터를 전송하기 위해서는 송신할 문자를 바이트 타입으로 바꾸고
 * 수신된 바이트를 문자 타입으로 바꾸는 과정이 필요하다. - ServerExample1, ClientExample1 에서는 그런일을 String class 의 getBytes method 와 생성자를 이용해서 하고 있다.
 * 하지만 위의 프로그램 보다 복잡한 프로그램에서는 이런 로직을 직접 구사하는 것보다는 바이트 스트림을 문자 스트림으로 바꾸고, 문자 스트림을 바이트 스트림으로 바꾸는 기능의 입출력 클래스를 사용하는 것이 좋다.
 * 그런 기능을 하는 대표적인 클래스로는 jdk 라이브러리의 java.io.InputStreamReader class 와 java.io.OutputStreamWriter class 가 있다.
 */
public class ServerExample2 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			//수신된 데이터를 출력한다.
			String str = reader.readLine();
			System.out.println(str);
			//수신된 데이터를 출력한다.
			//데이터를 송신한다.
			writer.println("Hello, client");
			writer.flush();
			//데이터를 송신한다.
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch(Exception ignored) {
			}
			try {
				serverSocket.close();
			}
			catch(Exception ignored) {
			}
		}
	}
}
