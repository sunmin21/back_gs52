package com.gs52.dao.schedule;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.attendance.MemberAttendVO;
import com.gs52.vo.attendance.MemberEmpVO;
import com.gs52.vo.schedule.PersonalConfVO;

@Service  
@Transactional // 실패하면 다시 롤백하라
public class PersonalConfDAO {

	@Autowired 
	private SqlSessionFactory sqlFactory =null;
	
	public List<PersonalConfVO> selectList(){
		 return sqlFactory.openSession().selectList("Personal.selectConfPerson");
		 
	}
	
	public List<PersonalConfVO> selectLeaderList(){
		 return sqlFactory.openSession().selectList("Personal.selectConfLeader");
		 
	}
	
	
	


	
	
}
