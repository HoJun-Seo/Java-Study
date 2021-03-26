package survey.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sqlMap.MybatisManager;
import survey.dto.SurveyDTO;
import survey.dto.SurveyResultDTO;
import survey.dto.SurveySummerDTO;

public class SurveyDAO {
	// 설문문항 내용 호출
	public SurveyDTO viewQuestion(int survey_idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		SurveyDTO dto = session.selectOne("survey.view_question", survey_idx);
		session.commit();
		session.close();
		
		return dto;
	}
	public List<SurveyDTO> viewAllQuestion() {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		List<SurveyDTO> list = session.selectList("survey.viewAll_question");
		session.close();
		
		return list;
	}
	
	// 설문응답 내용을 저장하는 메소드
	public void insertSurvey(SurveyResultDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		
		session.insert("survey.insert_survey", dto);
		session.commit();
		session.close();
	}
	
	// 문제번호에 대한 응답번호별 통계
	public List<SurveySummerDTO> listSummary(int survey_idx){
		SqlSession session = MybatisManager.getInstance().openSession();
		
		List<SurveySummerDTO> items = session.selectList("survey.list_summary", survey_idx);
		session.close();
		
		return items;
		
	}

	
}
