package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import board.dto.BoardCommentDTO;
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
	
	// 게시물 번호에 대한 댓글 목록 조회 요청
	public List<BoardCommentDTO> commentList(int board_num){
		SqlSession session = MybatisManager.getInstance().openSession();
		
		List<BoardCommentDTO> list = session.selectList("board.commentList", board_num);
		session.close();
		
		return list;
	}
	
	// 게시물 번호에 대한 댓글 내용 등록
	public void commentAdd(BoardCommentDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		session.insert("board.commentAdd", dto);
		session.commit();
		session.close();
	}
	
	// 게시물 비번 체크 : 게시물 번호, 게시물 비번
	public String passwdCheck(int num, String passwd) {
		SqlSession session = MybatisManager.getInstance().openSession();
		// session 객체는 sql 식별값, 인자값 1개만 허용한다.
		// 인자값이 두 개 이상인 경우 Map, DTO(VO) 같은 그룹으로 자료전달
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		map.put("passwd", passwd);
		
		String result = session.selectOne("board.pass_check", map);
		session.close();
		
		return result;
	}
	
	public void update(BoardDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.update("board.update", dto);
		session.commit();
		
		session.close();
	}
	
	// 게시물 삭제 (댓글 없는 게시물에만 적용)
	public void delete(int num) {
		SqlSession session = MybatisManager.getInstance().openSession();
			
		session.update("board.delete", num);
		session.commit();

		session.close();		
	}
}
