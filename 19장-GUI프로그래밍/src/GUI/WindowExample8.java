package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/*
 * 테이블에 행을 추가하고 삭제하기
 * 테이블을 통해 보이는 데이터는 테이블이 아니라 그와 별도로 존재하는 모델 안에 저장된다. 그렇기 때문에 테이블에 새로운 데이터를 추가하거나 삭제하는 일은 모두 모델을 가지고 해야 한다.
 * 하지만 테이블이 생성될 때 자동으로 생성되는 모델은 아주 간단한 모델이기 때문에 행을 추가하거나 삭제하는 기능이 없다.
 * 그렇기 때문에 행의 추가와 삭제를 하기 위해서는 프로그래머가 직접 그런 기능을 갖는 모델 객체를 만들어야 한다.
 * 행의 추가와 삭제가 가능한 모델은 jdk 라이브러리에 있는 javax.swing.table.DefaultTableModel class 를 이용해서 만들 수 있다.
 * 이렇게 생성된 모델을 JTable class 의 생성자 파라미터로 넘겨주면, 그 모델에 데이터를 저장하는 테이블이 생성된다.
 * 하지만 이 모델에는 아직 아무 데이터도 없기 때문에 데이터를 추가하는 일은 별도로 해야 한다. 그런 일은 DefaultTableModel class 의 addRow method 와  insertRow method 를 호출해서 할 수 있다.
 * 이 메소드는 둘 다 테이블에 행을 추가하는 메소드인데, addRow method 는 테이블의 마지막 행을 추가하고 insertRow method 는 지정된 위치에 행을 추가한다.(AddActionListener class 참조)
 * 테이블에 있는 특정 행을 삭제하기 위해서는 DefaultTableModel class 의 removeRow method 를 사용하면 된다. - model.remove(3); : 테이블의 3번째 위치에 있는 행을 삭제한다.
 */
public class WindowExample8 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("참가자 명단 프로그램");
		frame.setPreferredSize(new Dimension(400, 200));
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		//테이블을 생성해서 content pane 에 추가한다.
		String colNames[] = {"이름", "나이", "성별"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0); //colNames : 컬럼 이름이 있는 1차원 배열, 0 : 행의 수
		JTable table = new JTable(model);
		//테이블을 생성해서 content pane 에 추가한다.
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		JPanel panel = new JPanel();
		JTextField text1 = new JTextField(6);
		JTextField text2 = new JTextField(3);
		JTextField text3 = new JTextField(2);
		JButton button1 = new JButton("추가");
		JButton button2 = new JButton("삭제");
		panel.add(new JLabel("이름"));
		panel.add(text1);
		panel.add(new JLabel("나이"));
		panel.add(text2);
		panel.add(new JLabel("성별"));
		panel.add(text3);
		panel.add(button1);
		panel.add(button2);
		contentPane.add(panel, BorderLayout.SOUTH);
		button1.addActionListener(new AddActionListener(table, text1, text2, text3));
		button2.addActionListener(new RemoveActionListener(table));
		//추가, 삭제 버튼에 대한 리스너를 등록
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
