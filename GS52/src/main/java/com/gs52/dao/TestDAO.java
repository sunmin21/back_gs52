package com.gs52.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.TestVO;

@Service  
@Transactional // 실패하면 다시 롤백하라
public class TestDAO {

	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	
	public List<TestVO> selectList(){
			 
		 return sqlFacotry.openSession().selectList("Test.selectTest");
		 
		 
	}
}
