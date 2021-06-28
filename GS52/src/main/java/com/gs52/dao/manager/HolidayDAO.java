package com.gs52.dao.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.manager.HolidayVO;

@Service
@Transactional
public class HolidayDAO {
	
	@Autowired
	private SqlSessionFactory sqlFactory = null;
	
	public List<HolidayVO> selectList() {
		System.out.println(sqlFactory.openSession().selectList("Holiday.showHoliday"));
		return sqlFactory.openSession().selectList("Holiday.showHoliday");
	}
	
	public void addHoliday(HolidayVO vo){
		sqlFactory.openSession().selectList("Holiday.addHoliday",vo);
		sqlFactory.openSession().commit();
		sqlFactory.openSession().close();
	}
	
	public void delHoliday(int holidayIndex){
		System.out.println(holidayIndex);
		sqlFactory.openSession().selectOne("Holiday.delHoliday", holidayIndex);
	}
}