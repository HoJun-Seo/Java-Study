package GUI;

import java.awt.Graphics;

import javax.swing.JPanel;
/*
 * paint method 는 Graphics 타입의 파라미터를 받는 public void 메소드로 선언해야 한다.
 * 이렇게 선언된 paint method 는 패널이 디스플레이 될 때 jdk 라이브러리의 모듈에 의해 자동으로 호출된다. - 메소드 안에 있는 그림을 그리는 명련문도 그 때 실행되어 그림이 그려지게 된다.
 * 그림을 그리는 명령문은 이 메소드가 파라미터로 받은 Graphics 객체를 이용하여 만들 수 있다.(Graphics class 는 그림을 그리는 기능의 여러 가지 메소드들을 가지고 있다.)
 * g.drawRect(100, 110, 200, 40); - (100, 110) 위치에 200 x 40 크기의 직사각형을 그린다.
 * g.drawOval(125, 150, 30, 30); - (125, 150) 위치에 지름이 30인 원을 그린다.
 * g.drawLine(50, 180, 350, 180); - (50, 180) 부터 (350, 180) 위치까지 직선을 그린다. 
 */
public class CarDrawingPanel extends JPanel{
	public void paint(Graphics g) {
		g.drawRect(100, 110, 200, 40);
		g.drawRect(150, 70, 100, 40);
		g.drawOval(125, 150, 30, 30);
		g.drawOval(245, 150, 30, 30);
		g.drawLine(50, 180, 350, 180);
		//자동차 그림을 그리는 명령문
	}
}
