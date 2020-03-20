package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * JPanel 을 이용한 컴포넌트 배치 - 좀 더 복잡한 컴포넌트의 배치 방법
 * 좀 더 복잡하게 컴포넌틀를 배치하려면 어떤 레이아웃 하나만 가지고는 만들 수 없다. - 두 개의 레이아웃을 혼용해야 한다, 하지만 content pane 에는 단 하나의 레이아웃 만을 설정할 수 있다.
 * 이럴 때는 컴포넌트를 올려놓을 수 있는 패널을 만들어서 content pane 위에 올려놓고, 그 위에 컴포넌트 를 올려놓으면 된다.
 * 컴포넌트를 올려놓을 수 있는 패널은 javax.swing.JPanel class 를 이용해서 만들 수 있다.
 * JPanel panel = new JPanel(); contentPane.add(panel); - 패널을 생성해서 content pane 에 추가한다.
 * 패널도 일종의 컴포넌트 이기 때문에 add method 를 이용하여 content pane 에 올려 놓을 수 있다.
 * JPanel 에도 content pane 과 똑같은 setLayout method 가 있는데, 그 메소드를 이용하면 패널 자체의 레이아웃을 설정할 수 있다.
 * 예를 들어 패널을 3행 2열의 GridLayout 으로 설정하기 위해서는 아래와 같이 하면 된다.
 * GridLayout layout = new GridLayout(); panel.setLayout(layout); - 패널의 레이아웃을 3행 2열의 GridLayout 으로 설정한다.
 * 이렇게 레이아웃을 설정한 패널에 컴포넌트를 추가하면 3행 2열로 컴포넌트 들이 그 패널 위에 배열된다.
 * 패널에 컴포넌트를 추가 할 때는 content pane 과 마찬가지로 add method 를 사용하면 된다.(35 ~ 43행)
 */
public class WindowExample6 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("연락처 프로그램");
		frame.setPreferredSize(new Dimension(250, 150));
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		JPanel panel = new JPanel(); //패널을 생성한다.
		panel.setLayout(new GridLayout(3,2)); //패널의 레이아웃을 설정한다.
		//컴포넌트를 생성해서 패널에 추가한다.
		JTextField text1 = new JTextField();
		JTextField text2 = new JTextField();
		JTextField text3 = new JTextField();
		panel.add(new JLabel("이름"));
		panel.add(text1);
		panel.add(new JLabel("주소"));
		panel.add(text2);
		panel.add(new JLabel("전화번호"));
		panel.add(text3);
		//컴포넌트를 생성해서 패널에 추가한다.
		contentPane.add(panel, BorderLayout.CENTER); //패널을 content pane 에 추가한다.
		contentPane.add(new JButton("입력"), BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
