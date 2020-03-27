package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * 검색 조건에 맞는 데이터만 읽어오는 방법
 * 특정 조건을 만족하는 데이터를 읽어오기 위해서는 앞에서 학습했던 것과 같이 select 문에 where 절을 사용하면 된다.
 */
public class JDBCExample3 {
	public static void main(String[] args) {
		if(args.length != 1) { //명령행 파라미터가 없으면 상품명을 입력하라는 메시지를 출력하고 프로그램을 끝낸다.
			System.out.println("Usage : java JDBCExample3 상품명");
			return;
		}
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "6659");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select code, name, price, maker "
					+ "from goodsinfo where name = '" + args[0] + "';"); //select 문을 실행한다.
			//goodsinfo 테이블에서 명령행 파라미터와 같은 상품명을 갖는 행만 읽는다.
			System.out.println("         상품코드 상품명 \t\t\t가격 제조사");
			System.out.println("---------------------------------------------");
			while(rs.next()) { //select 문의 실행결과를 출력한다.
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%9s %s \t%12d %s\n", code, name, price, maker);
			}
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		finally {
			try {
				stmt.close(); //Statement 를 닫는다.
			}
			catch(Exception ignored) {
			}
			try {
				conn.close(); //4 단계 : DB 연결을 끊는다.
			}
			catch(Exception ignored) {
			}
		}
	}
}
/*
 *  //아래는 각각 문자셋 변환 메소드 - 해당 프로그램에서는 사용될 필요가 없다.
 * private static String toUnicode(String str){
 * 		try{
 * 			byte[] b = str.getBytes("ISO-8859-1");
 * 			return new String(b);
 * 		}
 * 		catch(java.io.UnsupportedEncodingException uee){
 * 			System.out.println(uee.getMessage());
 * 			return null;
 * 		}
 * }
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
