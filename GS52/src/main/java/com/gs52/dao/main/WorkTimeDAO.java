package com.gs52.dao.main;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.emp.EmpVO;
import com.gs52.vo.main.BreakTimeVO;
import com.gs52.vo.main.WorkTimeVO;

@Service  
@Transactional
public class WorkTimeDAO {
	@Autowired 
	private SqlSessionFactory sqlFacotry =null;


	public List<EmpVO> SelectEmpImg(@RequestBody EmpVO vo) {
		System.out.println("SelectEmpImg");
		System.out.println(vo.getEMP_INDEX());
		return sqlFacotry.openSession().selectList("WorkTime.Select_Emp_Image",vo);
	}

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
	public int WorkEnd(@RequestBody WorkTimeVO vo) {
		return sqlFacotry.openSession().update("WorkTime.Update_End",vo);
	}
	public int WorkBreak(@RequestBody WorkTimeVO vo) {
		return sqlFacotry.openSession().update("WorkTime.Update_BreakTime",vo);
	}

	public List<WorkTimeVO> SelectWorkCheck(@RequestBody WorkTimeVO vo) {
		//ATTEND_EMP_INDEX, ATTEND_DATE, ATTEND_START, ATTEND_ATTEND_TYPE_INDEX
		System.out.println("DAO");
		System.out.println(vo.getATTEND_DATE());
		
		System.out.println(vo);
		return sqlFacotry.openSession().selectList("WorkTime.Select_WorkCheck",vo);
	}
	
	
	public int BreakStart(@RequestBody BreakTimeVO vo) {
		System.out.println("BreakStartDAO");
		System.out.println(vo);
		System.out.println(vo.getBREAK_INDEX());
		return sqlFacotry.openSession().insert("WorkTime.Insert_BreakStart",vo);
	}

	public int BreakEnd(@RequestBody BreakTimeVO vo) {
		System.out.println("BreakEnd");
		System.out.println(vo);
		return sqlFacotry.openSession().update("WorkTime.Update_BreakEnd",vo);
	}
	
	
}
