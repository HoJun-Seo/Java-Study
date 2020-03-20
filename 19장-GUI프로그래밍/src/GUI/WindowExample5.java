package GUI;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
//BoxLayout 을 사용하는 프로그램
/*
 * BoxLayout class 의 객체를 생성하는 방법은 다른 클래스와는 조금 다르다.
 * 이 클래스의 생성자에는 두 개의 파라미터를 넘겨줘야 하는데, 첫 번째 파라미터는 레이 아웃의 설정이 대상이 되는 content pane 이어야 하고
 * 두 번째 파라미터는 X_AXIS 와 Y_AXIS 라는 두 상수 중 하나여야 한다.
 * 이 상수는 BoxLayout class 에 속하고, 컴포넌트를 늘어놓는 방향을 의미한다.
 */
public class WindowExample5 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Cafe Program");
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		BoxLayout layout = new BoxLayout(contentPane, BoxLayout.X_AXIS);
		contentPane.setLayout(layout);
		//content pane 의 레이아웃을 BoxLayout 의 객체를 생성한 뒤 Container class 의 setLayout method 를 호출하여 적용시킨다.
		//가로 방향의 BoxLayout 으로 설정한다.
		contentPane.add(new JButton("자바"));
		contentPane.add(new JButton("에스프레소"));
		contentPane.add(new JButton("카푸치노"));
		contentPane.add(new JButton("블루마운틴"));
		contentPane.add(new JButton("콜럼비아"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
