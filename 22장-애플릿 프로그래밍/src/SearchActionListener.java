import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SearchActionListener implements ActionListener {
	JTable table;
	JTextField text;
	SearchActionListener(JTable table, JTextField text) {
		this.table = table;
		this.text = text;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = text.getText(); //텍스트 상자에 입력된 상품명을 가져온다.
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);//테이블에 원래 있던 모든 행을 삭제한다.
		Connection conn = null;
		Statement stmt = null;
		try {
			/*
			 * 아파치 웹 서버 연동시 jdbc Driver class 를 인식하지 못하여 ClassNotFoundException 이 발생한다.
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "6659");
			stmt = conn.createStatement();
			//상품 정보 테이블에서 검색한 결과를 가지고 윈도우의 테이블에서 새로운 행을 추가한다.
			ResultSet rs = stmt.executeQuery("select * from goodsinfo where " + "name like '" + name + "%';");
			while(rs.next()) {
				String arr[] = new String[4];
				arr[0] = rs.getString("code");
				arr[1] = rs.getString("name");
				arr[2] = rs.getString("price");
				arr[3] = rs.getString("maker");
				model.addRow(arr);
			}
			//상품 정보 테이블에서 검색한 결과를 가지고 윈도우의 테이블에서 새로운 행을 추가한다.
		}
		catch(ClassNotFoundException cnfe) {
			showErrorMessage("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} 
		catch (SQLException se) {
			showErrorMessage("데이터베이스 에러입니다.");
		}
		finally {
			try {
				stmt.close();
			}
			catch(Exception ignored) {
			}
			try {
				conn.close();
			}
			catch(Exception ignored) {
			}
		}
	}
	private void showErrorMessage(String str) {
		//다이얼로그 창의 띄워서 에러 메시지를 출력한다.
		JOptionPane.showMessageDialog(text, str, "에러 메시지", JOptionPane.ERROR_MESSAGE);	
	}

}
