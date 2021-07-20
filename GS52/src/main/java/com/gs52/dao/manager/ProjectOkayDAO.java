package com.gs52.dao.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.schedule.ProjectListVO;

@Service
@Transactional
public class ProjectOkayDAO {
	
	@Autowired
	private SqlSessionFactory sqlFactory = null;

	public List<ProjectListVO> selectList(ProjectListVO vo) {
		System.out.println("selectList");
		System.out.println(vo);
		return sqlFactory.openSession().selectList("Project.selectOkay",vo);
	}

	public List<ProjectListVO> selectList_teamLeader(ProjectListVO vo) {
		System.out.println("selectList_teamLeader");
		System.out.println(vo);
		return sqlFactory.openSession().selectList("Project.selectOkay_teamLeader",vo);
	}
	
	public void updateOkay(ProjectListVO vo) {
		sqlFactory.openSession().update("Project.updateOkay", vo);
	}
	public List<ProjectListVO> selectList2(ProjectListVO vo) {
		// TODO Auto-generated method stub
		System.out.println(vo);
		System.out.println("너안타니?");
		return sqlFactory.openSession().selectList("Project.selectAll",vo);
	}
	
}
