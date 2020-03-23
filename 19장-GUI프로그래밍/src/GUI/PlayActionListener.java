package GUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PlayActionListener implements ActionListener{
	JTextField text;
	PlayActionListener(JTextField text) {
		this.text = text;
	}
	public void actionPerformed(ActionEvent e) {
		//텍스트 상자의 파일명을 가지고 오디오 클릭 객체를 생성해서 플레이한다.
		try {
			File file = new File(text.getText());
			AudioClip audioClip = Applet.newAudioClip(file.toURL());
			audioClip.play();
		}
		catch(MalformedURLException mue) {
			//22행의 toURL method 가 발생하는 익셉션을 처리한다.
			JOptionPane.showMessageDialog(text, "잘못된 파일명입니다.", "에러 메시지", JOptionPane.ERROR_MESSAGE);
		}
	}
}
