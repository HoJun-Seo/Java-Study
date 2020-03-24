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
 * InputStreamReader class 는 입력된 바이트 스트림을 문자 스트림으로 바꿔주는 클래스이다. 이 클래스의 생성자에 소켓으로부터 얻은 InputStream 객체를 넘겨주면,
 * 네트워크로 수신된 데이터를 문자 스트림 형태로 읽을 수 있는 InputStreamReader 객체가 생성된다.
 * InputStreamReader reader = new InputStreamReader(in); - in : InputStream 객체
 * InputStreamReader class 의 사용방법은 FilReader class 와 똑같기 때문에, 이렇게 생성한 InputStreamReader 객체를 이용하면
 * 텍스트 파일로부터 데이터를 읽듯이 네트워크로 수신된 데이터를 읽을 수 있다. 
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
/*
 * 문자 스트림을 바이트 스트림으로 바꾸는 대표적인 클래스로는 OutputStreamWriter class 가 있다.
 * 하지만 출력하는 데이터가 주로 문자열일 경우에는 PrintWriter class 를 사용하는 것이 더 편리하다., PrintWriter class 에는 파라미터로 문자열을 직접 넘겨줄수 있는 println, print, printf 등의 메소드가 있기 때문이다.
 * PrintWriter class 를 이용하여 문자 스트림을 바이트 스트림으로 바꾸어서 출력하기 위해서는 이 클래스의 생성자에 OutputStream 타입의 객체를 파라미터로 넘겨줘야 한다.
 * 그러니까 이 경우에는 소켓으로부터 얻은 OutputStream 객체를 생성자 파라미터로 넘겨주면 된다.
 * PrintWriter writer = new PrintWriter(out); - out : OutputStream 객체
 * 이렇게 생성한 PrintWriter 객체를 가지고 println, print, printf method 를 호출하면 파라미터로 넘겨준 문자열이 바이트 스트림으로 변환되어 네트워크로 전송된다.
 */
