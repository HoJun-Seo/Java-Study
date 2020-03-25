package Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderThread2 extends Thread {
	Socket socket;
	String name;
	SenderThread2(Socket socket, String name){
		this.socket = socket;
		this.name = name;
	}
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			//제일 먼저 서버로 대화명을 송신한다.
			writer.println(name);
			writer.flush();
			//제일 먼저 서버로 대화명을 송신한다.
			while(true) {
				//키보드 입력된 메시지를 서버로 송신한다.
				String str = reader.readLine();
				if(str.equals("bye")) break;
				writer.println(str);
				writer.flush();
				//키보드 입력된 메시지를 서버로 송신한다.
			}
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
		}
	}
}
