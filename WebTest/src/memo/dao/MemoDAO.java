package memo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import memo.dto.MemoDTO;
import sqlMap.MybatisManager;

public class MemoDAO {
	
	// 메모 목록을 리턴하는 메소드 작성
	public List<MemoDTO> listMemo(){
		// SqlSessionFactory 객체로부터 SqlSession 객체를 생성하여
		// db 처리하는 서비스 작동
		
		// 세션 자원 생성
		SqlSession session = MybatisManager.getInstance().openSession();
		List<MemoDTO> list = session.selectList("memo.list");
		
		// 세션 자원 해제(닫기)
		session.close();
		return list;
	}

	// 메모 추가하는 메소드 작성
	public void insertMemo(MemoDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		// 네임 스페이스가 "memo" 이고 id가 insert 인
		session.insert("memo.insert", dto);
		// 트랜잭션 커밋
		session.commit(); // insert, delete, update 일 경우 commit() 수행
		session.close();
	}

	// 메모 내용을 읽어오는 메소드(뷰 작업)
	public MemoDTO viewMemo(String idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		MemoDTO dto = session.selectOne("memo.view", idx);
		System.out.println("DAP : " + dto.toString());
		session.close();
		return dto;
	}

	public void updateMemo(MemoDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		session.update("memo.update", dto);
		session.commit();
		session.close();
	}

	public void deleteMemo(int idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		session.delete("memo.delete", idx);
		session.commit();
		session.close();
	}
}
