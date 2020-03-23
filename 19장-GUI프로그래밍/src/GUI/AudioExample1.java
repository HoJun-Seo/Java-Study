package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/*
 * 오디오 파일을 재생하는 법
 * 먼저 오디오 파일을 읽어서 오디오 클립 객체로 만들고, 그 객체를 이용해서 오디오를 재생해야 한다.
 * 오디오 파일을 읽어서 오디오 클립 객체로 만드는 일은 java.applet.Applet class 의 정적 메소드인 newAudioClip method 를 이용해서 할 수 있다.
 * 그런데 이 메소드는 오디오 파일의 경로명을 java.net.URL 타입으로 받기 때문에, 아래와 같이 URL 객체를 만들어서 파라미터로 넘겨줘야 한다.
 * URL url = new URL("file:\\c:\\audio\\sample.au");
 * AudioClip audioClip = Applet.newAudioClip(url); - URL 객체를 가지고 newAudioClip method 를 호출해서 AudioClip 객체를 생성한다.
 * 그런데 위에서 처럼 파일의 경로명을 URL 포맷으로 쓰는 것은 그다지 익숙하지 않은 일이기에, 이럴 때는 java.io.File class(10장) 를 사용하는 것이 좋다.
 * 이 클래스에는 파일의 경로명을 URL 로 만들어서 리턴하는 toURL method 가 있기 때문이다.
 * File file = new File("c:\\audio\\sample.au"); - File 객체를 생성하고, 그 객체로부터 URL 객체를 얻는다.
 * URL url = file.toURL();
 * AudioClip audioClip = Applet.newAudioClip(url); //URL 객체를 가지고 newAudioClip method 를 호출해서 AudioClip 객체를 생성한다.
 * newAudioClip method 를 호출해서 얻은 AudioClip 객체에 대해서 아래와 같이 play method 를 호출하면 스피커를 통해서 오디오가 재생된다.
 * audioClip.play(); - 오디오 클립을 플레이 한다.
 */
public class AudioExample1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("오디오 플레이 프로그램");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(500, 70));
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		JTextField text = new JTextField(30);
		JButton button = new JButton("플레이");
		contentPane.add(text);
		contentPane.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new PlayActionListener(text)); //플레이 버튼 처리 리스너 등록
		frame.pack();
		frame.setVisible(true);
	}
}
// 이 절에서 배운 방법으로는 AU, WAV, MIDI, AIFF, RMF 포맷의 오디오 파일만 플레이 할 수 있고 다른 포맷의 오디오 파일은 플레이 할 수 없다.
