package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.dto.BoardDTO;
import sqlMap.MybatisManager;

public class BoardDAO {
	
	public List<BoardDTO> boardList(){
		// 1. db 연결하는 session 생성
		SqlSession session = MybatisManager.getInstance().openSession();
		// 2. sql 명령어 처리 요청 및 결과값 반환
		List<BoardDTO> list = session.selectList("board.boardList");
		session.close();
		
		return list;
	}
}
