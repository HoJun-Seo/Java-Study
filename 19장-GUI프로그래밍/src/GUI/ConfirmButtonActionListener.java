package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
/*
 * 버튼 이벤트의 처리 방법
 * 텍스트 상자에 있는 텍스트를 가져오려면 getText method 를 호출하면 된다. - String str = text.getText();
 * 라벨에 텍스트를 표시하는 일은 setText method 를 이용할 수 있다. 이 때 표시할 텍스트를 파라미터로 넘겨줘야 한다. - label.setText(str); - 라벨에 쓰여진 텍스트를 바꾸는 메소드.
 * 버튼을 눌렀을 때 해야 하는 일은 java.awt.event.ActionListener interface 를 구현하는 클래스의 actionPerformed method 안에 써넣어야 한다.
 * getText, setText method 를 작성해 놓는 공간이 이에 해당한다. 
 */
public class ConfirmButtonActionListener implements ActionListener{
	JTextField text;
	JLabel label;
	ConfirmButtonActionListener(JTextField text, JLabel label) {
		this.text = text;
		this.label = label;
	}
	public void actionPerformed(ActionEvent e) {
		String name = text.getText();
		label.setText("Hello, " + name);
	}
	/*
	 * 이 메소드는 jdk 라이브러리에 있는 이번트 처리 모듈에 의해 자동으로 호출되는데, 그 모듈은 버튼을 눌렀을 때 발생하는 이벤트에 대한 정보를 
	 * ActionEvent 객체에 담아서 파라미터로 넘겨주기 때문에, 그 값을 위와 같이 ActionEvent 타입의 파라미터 변수로 받아야 한다.
	 * 하지만 지금 작성하는 프로그램 에서는 그런 정보가 필요 없기 때문에 이 파라미터 변수는 선언만 해놓고 사용하지는 않는다. 
	 */
}
