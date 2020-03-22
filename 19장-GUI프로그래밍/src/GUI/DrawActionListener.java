package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DrawActionListener implements ActionListener{
	JTextField text1, text2, text3;
	DrawingPanel drawingPanel;
	DrawActionListener(JTextField text1, JTextField text2, JTextField text3, DrawingPanel drawingPanel){
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.drawingPanel = drawingPanel;
	}
	public void actionPerformed(ActionEvent e) {
		try {
			int korean = Integer.parseInt(text1.getText());
			int english = Integer.parseInt(text2.getText());
			int math = Integer.parseInt(text3.getText());
			drawingPanel.setScores(korean, english, math);
			//텍스트 상자의 점수를 읽어서 그래프를 그리는 패널에 넘겨준다.
			drawingPanel.repaint(); //그래프를 그리는 패널의 paint method 를 간접적으로 호출한다.
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(drawingPanel, "잘못된 숫자 포맷입니다.", "에러 메시지", JOptionPane.ERROR_MESSAGE);
			//JOptionPane.showMessageDialog method - 팝업 윈도우를 띄워서 메시지를 보여주는 메소드.
		}
	}
}
