package Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExample2 {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("211.208.104.225", 9000);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			//데이터를 송신한다.
			writer.println("Hello, Server");
			writer.flush();
			//데이터를 송신한다.
			//수신된 데이터를 출력한다.
			String str = reader.readLine();
			System.out.println(str);
			//수신된 데이터를 출력한다.
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
