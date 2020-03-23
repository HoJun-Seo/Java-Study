package Network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/*
 * 클라이언트 소켓을 생성하고 사용하는 방법
 * 클라이언트 프로그래에서는 Socket class 의 생성자를 이용해서 클라이언트 소켓을 직접 생성해 주어야 한다.
 * 이때 생성자 파라미터로는 서버 프로그램이 있는 컴퓨터의 IP주소와 포트 번호를 넘겨줘야 한다.
 * Socket socket = new Socket("219.153.21.14", 9000);
 * 이렇게 Socket class 의 생성자를 호출하면 이 생성자 안에서 서버 프로그램으로 연결 요청이 전송되고, 그 결과 클라이언트 프로그램과 서버 프로그램의 연결이 맺어지게 된다.
 * 클라이언트 프로그램과 서버 프로그램은 이렇게 소켓을 생성하는 방법은 다르지만, 일단 클라이언트 소켓이 생성되고 난 다음에 그 소켓을 가지고 데이터를 주고받는 방법은 동일하다.
 * 클라이언트 소켓을 가지고 데이터를 주고받기 위해서는 먼저 그 소켓에 대해 getInputStream method 와 getOutputStream method 를 호출해야 한다.
 * 이 메소드들은 각각 메시지의 수신과 송신에 사용할 입력 스트림과 출력 스트림 객체를 리턴한다.
 * InputStream in = socket.getInputStream(); - 데이터 수신에 사용할 입력 스트림 객체를 리턴하는 메소드
 * OutputStream out = socket.getOutputStream(); - 데이터 송신에 사용할 출력 스트림 객체를 리턴하는 메소드
 * 여기서 사용된 InputStream, OutputStream 타입은 모두 java.io 패키지에 속하는 클래스 이름이다.
 * 이 두 클래스의 객체를 이용하면 파일에 데이터를 읽고 쓸 때와 똑같은 방법으로 네트워크로 데이터를 수신하고 송신 할 수 있었다.
 * out.write(data); - 파라미터로 넘겨준 데이터를 송신한다. int data = in.read(); - 수신된 데이터를 읽어서 리턴한다.
 * 데이터의 전송을 모두 마친 다음엔 클라이언트 소켓을 닫아야 한다. 그 일은 close method 를 호출해서 할 수 있다.
 * socket.close(); - 소켓을 닫는 메소드  serverSocket.close(); - 서버 소켓을 닫는 메소드
 * 소켓을 사용하고 나서 닫지 않으면, 운영체제로부터 할당받은 포트 번호가 해제되지 않기 때문에 다른 프로그램이 그 포트 번호를 사용할 수 없는 상태로 남아있게 된다. 
 */
public class ClientExample1 {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("211.208.104.225", 9000); //소켓을 생성한다.
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			//데이터를 송신한다.
			String str = "Hello, server";
			out.write(str.getBytes());
			//데이터를 송신한다.
			//수신된 데이터를 출력한다.
			byte arr[] = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));
			//수신된 데이터를 출력한다.
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close(); //소켓을 닫는다.
			}
			catch(Exception e) {
			}
		}
	}
}
