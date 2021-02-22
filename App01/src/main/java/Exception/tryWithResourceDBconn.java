package Exception;

import java.io.IOException;

public class tryWithResourceDBconn {
	public static void main(String[] args) {
		// 방법1 : 기존 연결 및 해제 방법
		// 방법2 : try-with-resource 방법
		try (OracleDb db1 = new OracleDb()){
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

interface Database{
	public void getConnectoin() throws IOException;
	public String getDbInfo();
	public void close() throws Exception;
}

class OracleDb implements Database, AutoCloseable{

	boolean conn;

	@Override
	public void getConnectoin() throws IOException {
		this.conn = true;
	}

	@Override
	public String getDbInfo() {
		String ret = "";
		if(conn)
			ret = "오라클 연결 되었습니다.";
		else 
			ret = "오라클 연결 실패";
		return ret;
	}

	@Override
	public void close() throws Exception {
		this.conn = false;
		System.out.println("오라클 접속 끊었습니다.");
	}
	
}
