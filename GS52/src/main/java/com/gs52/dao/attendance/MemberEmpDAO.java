package com.gs52.dao.attendance;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.attendance.MemberEmpVO;

@Service  
@Transactional // 실패하면 다시 롤백하라
public class MemberEmpDAO {

	@Autowired 
	private SqlSessionFactory sqlFactory =null;
	
	public List<MemberEmpVO> selectList(){
		 return sqlFactory.openSession().selectList("Member.selectEmp");
		 
	}
	


	
	
}
