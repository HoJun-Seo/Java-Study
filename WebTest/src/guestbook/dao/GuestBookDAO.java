package guestbook.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import guestbook.dto.GuestBookDTO;
import sqlMap.MybatisManager;

public class GuestBookDAO {
	
	// 조건 검색
	public List<GuestBookDTO> searchList(String searchKey, String search){
		SqlSession session = MybatisManager.getInstance().openSession();
		
		search = "%"+search+"%";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchKey", searchKey);
		map.put("search", search);
		
		List<GuestBookDTO> searchlist;
		if(searchKey.equals("name_content")) {
			searchlist = session.selectList("guestbook.searchNameContent", search);
		} else {
			searchlist = session.selectList("guestbook.searchList", map);
		}
		
		session.close();
		return searchlist;
	}
	
	//전체 조회
	public List<GuestBookDTO> getList(){
		//SqlSessionFactory 객체를 이용하여 SqlSession 객체를 생성
		SqlSession session = MybatisManager.getInstance().openSession();
		List<GuestBookDTO> list = session.selectList("guestbook.gbList");
		
		session.close();
		return list;
	}

	public void setInsert(GuestBookDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		session.insert("guestbook.gbInsert", dto);
		session.commit(); // insert, update, delete 처리 시 반드시 commit() 적용
		session.close();
	}

	public boolean passwdCheck(HashMap<String, Object> map) {
		boolean result;
		SqlSession session = MybatisManager.getInstance().openSession();
		Object rs = session.selectOne("guestbook.passwdCheck", map);
		
		if(rs == null) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	public GuestBookDTO gbDetail(int idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		GuestBookDTO dto = new GuestBookDTO();
		dto = session.selectOne("guestbook.gbDetail", idx);
		session.close();
		
		return dto;
	}

	public void gbUpdate(GuestBookDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		session.update("guestbook.update", dto);
		session.commit();
		session.close();
	}

	public void gbDelete(int idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		session.delete("guestbook.delete", idx);
		session.commit();
		session.close();
	} 
}
