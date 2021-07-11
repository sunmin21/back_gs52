package com.gs52.dao.main;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.main.WorkTimeVO;
import com.gs52.vo.schedule.ConfRoomBookVO;

@Service  
@Transactional
public class WorkTimeDAO {
	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	

	public List<WorkTimeVO> SelectWorkRule(@RequestBody WorkTimeVO vo) {
		//ATTEND_EMP_INDEX, ATTEND_DATE, ATTEND_START, ATTEND_ATTEND_TYPE_INDEX
		System.out.println("DAO");
		System.out.println(vo.getEMP_TEAM_INDEX());
		return sqlFacotry.openSession().selectList("WorkTime.Select_Work_Rule",vo);
	}

	public int WorkStart(@RequestBody WorkTimeVO vo) {
		//ATTEND_EMP_INDEX, ATTEND_DATE, ATTEND_START, ATTEND_ATTEND_TYPE_INDEX
		return sqlFacotry.openSession().insert("WorkTime.Insert_Start",vo);
	}

	public List<WorkTimeVO> SelectWorkCheck(@RequestBody WorkTimeVO vo) {
		//ATTEND_EMP_INDEX, ATTEND_DATE, ATTEND_START, ATTEND_ATTEND_TYPE_INDEX
		System.out.println("DAO");
		System.out.println(vo.getATTEND_DATE());
		
		System.out.println(vo);
		return sqlFacotry.openSession().selectList("WorkTime.Select_WorkCheck",vo);
	}
}
