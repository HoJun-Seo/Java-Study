package GUI;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
/*
 * 윈도우에서 종이의 역할은 JPanel class 가 할 수 있고, 필기도구의 역할은 java.awt.Graphics class 가 할 수 있다.
 * 윈도우에 그림을 그릴때는 그림이 그려진 패널을 만들어서 content pane 위에 올려놓는 방법을 사용해야 한다.
 * 그림이 그려진 패널은 JPanel class 를 직접 사용하는 것이 아니라, 이 클래스의 서브 클래스를 선언한 다음에 그 클래스의 객체를 만들어서 사용한다.
 * 그림을 그리기 위해서 JPanel의 서브 클래스를 선언할 때는 paint 라는 method 를 선언하고, 그 메소드 안에 그림을 그리는 명령문을 써넣어야 한다.
 */
public class GraphicExample1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("자동차 프로그램");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(400, 300));
		Container contentPane = frame.getContentPane();
		//자동차 그림이 있는 패널을 만들어서 content pane 에 추가한다.
		CarDrawingPanel drawingPanel = new CarDrawingPanel();
		contentPane.add(drawingPanel);
		//자동차 그림이 있는 패널을 만들어서 content pane 에 추가한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
