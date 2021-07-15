package com.gs52.dao.main;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.main.WorkTimeVO;

@Service  
@Transactional
public class TimeProgressDAO {

	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	

	public List<WorkTimeVO> OnedayTotal(@RequestBody WorkTimeVO vo) {
		return sqlFacotry.openSession().selectList("TimeProgress.Select_Total",vo);
	}
	public List<WorkTimeVO> WeekTotal(@RequestBody WorkTimeVO vo) {
		return sqlFacotry.openSession().selectList("TimeProgress.Select_Week",vo);
	}

	public List<WorkTimeVO> SelectVacation(@RequestBody WorkTimeVO vo) {
		return sqlFacotry.openSession().selectList("TimeProgress.Select_vacation",vo);
	}

}
