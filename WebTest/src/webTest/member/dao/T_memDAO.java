package webTest.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webTest.member.dto.T_mem;

public class T_memDAO {
	// db 연결 초기화 작업
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String user = "web";
	private static final String pwd = "tiger";
	
	private Connection con;
	private Statement stmt;
	
	// 1. db 연결하는 기능
	private void connDB() {
		try {
			// 드라이브 클래스를 로딩
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			
			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// 2. db 연결 불러오기
	public List<T_mem> listMembers(){
		List<T_mem> list = new ArrayList<T_mem>();
		try {
			connDB();// 데이터베이스 연결
			String sql = "select * from t_mem";
			System.out.println(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joindDate = rs.getDate("joinDate");
				
				T_mem dto = new T_mem();
				dto.setId(id);
				dto.setPwd(pwd);
				dto.setName(name);
				dto.setEmail(email);
				dto.setJoinDate(joindDate);
				
				list.add(dto);
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
