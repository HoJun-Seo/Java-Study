package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * 데이터베이스에 데이터를 입력/수정/삭제 하는 방법 - JDBC API 를 이용하여 데이터베이스에 있는 테이블에 새로운 데이터를 추가하거나 기존의 데이터를 수정 또는 삭제하는 방법
 * 데이터베이스에 있는 테이블에 새로운 데이터를 쓰거나, 기존의 데이터를 수정, 삭제 할 때도 데이터를 읽을 때와 마찬가지로 Statement 객체가 필요하다.
 * 그리고 그 Statement 객체는 앞에서 학습했던 것과 마찬가지로 Connection 객체에 대해 createStatement method 를 호출해서 얻을 수 있다.
 * Statement stmt = conn.createStatement(); - Statement 객체를 생성하는 메소드
 * 이렇게 얻은 Statement 객체를 가지고 insert, update, delete 문을 실행하면 테이블에 데이터를 입력,수정,삭제할 수 있다.
 * 그런데 이때는 앞에서 학습했던 executeQuery method 를 사용하는 것이 아니라 executeUpdate method 를 사용해야 한다.
 * executeUpdate method 의 호출방법은 아래와 같다.
 * int rowNum = stmt.executeUpdate("insert goodsinfo(code, name, price, maker)" + "values('10006', '미니오븐', '170000', '컨택스');");
 * executeUpdate method - insert,update,delete 문을 실행하는 메소드
 * 이 메소드가 리턴하는 값은 입력, 수정, 삭제된 행의 수이다.
 */
public class JDBCExample4 {
	public static void main(String[] args) {
		if(args.length != 4) {  //이 프로그램은 DB에 입력할 데이터를 명령행 파라미터로 받아야 한다.
			System.out.println("Usage : java JDBCExample3 상품코드 상품명 가격 제조사");
			return;
		}
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "6659");
			stmt = conn.createStatement();
			int rowNum = stmt.executeUpdate("insert into goodsinfo(code, name, price, maker) values('"
					+ args[0] + "', '" + args[1] + "', '" + args[2] + "', '" + args[3] + "');");
			//4개의 명령행 파라미터를 컬럼 값으로 이용하여 goodsinfo 테이블에 새로운 행을 추가한다.
			System.out.println(rowNum + "행이 추가되었습니다.");
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
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
}
/*
 *  //문자셋 변경 메소드, 해당 프로그램에서는 쓰일 일이 없다.
 * private static String toLatin1(String str){
 * 		try{ 
 * 			byte[] b = str.getBytes();
 * 			return new String(b, "ISO-8859-1");
 * 		}
 * 		catch(java.io.UnsupportedEncodingException uee){
 * 			System.out.println(uee.getMessage());
 * 			return null;
 * 		}
 * }
 */
