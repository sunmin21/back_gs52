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
	   System.out.println("@");
			 System.out.println(sqlFactory.openSession().selectList("Annual.selectAnnual",userid));
			 System.out.println("@");
		 return sqlFactory.openSession().selectList("Annual.selectAnnual",userid);
		 
		 
	}
	public void insertAnnual(AnnualManageVO vo) {
		
		sqlFactory.openSession().selectList("Annual.insertAnnual",vo);
		
	}
	
	public void deleteAnnual(int annualIndex) {
		
		sqlFactory.openSession().selectOne("Annual.deleteAnnual",annualIndex);
	}
	
	
}
