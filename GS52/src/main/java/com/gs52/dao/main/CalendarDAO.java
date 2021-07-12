package com.gs52.dao.main;

import java.util.List;
import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.main.CalendarVO;

@Service
@Transactional
public class CalendarDAO {
	
	@Autowired
	private SqlSessionFactory sqlFactory = null;
	
	public List<CalendarVO> selectList(CalendarVO vo) {
		System.out.println(vo);
		return sqlFactory.openSession().selectList("Main.selectCalendarAttend", vo);
	}
}
