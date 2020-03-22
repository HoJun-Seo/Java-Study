package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	Image image;
	Toolkit toolkit = getToolkit(); //Toolkit 객체를 얻는다.
	void setPath(String path) {
		image = toolkit.getImage(path); //이미지 파일을 읽어서 Image 객체를 생성한다.
	}
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		if(image != null)
			g.drawImage(image, 0, 0, this); //패널에 이미지를 디스플레이 한다.
		//패널 (0,0) 위치에 image 를 디스플레이 한다.
	}
	/*
	 * public void paint(Graphics g){
	 * 		Toolkit toolkit = this.getToolkit();
	 * 		Image image = toolkit.getImage("Logo.jpg");
	 * 		g.drawImage(image, 0, 0, this);
	 * 		}
	 * }
	 * 이런식으로 paint method 를 작성하면 프로그램의 성능에 큰 문제가 생길 수 있다.
	 * paint method 는 윈도우가 가려졌다가 나타날 때마다 자동으로 호출 되기 때문에, 그 때마다 보조기억장치 로부터 똑같은 이미지 파일을 
	 * 반복적으로 읽어오게 되는데, 보조기억장치 로부터 파일을 읽어오는 일은 시간도 많이 걸리고 시스템 부담도 큰 일이기 때문이다.
	 * 이럴 경우에는 꼭 필요한 때만 이미지 파일을 읽어오도록 drawImage method 의 호출문을 제외한 나머지 명령문들을 
	 * paint method 밖으로 빼는 것이 좋다.
	 */
}
