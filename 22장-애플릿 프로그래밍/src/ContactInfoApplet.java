import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * 애플릿에는 content pane 을 사용할 수 있는데, 그 위에는 JLabel 뿐만 아니라 여러가지 윈도우 컴포넌트 들을 올려놓을 수 있다.(버튼, 텍스트 상자, 테이블 등)
 * 레이아웃 또한 설정 가능하다.
 */
public class ContactInfoApplet extends JApplet{
	public void init() {
		Container contentPane = getContentPane();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
		JTextField text1 = new JTextField();
		JTextField text2 = new JTextField();
		JTextField text3 = new JTextField();
		panel.add(new JLabel("이름"));
		panel.add(text1);
		panel.add(new JLabel("주소"));
		panel.add(text2);
		panel.add(new JLabel("전화번호"));
		panel.add(text3);
		contentPane.add(panel, BorderLayout.CENTER);
		JButton button = new JButton("입력");
		contentPane.add(button, BorderLayout.SOUTH);
		button.addActionListener(new InsertActionListener(text1, text2, text3));
		//입력 버튼 리스너 등록
	}
}
