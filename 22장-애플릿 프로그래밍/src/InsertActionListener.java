import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class InsertActionListener implements ActionListener {
	JTextField text1, text2, text3;
	InsertActionListener(JTextField text1, JTextField text2, JTextField text3) {
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//입력 버튼을 눌렀을 때 하는 일
		String name = text1.getText();
		String address = text2.getText();
		String phoneno = text3.getText();
		System.out.println("이름 : " + name);
		System.out.println("주소 : " + address);
		System.out.println("전화번호 : " + phoneno);
	}

}
