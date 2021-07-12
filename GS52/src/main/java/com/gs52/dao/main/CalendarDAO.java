package com.gs52.dao.main;

import java.util.List;
import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.main.CalendarVO;

@Service
@Transactional
public class CalendarDAO {
	
	@Autowired
	private SqlSessionFactory sqlFactory = null;
	
	public List<CalendarVO> selectCalendar(@RequestBody CalendarVO vo) {
		System.out.println(vo);
		return sqlFactory.openSession().selectList("mainCalendar.selectCalendar", vo);
	}
	
	public List<CalendarVO> selectCalendar2(@RequestBody CalendarVO vo) {
		System.out.println(vo);
		return sqlFactory.openSession().selectList("mainCalendar.selectCalendar2", vo);
	}
	
	public List<CalendarVO> selectCalendar3(@RequestBody CalendarVO vo) {
		System.out.println(vo);
		return sqlFactory.openSession().selectList("mainCalendar.selectCalendar3", vo);
	}	
}
