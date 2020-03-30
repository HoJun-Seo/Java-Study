import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EnterActionListener implements ActionListener {
	Socket socket;
	PrintWriter writer;
	JTextField text;
	EnterActionListener(JTextField text, Socket socket, String name) {
		this.text = text;
		this.socket = socket;
		try {
			writer = new PrintWriter(socket.getOutputStream());
			writer.println();
			writer.flush();
			//채팅 서버로 대화명을 송신한다.
		}
		catch(IOException ioe) {
			JOptionPane.showMessageDialog(text, ioe.getMessage(), "에러 메시지", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			String str = text.getText(); //텍스트 상자에 있는 텍스트를 가져온다.
			if(str.equals("bye")) {
				socket.close();
			}
			//가져온 텍스트를 채팅 서버로 송신한다.
			writer.println(str);
			writer.flush();
			//가져온 텍스트를 채팅 서버로 송신한다.
		}
		catch(IOException ioe) {
			JOptionPane.showMessageDialog(text, ioe.getMessage(), "에러 메시지", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			text.setText("");
		}
	}

}
