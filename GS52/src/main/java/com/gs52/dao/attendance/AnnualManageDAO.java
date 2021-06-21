package com.gs52.dao.attendance;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.attendance.AnnualManageVO;

@Service  
@Transactional // 실패하면 다시 롤백하라
public class AnnualManageDAO {

	@Autowired 
	private SqlSessionFactory sqlFactory =null;
	
	public List<AnnualManageVO> selectList(int userid){
		 return sqlFactory.openSession().selectList("Annual.selectAnnual",userid);
		 
	}
	
	public List<AnnualManageVO> selectOne(int userid){
		 return sqlFactory.openSession().selectList("Annual.selectEmpVacation",userid);
	}
	public void insertAnnual(AnnualManageVO vo) {
		
		sqlFactory.openSession().selectList("Annual.insertAnnual",vo);
		sqlFactory.openSession().commit();
		sqlFactory.openSession().close();
		
	}
	
	public void deleteAnnual(int annualIndex) {
		
		sqlFactory.openSession().selectOne("Annual.deleteAnnual",annualIndex);
	}
	
	public void updateAnnual(AnnualManageVO vo) {
		  sqlFactory.openSession().update("Annual.updateEmpVacation",vo); //
		  sqlFactory.openSession().close();
		 		
	
	}
	
	
}
