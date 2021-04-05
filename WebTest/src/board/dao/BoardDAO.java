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
	// 게시글 저장 기능
	public void insert(BoardDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.insert("board.insert", dto);
		session.commit(); // insert, update, delete 는 commit() 적용
		session.close();
	}
	// 다운로드 횟수 처리
	public void plusDown(int num) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		session.update("board.plusDown", num);
		session.commit();
		session.close();
	}
	// 다운로드 파일 이름 추출
	public String getFileName(int num) {
		SqlSession session = MybatisManager.getInstance().openSession();
		String result = session.selectOne("board.getFilename", num);
		session.close();
		
		return result;
	}
	
	public BoardDTO view(int num) {
		SqlSession session = MybatisManager.getInstance().openSession();
		BoardDTO dto = session.selectOne("board.view", num);
		session.close();
		
		return dto;
	}
	
	public void plusReadCount(int num) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.update("board.plusReadCount", num);
		session.commit();
		session.close();
	}
}
