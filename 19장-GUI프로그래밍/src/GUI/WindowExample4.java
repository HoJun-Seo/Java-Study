package GUI;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
//FlowLayout 을 사용하는 프로그램
public class WindowExample4 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fruit Basket Program");
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		FlowLayout layout = new FlowLayout();
		contentPane.setLayout(layout);
		//content pane 의 레이아웃을 FlowLayout 의 객체를 생성 한뒤 Container class 의 setLayout method 를 호출하여 적용시킨다.
		contentPane.add(new JButton("사과"));
		contentPane.add(new JButton("파인애플"));
		contentPane.add(new JButton("오렌지"));
		contentPane.add(new JButton("포도"));
		contentPane.add(new JButton("레몬"));
		contentPane.add(new JButton("복숭아"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
