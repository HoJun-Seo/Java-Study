package GUI;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * 레이아웃과 패널
 * content pane 의 기본 레이아웃인 border layout 을 사용하면 최대 5개 까지의 컴포넌트를 배치 할 수 있다. 그러면 6개 이상의 컴포넌트를 content pane 에 올려놓기 위해서는 어떻게 해야 할까?
 * 그렇게 하려면 content pane 의 레이아웃을 다른 종류로 바꾸거나, content pane 위에 패널을 올려놓고 그 패널 위에 컴포넌트를 올려놓는 방법을 사용해야 한다.
 * jdk 라이브러리에는 컴포넌트의 레이아웃 설정에 사용되는 다양한 레이아웃 클래스들이 있다.
 * 그 중 가장 많이 사용되는 레이아웃 클래스는 GridLayout, FlowLayout, BoxLayout class 이다.
 * GridLayout 은 주어진 영역을 똑같은 크기의 행과 열로 나누고, 컴포넌트 들을 그 크기에 맞게 만들어서 배치하는 레이아웃이다.
 * BoxLayout 은 컴포넌트를 가로 또는 세로로 순서대로 배열하는 레이아웃 이다.
 * FlowLayout 은 좌에서 우로 컴포넌트를 배열하다가, 폭이 모자라면 줄을 바꿔서 계속 배열하는 레이아웃 이다.
 * content pane 에 이런 레이아웃을 설정하기 위해서는 먼저 해당 레이아웃 클래스의 객체를 만들어야 한다.
 * 그리고 나서 그 객체를 가지고 setLayout method 를 호출하면 된다.
 * 아래의 프로그램은 content pane 을 GridLayout 으로 설정하는 프로그램이다.  
 */
public class WindowExample3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Zoo Program");
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		GridLayout layout = new GridLayout(3,2);
		contentPane.setLayout(layout);
		// content pane 의 레이아웃을 2행 3열의 GridLayout 객체를 생성한 뒤 Container class 의 setLayout method 를 호출하여 적용시킨다.
		contentPane.add(new JButton("얼룩말"));
		contentPane.add(new JButton("사자"));
		contentPane.add(new JButton("코끼리"));
		contentPane.add(new JButton("코뿔소"));
		contentPane.add(new JButton("펭귄"));
		contentPane.add(new JButton("하이에나"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
/*
 * 특정 레이아웃을 설정하지 않고 content pane 위에 컴포넌트의 크기와 위치를 직접 지정 할 수도 있다.
 * 그렇게 하기 위해서는 먼저 content pane 에 설정되어 있는 레이아웃을 해제 해야 하는데, 방법은 아래와 같다.
 * contentPane.setLayout(null); - content pane 에 설정되어 있는 레이아웃을 해제하는 null 값
 * 이렇게 레이아웃을 해제한 다음에는 setSize method 와 setLocation method 를 이용해서 컴포넌트 각각의 크기와 위치를 지정해야 한다.
 * button.setSize(300, 30); button.setLocation(10, 10); 
 */
