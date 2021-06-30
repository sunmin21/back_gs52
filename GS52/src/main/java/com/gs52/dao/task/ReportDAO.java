package com.gs52.dao.task;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.task.ReportVO;

@Service
@Transactional
public class ReportDAO {
	
	@Autowired
	private SqlSessionFactory sqlFactory = null;
	
	public List<ReportVO> selectList(ReportVO vo) {
		System.out.println(vo);
		System.out.println("THIS IS DAO PART");		
		return sqlFactory.openSession().selectList("Report.showReport", vo);
	}
	
	
	public void addReport (ReportVO vo) {
		System.out.println(vo);
		sqlFactory.openSession().selectList("Report.addReport", vo);
		sqlFactory.openSession().commit();
		sqlFactory.openSession().close();
	}
	
	public void delReport (int ReportIndex) {
		System.out.println(ReportIndex);
		sqlFactory.openSession().selectOne("Report.delReport", ReportIndex);
	}
	
	public List<ReportVO> selectEmpList(ReportVO vo) {
		System.out.println(vo);
		System.out.println("selectEmpList");		
		return sqlFactory.openSession().selectList("Report.empList", vo);
	}
}
