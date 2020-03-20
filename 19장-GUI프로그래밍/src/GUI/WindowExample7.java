package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/*
 * 테이블 - 표 형태로 데이터를 보여주는 테이블 컴포넌트의 사용 방법
 * 테이블은 javax.swing. 패키지에 있는 JTable class 를 이용해서 만들 수 있다.
 * 이 클래스에는 여러 종류의 생성자들이 있기 때문에 테이블을 만드는 방법도 다양하다. 여기서는 그 중 가장 간단하게 사용할 수 있는 배열 파라미터를 받는 생성자의 사용 방법을 확인한다.
 * JTable class 에는 컬럼 이름과 데이터를 각각 1차원, 2차원 배열로 받는 생성자가 있는데, 그 생성자를 이용하면 배열에 입력된 데이터를 출력하는 테이블을 만들 수 있다.
 * 그런데 이렇게 만든 테이블을 content pane 위에 바로 올려놓으면 컬럼 이름 부분과 스크롤 바가 생기지 않는다.
 * 컬럼 이름 부분과 스크롤 바를 표시하려면, 스크롤 판을 만들어서 그 위에 테이블을 올려놓은 다음에 그 스크롤판을 content pane 위에 올려놓아야 한다.
 */
public class WindowExample7 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("참가자 명단 프로그램");
		frame.setPreferredSize(new Dimension(300, 150));
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		String colNames[] = {"이름", "나이", "성별"};
		Object data[][] = {{"김철수", 24, '남'}, {"이순희", 21, '여'}, {"박지영", 26, '여'}};
		JTable table = new JTable(data, colNames); //data : 데이터 항목이 있는 2차원 배열, colNames : 컬럼 이름이 있는 1차원 배열
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER); //스크롤 판을 content pane 에 추가한다.
		JButton button = new JButton("출력");
		contentPane.add(button, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
