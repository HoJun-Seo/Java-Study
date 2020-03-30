import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ReceiverThread extends Thread {
	JTextArea text;
	Socket socket;
	ReceiverThread(JTextArea text, Socket socket) {
		this.text = text;
		this.socket = socket;
	}
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				final String str = reader.readLine(); //채팅 서버로부터 메시지를 수신한다.
				//수신된 메시지를 JTextArea 에 추가한다.
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						text.append(str + "\n");
					}
				}); //수신된 메시지를 JTextArea 에 추가한다.
			}
		}
		catch(IOException ioe) {
			JOptionPane.showMessageDialog(text, ioe.getMessage(), "에러 메시지", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("수신 종료");
	}
}
