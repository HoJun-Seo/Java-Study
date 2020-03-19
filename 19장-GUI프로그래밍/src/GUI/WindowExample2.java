package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/*
 * 텍스트 상자와 버튼
 * 텍스트 상자는 java.swing.JTextField class 를 이용해서 만들수 있다. - JTextField text = new JTextField();
 * 버튼은 javax.swing.JButton class 를 이용해서 만들 수 있다. 이때 버튼에 표시할 텍스트를 생성자 파라미터로 넘겨줘야 한다. - JButton button = new JButton("확인");
 * 텍스트 상자, 버튼, 라벨을 만들었으면 이 컴포넌트 들을 content pane 에 추가해야 한다.
 * 하지만 위치 지정없이 add method 를 호출하게 되면 모든 컴포넌트 들이 겹쳐져서 마지막에 추가된 컴포넌트 하나만 보이게 된다.
 * 예) contentPane.add(text); contentPane.add(button); contentPane.add(label); - 마지막에 추가된 라벨만 보이게 된다.
 * content pane 은 컴포넌트를 배치할 영역을 기본적으로 동,서,남,북,중앙 으로 분할하기 때문에 이 중 한 위치를 선택하여 지정해야 한다.
 * 위와 같이 컴포넌트를 배치하는 방식을 border layout 이라고 한다.
 */
public class WindowExample2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Program");
		frame.setPreferredSize(new Dimension(200,70));
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		JTextField text = new JTextField();
		JButton button = new JButton("확인");
		JLabel label = new JLabel("Hello");
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);
		//border layout 각 위치에 컴포넌트 들을 배치한다.
		//여기서 사용한 BorderLayout 이라는 이름은 java.awt 패키지에 속하는 클래스 이름이고, 그 다음에 오는 CENTER, EAST, SOUTH 라는 이름은 그 클래스에 속하는 상수 이름이다.
		ActionListener listener = new ConfirmButtonActionListener(text, label);
		//ConfirmButtonActionListener class 의 actionPerformed method는 jdk 라이브러리의 이벤트 처리 모듈에 의해 자동으로 호출되기 때문에
		//main method 에서 이 메소드로 직접 파라미터를 넘겨줄 방법은 없다.
		//그래서 해당 프로그램 에서는 이 클래스의 생성자 파라미터를 통해 actionPerformed method 가 필요로 하는 텍스트 상자와 라벨을 넘겨주었다.
		/*
		 * 확인 버튼을 눌렀을 때 ConfirmButtonActionListener class 의 actionPerformed method 가 호출되도록 하려면
		 * 이 클래스의 객체를 생성해서 확인 버튼에 등록해야 한다.
		 * 확인 버튼에 이 클래스의 객체를 등록하는 일은 addActionListener method 를 호출해서 할 수 있다.
		 */
		button.addActionListener(listener);
		//이렇게 리스너를 생성해서 등록하는 명령문은 윈도우를 디스플레이 하기 전에 해야 하기 때문에, 이런 명령문은 윈도우를 디스플레이 하는 명령문 보다 앞에 써야 한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
