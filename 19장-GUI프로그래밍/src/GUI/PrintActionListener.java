package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.TableModel;
/*
 * 테이블에 있는 정보 가져오기
 * 테이블의 내용을 명령 프롬프트로 출력하기 위해서는 먼저 윈도우를 통해 보여지고 있는 테이블의 내용을 프로그램 내부로 가져와야 한다.
 * 이런 일은 테이블에 직접 할 수 없다.(테이블이 생성되고 나면 테이블의 내용이 별도의 객체에 저장되기 때문)
 * 테이블의 내용이 별도로 저장되는 객체를 모델(model) 이라고 하는데, 테이블의 모델은 아래와 같이 getModel method 를 호출해서 가져올 수 있다.
 * TableModel model = table.getModel(); - 테이블의 모델을 가져오는 메소드
 * 이렇게 가져온 모델에 대해 getValueAt method 와 setValueAt method 를 호출하면 주어진 행렬 위치의 값을 가져올 수도 있고,
 * 특정 위치의 항목을 다른 값으로 바꿀 수도 있다.
 * Object obj = model.getValueAt(2,3); - 2행 3열 위치에 있는 데이터를 가져온다.
 * model.setValueAt("김수영", 1, 0); - 1행 0열에 있는 데이터를 "김수영" 으로 바꾼다.
 */
public class PrintActionListener implements ActionListener{
	JTable table;
	PrintActionListener(JTable table) {
		this.table = table;
	}
	public void actionPerformed(ActionEvent e) {
		TableModel model = table.getModel(); //모델을 가져온다.
		int rowNum = model.getRowCount();
		int colNum = model.getColumnCount();
		//모델로부터 행과 열의 수를 가져온다.
		for(int col = 0; col < colNum; col++) {
			String colName = model.getColumnName(col);
			System.out.println(colName + "\t");
		}
		//컬럼 이름을 가져와서 출력한다.
		System.out.println();
		for(int row = 0; row < rowNum; row++) {
			for(int col = 0; col < colNum; col++) {
				Object obj = model.getValueAt(row, col);
				System.out.println(obj + "\t");
			}
			System.out.println();
		}
		//데이터를 가져와서 출력한다.
		System.out.println("---------------------------------");
	}
}
/*
 * 테이블의 모델에는 테이블 항목의 데이터 뿐만 아니라 행과 열에 대한 정보도 저장된다.
 * 그렇기 때문에 모델에 대해 아래와 같은 메소드를 호출하면 행과 열의 수를 알 수도 있다.
 * int rowNum = model.getRowCount(); - 행의 수를 가져오는 메소드
 * int colNum = model.getColumnCount(); - 열의 수를 가져오는 메소드
 * 그리고 모델에 대해 getColumnName 이라는 메소드를 호출하면 테이블에 표시된 컬럼 이름도 가져올 수 있다.
 * String str = model.getColumnName(cnt); - cnt 번째 컬럼 이름을 가져온다.
 */
