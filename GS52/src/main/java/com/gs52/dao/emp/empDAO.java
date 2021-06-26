package com.gs52.dao.emp;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.emp.EmpVO;
import com.gs52.vo.task.BusinessProgressVO;

@Service  
@Transactional
public class empDAO {
	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	
	
	public List<EmpVO> selectListEmp(){
		
	
		 return sqlFacotry.openSession().selectList("emp.selectListUser");
		 
		 
	}
	public EmpVO selectUser(String EMP_ID){
		
		
		 return sqlFacotry.openSession().selectOne("emp.selectUser",EMP_ID);
		 
		 
	}
}
