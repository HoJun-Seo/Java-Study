package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/*
 * 테이블에 행 추가 - addRow, insertRow method
 * Object data[] = {"박승규", 27, '남'};
 * model.addRow(data); - 테이블의 마지막에 행을 추가한다.
 * model.insertRow(2, data); - 테이블의 2번째 위치에 행을 추가한다.
 */
public class AddActionListener implements ActionListener{
	JTable table;
	JTextField text1, text2, text3;
	AddActionListener(JTable table, JTextField text1, JTextField text2, JTextField text3) {
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
	}
	public void actionPerformed(ActionEvent e) {
		String arr[] = new String[3];
		arr[0] = text1.getText();
		arr[1] = text2.getText();
		arr[2] = text3.getText();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.addRow(arr);
		//텍스트 상자에 입력된 값을 가지고 테이블의 마지막에 행을 추가한다.
	}
}
