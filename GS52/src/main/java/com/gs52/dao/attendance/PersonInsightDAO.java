package com.gs52.dao.attendance;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.attendance.AnnualManageVO;
import com.gs52.vo.attendance.PersonInsightVO;

@Service  
@Transactional // 실패하면 다시 롤백하라
public class PersonInsightDAO {

	@Autowired 
	private SqlSessionFactory sqlFactory =null;
	
	public List<PersonInsightVO> selectList(int userid){
	
		 return sqlFactory.openSession().selectList("Insight.selectEmpEntryDate",userid);
		 
	}
	
	public List<PersonInsightVO> selectProjectCount(int userid){
		
		
		 return sqlFactory.openSession().selectList("Insight.selectProjectCount",userid);
		 
	}
	
	public List<PersonInsightVO> selectTodoCount(int userid){
		
		
		 return sqlFactory.openSession().selectList("Insight.selectTodoCount",userid);
		 
	}
	
	public List<PersonInsightVO> selectBusinessCount(int userid){
		
		
		 return sqlFactory.openSession().selectList("Insight.selectBusinessCount",userid);
		 
	}

	public List<PersonInsightVO> selectReportCount(int userid){
		
		
		 return sqlFactory.openSession().selectList("Insight.selectReportCount",userid);
		 
	}
	
	public List<PersonInsightVO> selectWorkTime(int userid){
		
		
		 return sqlFactory.openSession().selectList("Insight.selectWorkTime",userid);
		 
	}
	
	
	public List<PersonInsightVO> selectPersonInsight(){
		
		System.out.println("오나?");
		 return sqlFactory.openSession().selectList("Insight.selectPersonInsight");
		 
	}
	
	

	
	
	
}
