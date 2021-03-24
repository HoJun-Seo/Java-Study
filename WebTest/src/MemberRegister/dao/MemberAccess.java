package MemberRegister.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import MemberRegister.dto.MemberData;
import webTest.member.dto.T_mem;

public class MemberAccess {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public  MemberAccess() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("myoracleDB");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String findMember(String id, String pwd) {
		String result = "존재하지 않는 계정입니다.";
		try {
			con = dataFactory.getConnection();
			
			String sql_all = "select * from member_register where id=? and password=?";
			String sql_id = "select * from member_register where id=?";
			String sql_pwd = "select * from member_register where password=?";
						
			pstmt = con.prepareStatement(sql_all);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) 
				result = "로그인 성공!!!";
			else {
				PreparedStatement pstmt_id = con.prepareStatement(sql_id);
				PreparedStatement pstmt_pwd = con.prepareStatement(sql_pwd);
				pstmt_id.setString(1, id);
				pstmt_pwd.setString(1, pwd);
				
				ResultSet rs_id = pstmt_id.executeQuery();
				ResultSet rs_pwd  = pstmt_pwd.executeQuery();
				
				if(rs_id.next() && rs_pwd.next() == false) result = "잘못된 비밀번호 입니다.";
				else if(rs_id.next() == false && rs_pwd.next()) result = "잘못된 아이디 입니다.";
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
		return result;
	}

	public void addMember(MemberData md) {
		try {
			String id = md.getId();
			String pwd = md.getPassword();
			String name = md.getName();
			String RRN = md.getRegister_number();
			
			con = dataFactory.getConnection();
			
			String sql = "insert into member_register(name,register_number,id,password) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, RRN);
			pstmt.setString(3, id);
			pstmt.setString(4, pwd);
			
			pstmt.executeUpdate(); // 입력, 수정, 삭제 => executeUpdate() 메소드 사용
			pstmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
