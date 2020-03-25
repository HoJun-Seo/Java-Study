package Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * ArrayList class 는 리스트로 사용할 수 있는 클래스인데, 이 클래스의 객체를 여러 스레드가 동시에 사용하게 되면 문제가 발생할 수 있다. 이 클래스에 포함된 critical section 이 동기화 되어 있지 않기 때문이다.
 * 이 문제점은 ArrayList 객체를 동기화된 리스트(synchronized list, 멀티 스레드의 접근에 안전한 리스트)로 만들어서 해결 할 수 있다.
 * 그런일은 java.util.Collections class 의 synchronizedList method 를 이용해서 할 수 있다.
 * 이 메소드는 정적 메소드이기 때문에 아래와 같은 방법으로 호출 할 수 있다.
 * List list2 = Collections.synchronizedList(list1); - list2 : 동기화된 ArrayList 객체, list1 : ArrayList 객체
 * 여기서 사용한 List 타입은 java.util 패키지에 속하는 인터페이스 이름이다.
 * 이 인터페이스에 있는 메소드는 ArrayList 의 메소드와 이름도 똑같고 사용 방법도 똑같다.
 */
public class PerClientThread extends Thread{
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	//ArrayList 객체를 여러 스레드가 안전하게 공유할 수 있는 동기화된 리스트로 만든다.
	//모든 클라이언트에 대한 출력 스트림을 모아놓은 리스트
	Socket socket;
	PrintWriter writer;
	PerClientThread(Socket socket) {
		this.socket = socket;
		try {
			//리스트에 소켓의 출력 스트림을 등록한다.
			writer = new PrintWriter(socket.getOutputStream());
			list.add(writer);
			//리스트에 소켓의 출력 스트림을 등록한다.
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = reader.readLine(); //수신된 첫번째 문자열을 대화명으로 사용하기 위해 저장한다.
			sendAll("#" + name + "님이 들어 오셨습니다.");
			while(true) {
				String str = reader.readLine(); //메시지를 수신한다.
				if(str == null) break;
				sendAll(name + ">" + str); //수신된 메시지 앞에 대화명을 붙여서 모든 클라이언트로 송신한다.
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			list.remove(writer); //리스트에서 출력 스트림을 제거한다.
			sendAll("#" + name + "님이 나가셨습니다."); //사용자가 채팅을 종료했다는 메시지를 모든 클라이언트로 보낸다.
			try {
				socket.close(); //소켓을 닫는다.
			}
			catch(Exception ignored) {
			}
		}
	}
	//서버에 연결된 모든 클라이언트로 똑같은 메시지를 보낸다.
	private void sendAll(String str) {
		for(PrintWriter writer : list) {
			writer.println(str);
			writer.flush();
		}
	}
}
