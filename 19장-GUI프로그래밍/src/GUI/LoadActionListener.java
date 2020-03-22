package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class LoadActionListener implements ActionListener{
	JTextField text;
	ImagePanel imagePanel;
	LoadActionListener(JTextField text, ImagePanel imagePanel) {
		this.text = text;
		this.imagePanel = imagePanel;
	}
	public void actionPerformed(ActionEvent e) {
		imagePanel.setPath(text.getText()); //ImagePanel class 의 setPath method 를 호출한다.
		imagePanel.repaint(); //ImagePanel class 의 paint method 를 간접적으로 호출한다.
	}
	
}
