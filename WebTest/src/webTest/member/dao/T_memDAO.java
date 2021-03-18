package webTest.member.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import webTest.member.dto.T_mem;

public class T_memDAO {
	// db 연결 초기화 작업
//	private static final String driver = "oracle.jdbc.driver.OracleDriver";
//	private static final String url = "jdbc:oracle:thin:@//localhost:1521/xe";
//	private static final String user = "web";
//	private static final String pwd = "tiger";
	
	private Connection con;
//	private Statement stmt;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public T_memDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("myoracleDB");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 1. db 연결하는 기능
//	private void connDB() {
//		try {
//			// 드라이브 클래스를 로딩
//			Class.forName(driver);
//			System.out.println("Oracle 드라이버 로딩 성공");
//			
//			// db 접속하는 객체
//			con = DriverManager.getConnection(url, user, pwd);
//			System.out.println("Connection 생성 성공");
//			
//			// sql 문장을 처리하는 객체
//			pstmt = con.createStatement();
//			System.out.println("Statement 생성 성공");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	// 2. db 연결 불러오기
	public List<T_mem> listMembers(){
		List<T_mem> list = new ArrayList<T_mem>();
		try {
//			connDB();// 데이터베이스 연결
			con = dataFactory.getConnection();
			String sql = "select * from t_mem";
			System.out.println(sql);
			
//			ResultSet rs = stmt.executeQuery(sql);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				T_mem dto = new T_mem();
				dto.setId(id);
				dto.setPwd(pwd);
				dto.setName(name);
				dto.setEmail(email);
				dto.setJoinDate(joinDate);
				
				System.out.println("T_memr : " + dto.toString());
				
				list.add(dto);
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	// 3. 데이터베이스 입력 처리
	public void addMember(T_mem vo) {
		try {
			con = dataFactory.getConnection();
			
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			
			// db 입력하는 sql 문장 작성
			String sql = "insert into t_mem(id,pwd,name,email) values(?,?,?,?)";
			System.out.println("prepareStatement 형식 결과 : " + sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			pstmt.executeUpdate(); // 입력, 수정, 삭제 => executeUpdate() 메소드 사용
			pstmt.close(); // 자원 해제
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 4. 삭제 메소드
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			
			// db 입력하는 sql 문장 작성
			String sql = "delete from t_mem where id=?";
			System.out.println("prepareStatement 형식 결과 : " + sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate(); // 입력, 수정, 삭제 => executeUpdate() 메소드 사용
			pstmt.close(); // 자원 해제
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public T_mem findMember(String id) {
		T_mem findMem = new T_mem();
		try {
			con = dataFactory.getConnection();
			
			String sql = "select * from t_mem where id=?";
			
			System.out.println("prepareStatement 형식 결과 : " + sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				findMem.setId(rs.getString("id"));
				findMem.setPwd(rs.getString("pwd"));
				findMem.setName(rs.getString("name"));
				findMem.setEmail(rs.getString("email"));
				findMem.setJoinDate(rs.getDate("joinDate"));
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return findMem;
	}

	public void updateOKMember(T_mem memberVo) {
		try {
			con = dataFactory.getConnection();
			
			String sql = "update t_mem set pwd=?, name=?, email=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVo.getPwd());
			pstmt.setString(2, memberVo.getName());
			pstmt.setString(3, memberVo.getEmail());
			pstmt.setString(4, memberVo.getId());
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean loginMember(String id, String pwd) {
		boolean success = false;
		try {
			con = dataFactory.getConnection();
			
			String sql = "select * from t_mem where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("id").equals(id) && rs.getString("pwd").equals(pwd)) {
					success = true;
				}
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}
}
