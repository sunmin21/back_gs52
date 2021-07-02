package com.gs52.dao.schedule;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.schedule.ProjectListVO;

@Service
@Transactional
public class ProjectListDAO {
	
	@Autowired
	private SqlSessionFactory sqlFactory = null;
	
	public List<ProjectListVO> selectList(ProjectListVO vo) {
//		System.out.println(sqlFactory.openSession().selectList("ProjectList.selectProceeding"));
		return sqlFactory.openSession().selectList("ProjectList.selectProceeding", vo);
	}
}
