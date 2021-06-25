package com.gs52.dao.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.emp.DeptVO;
import com.gs52.vo.emp.TeamVO;
import com.gs52.vo.emp.WorkRuleVO;
import com.gs52.vo.manager.HolidayVO;

@Service
@Transactional
public class AddOptionsDAO {
	
	@Autowired
	private SqlSessionFactory sqlFactory = null;
	
	public List<DeptVO> selectListDept() {
		
		
		return sqlFactory.openSession().selectList("addOptions.selectListDept");
	}
	public int deleteDept(int index) {
		
		
		return sqlFactory.openSession().delete("addOptions.deleteDept",index);
	}
	public int updateDept(DeptVO vo) {
		// TODO Auto-generated method stub
		
		
		return sqlFactory.openSession().update("addOptions.updateDept",vo);
	}
	
	public int insertDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().insert("addOptions.insertDept",vo);
	}
	public List<TeamVO> selectListTeam() {
		
		return sqlFactory.openSession().selectList("addOptions.selectListTeam");
	}
	public int deleteTeam(int index) {
		// TODO Auto-generated method stub
		
		return sqlFactory.openSession().delete("addOptions.deleteTeam",index);
	}
	
	public int updateTeam(TeamVO vo) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().update("addOptions.updateTeam",vo);
	}
	public int insertTeam(TeamVO vo) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().insert("addOptions.insertTeam",vo);
	}
	public List<WorkRuleVO> selectListWorkRule() {
		// TODO Auto-generated method stub
		
		return sqlFactory.openSession().selectList("addOptions.selectListWorkRule");
	}
	public List<WorkRuleVO> selectListworkType() {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().selectList("addOptions.selectListworkType");
	}
	
	
	
}
