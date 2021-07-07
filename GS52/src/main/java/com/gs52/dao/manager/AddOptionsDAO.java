package com.gs52.dao.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.emp.DeptVO;
import com.gs52.vo.emp.TeamVO;
import com.gs52.vo.emp.WorkRuleVO;
import com.gs52.vo.schedule.ConfRoomVO;

@Service
@Transactional
public class AddOptionsDAO {
	
	@Autowired
	private SqlSessionFactory sqlFactory = null;
	
	public List<DeptVO> selectListDept() {
		
		
		return sqlFactory.openSession().selectList("addOptions.selectListDept");
	}
	public int selectChecktDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().selectOne("addOptions.selectCheckDept",vo);
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
	public int selectCheckTeam( TeamVO vo) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().selectOne("addOptions.selectCheckTeam",vo);
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
	

	public List<WorkRuleVO> selectListWorkType() {
		// TODO Auto-generated method stub
	
		return sqlFactory.openSession().selectList("addOptions.selectListworkType");
	}
	
	
	public int selectCheckWorkRule(WorkRuleVO vo) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().selectOne("addOptions.selectCheckWorkRule",vo);
	}
	
	public int updateWorkRule(WorkRuleVO vo) {
		// TODO Auto-generated method stub
	
		return sqlFactory.openSession().update("addOptions.updateWorkRule",vo);
	}
	public int deleteWorkRule(long index) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().delete("addOptions.deleteWorkRule",index);
	}
	public int insertWorkRule(WorkRuleVO vo) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().insert("addOptions.insertWorkRule",vo);
	}
	
	
	public List<ConfRoomVO> selectListConf() {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().selectList("ConfRoom.Select_room");
	}
	public int selectCheckConfRoom(ConfRoomVO vo) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().selectOne("addOptions.selectCheckConfRoom",vo);
	}
	public int deleteConfRoom(long index) {
		// TODO Auto-generated method stub

		return sqlFactory.openSession().delete("addOptions.deleteConfRoom",index);
	}
	
	
	public int updateConfRoom(ConfRoomVO vo) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().update("addOptions.updateConfRoom",vo);
	}
	public int insertConfRoom(ConfRoomVO vo) {
		// TODO Auto-generated method stu
	
		return sqlFactory.openSession().insert("addOptions.insertConfRoom",vo);
		
	}
	

	
	
	
}
