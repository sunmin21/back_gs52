package com.gs52.dao.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.emp.DeptVO;
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
}
