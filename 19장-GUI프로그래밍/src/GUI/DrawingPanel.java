package GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel{
	int korean, english, math; //필드 값을 가져다가 막대 그래프를 그린다.
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight()); //패널 전체를 흰색으로 클리어
		//좌표를 그린다.
		g.drawLine(50, 250, 350, 250);
		for(int cnt = 1; cnt < 11; cnt++) {
			g.drawString(cnt * 10 + "", 25, 255 - 20 * cnt);
			g.drawLine(50, 250 - 20 * cnt, 350, 250 - 20 * cnt);
		}
		g.drawLine(50, 20, 50, 250);
		g.drawString("국어", 100, 270);
		g.drawString("영어", 200, 270);
		g.drawString("수학", 300, 270);
		//좌표를 그린다.
		//막대 그래프를 그린다.
		g.setColor(Color.RED);
		if(korean > 0)
			g.fillRect(110, 250 - korean * 2, 10, korean * 2);
		if(english > 0)
			g.fillRect(210, 250 - english * 2, 10, english * 2);
		if(korean > 0)
			g.fillRect(310, 250 - math * 2, 10, math * 2);
		//막대 그래프를 그린다.
	}
	//점수 필드 값을 설정하는 메소드 - repaint method 는 파라미터를 받지 않기 때문에, 국어 영어 수학 점수를 파라미터로 받아서 필드에 저장하는 또 다른 메소드를 선언해서 사용해야 한다.
	void setScores(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
		//국어, 영어, 수학 점수를 대입한다. - 9행
	}
}
