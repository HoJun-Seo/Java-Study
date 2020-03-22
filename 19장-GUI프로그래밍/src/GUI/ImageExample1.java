package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ImageExample1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(500, 400));
		Container contentPane = frame.getContentPane();
		ImagePanel imagePanel = new ImagePanel();
		JPanel controlPanel = new JPanel();
		JTextField text = new JTextField(30);
		JButton button = new JButton("이미지 로드");
		controlPanel.add(text);
		controlPanel.add(button);
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new LoadActionListener(text, imagePanel));
		contentPane.add(imagePanel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
