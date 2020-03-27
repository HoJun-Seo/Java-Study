package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * 데이터베이스의 데이터를 읽는 방법 - JDBC API 를 이용해 데이터베이스에 있는 테이블의 데이터를 읽어오는 방법
 * 테이블의 데이터를 읽어오기 위해서는 Statement 객체가 필요한데, 그 객체는 앞에서 DriverManager class 의 getConnection method 를 호출해서 얻은 Connection 객체에 대해
 * createStatement method 를 호출해서 얻을 수 있다.
 * Statement stmt = conn.createStatement(); - Statement 객체를 만드는 메소드
 * 여기서 사용된 Statement 타입은 java.sql 패키지에 속하는 인터페이스 이름인데, 이 인터페이스에는 select 문을 실행하는 executeQuery 라는 메소드가 있다.
 * 이 메소드에는 파라미터로 select 문을 기술한 문자열을 넘겨줘야 한다.
 * ResultSet rs = stmt.executeQuery("select code, num, from goodsinfo;"); - execute 문을 실행하는 메소드
 * 이 메소드는 파라미터로 넘겨준 select 문을 데이터베이스로 보내서 실행하고, 그 결과로 ResultSet 객체를 리턴한다.
 * ResultSet 객체로부터 select 문의 실행 결과를 얻기 위해서는 먼저 next method 를 호출해야 한다.
 * 이 메소드는 select 문의 실행 결과 중 한 행을 읽어오는 메소드이다. - boolean exists = rs.next(); - 실행 결과의 다음 행 위치로 이동하는 메소드
 * 이 메소드가 리턴하는 boolean 값은 실제로 행을 읽어 왔는지 여부이다.
 * next method 를 호출한 다음에는 getInt, getString, getFloat 등의 메소드를 호출해서 특정 컬럼 값을 가져올 수 있다.
 * 그런데 이 메소드를 사용할 때는 컬럼의 타입과 맞는 메소드를 선택해서 사용해야 한다.
 * String code = rs.getString("code"); int price = rs.getInt("price");
 * getString - 컬럼 값을 읽어서 String 타입으로 리턴하는 메소드, getInt - 컬럼 값을 읽어서 int 타입으로 리턴하는 메소드
 * code, price - 컬럼 이름
 */
public class JDBCExample2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "6659");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select code, name, price, maker from goodsinfo;"); //select 문을 실행한다.
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
 * MYSQL 서버는 기본적으로 ISO-8859-1 문자셋 을 사용하여 데이터를 저장하는데, 자바 프로그램에서는 기본적으로 Unicode 문자셋을 사용한다.
 * 그렇기 때문에 데이터베이스로부터 한글이 포함된 데이터를 읽어와서 그대로 출력하면 한글이 깨져 보일수 있다.
 * 그래서 해당 프로그램에서는 한글이 포함된 데이터를 출력하기 전에 아래쪽에 있는 toUnicode method 를 호출하여 Unicode 로 바꾸어 준다.
 * -> 현재 사용하고 있는 MYSQL 서버에서 UTF-8, 즉 Unicode 문자셋을 지원하고 있으므로 해당 되지 않는 내용이다.
 */
	/*private static String toUnicode(String str) {
		try {
			byte[] b = str.getBytes("ISO-8859-1"); //ISO-8859-1 문자열을 Unicode 문자열로 만들어서 리턴한다.
			return new String(b);
		}
		catch(java.io.UnsupportedEncodingException uee) {
			System.out.println(uee.getMessage());
			return null;
		}
	}*/
	

/*
 * 그런데 ResultSet 으로부터 데이터를 읽어올 때는 더 이상 데이터가 없을 때까지 반복해서 읽어오는 것이 보통이다.
 * 그렇기 때문에 위에 적어놓은 명령문들은 아래와 같은 구조의 반복문으로 구성하여 사용하는 것이 보통이다.
 * while(rs.next()){ //더 이상 읽을 행이 없을 때까지 code, name, price, maker 컬럼의 값을 읽어오는 일을 반복한다. 
 * 	String code = rs.getString("code");
 * 	String name = rs.getString("name");
 * 	int price = rs.getInt("price");
 * 	String maker = rs.getString("maker");
 * 	......
 * }
 * ResultSet 객체를 모두 사용하고 난 다음에는 close method 를 호출해야 한다. 그래야 이 객체가 데이터베이스로부터 할당받은 자원이 해제될 수 있다.
 * rs.close(); - ResultSet 을 닫는 메소드
 * Statement 객체도 마찬가지로 모두 사용하고 난 다음에는 close method 를 호출해서 닫아야 한다. 이 객체도 역시 생성 될 때 데이터베이로부터 자원을 할당받기 때문이다.
 * stmt.close(); - Statement 을 닫는 메소드
 * Statement 객체를 close 하면 그에 연관된 ResultSet 객체도 자동으로 close 되기 때문에 두 객체를 연속해서 close 해야 할 경우에는 Statement 객체만 close 해도 된다.
 */
