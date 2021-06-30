package com.gs52.dao.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.attendance.AnnualManageVO;
import com.gs52.vo.manager.VacationManageVO;

@Service  
@Transactional // 실패하면 다시 롤백하라
public class VacationManageDAO {

	@Autowired 
	private SqlSessionFactory sqlFactory =null;
	
	public List<VacationManageVO> selectList(){
		 return sqlFactory.openSession().selectList("Vacation.selectVacation");
		 
	}	

	
	public void updateVacation(VacationManageVO vo) {
		  sqlFactory.openSession().update("Vacation.updateVacation",vo); //
		  sqlFactory.openSession().close();
		 		
	
	}
	
	public void insertAttend(VacationManageVO vo) {
		sqlFactory.openSession().selectList("Vacation.insertAttend",vo);
		sqlFactory.openSession().commit();
		sqlFactory.openSession().close();
	}


	
	
}
