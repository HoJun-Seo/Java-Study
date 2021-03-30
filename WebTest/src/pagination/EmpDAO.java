package pagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import sqlMap.MybatisManager;

public class EmpDAO {
	
	public int recordCount() {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		int count = session.selectOne("emp.recordCount");
		session.close();
		return count;
		
	}
	
	public List<EmpDTO> empList(int start, int end){
		System.out.println("DAO list 처리중...");
		
		SqlSession session = MybatisManager.getInstance().openSession();
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		List<EmpDTO> list = session.selectList("emp.empList");
		session.close();
		
		System.out.println("DAO list 처리완료");
		return list;
	}
}
