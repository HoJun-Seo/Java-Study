package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/*
 * 이미지 파일의 로딩
 * 이미지를 디스플레이 하는 패널은 그림을 그리는 패널과 마찬가지로 JPanel class 를 상속받아서 만들 수 있다.
 * 그 클래스의 paint method 안에 이미지를 디스플레이 하는 명령문을 써넣으면 된다.
 * paint method 가 받는 Graphics 파라미터에는 drawImage method 가 있는데, 이 메소드를 이용하면 패널 위에 이미지를 디스플레이 할 수 있다.
 * 하지만 drawImage method 는 Image 객체를 파라미터로 받는 메소드이기 때문에, 먼저 이미지 파일을 읽어서 Image 객체로 만들어야 한다.
 * 그런일은 java.awt.Toolkit class 의 객체가 있어야 할 수 있다. Toolkit 객체를 얻기 위해서는 패널에 대해 getToolkit method 를 호출해야 한다.
 * Toolkit toolkit = panel.getToolkit(); - Toolkit 객체를 리턴하는 메소드
 * 이렇게 얻은 Toolkit 객체에 대해 getImage method 를 호출하면 이미지 파일을 Image 객체로 만들 수 있다.
 * getImage method 를 호출 할 때는 이미지 파일의 경로명을 파라미터로 넘겨줘야 한다.
 * Image image = toolkit.getImage("Logo.jpg"); - Logo.jpg 파일을 읽어서 Image 객체로 만들어서 리턴한다.
 * 이렇게 Image 객체를 얻은 다음에는 이 객체를 가지고 Graphics class 의 drawImage method 를 호출하여 이미지를 디스플레이 할 수 있다.
 */
public class ImageExample1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(500, 400));
		Container contentPane = frame.getContentPane();
		//이미지를 디스플레이할 패널을 만든다.
		ImagePanel imagePanel = new ImagePanel();
		contentPane.add(imagePanel, BorderLayout.CENTER);
		//이미지를 디스플레이할 패널을 만든다.
		JPanel controlPanel = new JPanel();
		JTextField text = new JTextField(30);
		JButton button = new JButton("이미지 로드");
		controlPanel.add(text);
		controlPanel.add(button);
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new LoadActionListener(text, imagePanel));
		//이미지 로드 버튼의 처리 리스너를 등록한다.
		frame.pack();
		frame.setVisible(true);
	}
}
/*
 * 이 절에서 배운 방법을 이용하면 jpg, gif, png 포맷의 이미지 파일은 디스플레이 할 수 있지만, 다른 포맷의 이미지 파일은 디스플레이 할 수 없다.
 * Toolkit class 의 getImage method 가 이 세 종류의 포맷만 지원하기 때문이다.
 */
