import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChattingApplet extends JApplet{
	Socket socket;
	public void init() {
		try {
			socket = new Socket(InetAddress.getByName("211.208.104.225"), 9002);
			//채팅 서버와 연결을 맺는다.
		}
		catch(IOException ioe) {
			JOptionPane.showMessageDialog(this, ioe.getMessage(), "에러 메시지", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//GUI 컴포넌트를 만들어서 배치한다.
		Container contentPane = getContentPane();
		JTextArea text1 = new JTextArea();
		JTextField text2 = new JTextField(30);
		text1.setEditable(false);
		contentPane.add(new JScrollPane(text1), BorderLayout.CENTER);
		contentPane.add(text2, BorderLayout.SOUTH);
		//GUI 컴포넌트를 만들어서 배치한다.
		//대화명으로 사용할 query string 을 가져온다.
		URL url = getDocumentBase();
		String name = url.getQuery();
		//대화명으로 사용할 query string 을 가져온다.
		//JTextField 의 리스너를 등록한다.
		ActionListener listener = new EnterActionListener(text2, socket, name);
		text2.addActionListener(listener);
		//JTextField 의 리스너를 등록한다.
		//메시지 수신 스레드를 생성해서 시작한다.
		Thread thread = new ReceiverThread(text1, socket);
		thread.start();
		//메시지 수신 스레드를 생성해서 시작한다.
	}
	public void destroy() {
		try {
			socket.close();
		}
		catch(IOException ioe) {
			JOptionPane.showMessageDialog(this, ioe.getMessage(), "에러 메시지", JOptionPane.ERROR_MESSAGE);
		}
	}
}
