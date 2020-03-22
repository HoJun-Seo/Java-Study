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
	}
}
