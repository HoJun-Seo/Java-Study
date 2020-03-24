package Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread{
	Socket socket;
	ReceiverThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				//서버로부터 메시지를 수신해서 모니터로 출력한다.
				String str = reader.readLine();
				if(str == null)
					break;
				System.out.println("수신>" + str);
				//서버로부터 메시지를 수신해서 모니터로 출력한다.
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
