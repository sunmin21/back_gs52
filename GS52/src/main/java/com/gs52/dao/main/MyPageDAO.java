package com.gs52.dao.main;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.emp.EmpVO;

@Service  
@Transactional
public class MyPageDAO {
	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	
	public List<EmpVO> selectEmp(@RequestBody EmpVO vo) {
		System.out.println("DAO");
		return sqlFacotry.openSession().selectList("myPage.select_Emp",vo);
	}
	public int updateInform(@RequestBody EmpVO vo) {
		System.out.println("DAO");
		return sqlFacotry.openSession().update("myPage.update_inform",vo);
	}

}
