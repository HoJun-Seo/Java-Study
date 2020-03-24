package Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderThread extends Thread{
	Socket socket;
	SenderThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			while(true) {
				String str = reader.readLine(); //키보드로부터 문자열을 입력받는다.
				//사용자가 "bye" 라고 입력하면 반복문을 빠져나간다.
				if(str.equals("bye"))
					break;
				//사용자가 "bye" 라고 입력하면 반복문을 빠져나간다.
				//입력된 문자열을 서버로 송신한다.
				writer.println(str);
				writer.flush();
				//입력된 문자열을 서버로 송신한다.
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
