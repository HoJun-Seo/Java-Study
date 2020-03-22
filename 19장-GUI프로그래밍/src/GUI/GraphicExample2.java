package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * 데이터를 이용하여 그래프 그리기
 * 그림을 그리는 명령문은 모두 JPanel class 를 상속하는 클래스의 paint method 안에 써넣어야 한다.
 * 윈도우가 처음 뜰 때는 좌표만 존재, 그래프 그리기 버튼을 누르면 그 위에 그래프가 그려짐 - 두 가지 일을 어떻게 하나의 메소드 안에서 처리할까? - if 조건문 활용
 * korean, english, math 변수의 값이 0 보다 클 때는 좌표와 막대 그래프를 모두 그리고, 0 보다 작거나 같을 때는 좌표만 그리도록 한다.
 * 그래프 그리기 버튼을 눌렀을 때, paint method 를 직접 호출하려고 하면 안된다. - paint method 는 jdk 라이브러리의 모듈에 의해 호출되어야 만 패널 위에 그림을 그릴수 있기 때문
 * 이럴 경우에는 paint method 를 호출하는 대신, jdk 라이브러리 모듈로 하여금 paint method 를 호출하도록 만드는 repaint method 를 호출해야 한다.
 * repaint method 는 JPanel class 에 있는 메소드이기 때문에 아래와 같은 방법으로 호출 할 수 있다.
 * drawingPanel.repaint(); - paint method 를 간접적으로 호출하는 메소드
 * 그런데 이 메소드는 파라미터를 받지 않는 메소드이기 때문에, 이 메소드를 통해서 paint method 로 국어, 영어, 수학 점수를 넘겨줄 방법은 없다.
 * 그러니까 이럴 때는 국어, 영어, 수학 점수를 파라미터로 받아서 필드에 저장하는 또 다른 메소드를 선언해서 사용해야 한다. 
 */
public class GraphicExample2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("성적 그래프 프로그램");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(400, 350));
		Container contentPane = frame.getContentPane();
		DrawingPanel drawingPanel = new DrawingPanel();
		contentPane.add(drawingPanel, BorderLayout.CENTER);
		//그래프를 그릴 패널을 만든다.
		JPanel controlPanel = new JPanel();
		JTextField text1 = new JTextField(3);
		JTextField text2 = new JTextField(3);
		JTextField text3 = new JTextField(3);
		JButton button = new JButton("그래프 그리기");
		controlPanel.add(new JLabel("국어"));
		controlPanel.add(text1);
		controlPanel.add(new JLabel("영어"));
		controlPanel.add(text2);
		controlPanel.add(new JLabel("수학"));
		controlPanel.add(text3);
		controlPanel.add(button);
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new DrawActionListener(text1, text2, text3, drawingPanel));
		//그래프 그리기 버튼 처리 리스너를 등록한다.
		frame.pack();
		frame.setVisible(true);
		}
}
