package com.gs52.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.main.CalendarDAO;
import com.gs52.vo.main.CalendarVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/mainCalendar")
public class CalendarController {
	
	@Autowired
	public CalendarDAO cDAO = null;
	
	@PostMapping("/selectCalendar")
	public List<CalendarVO> CalendarBoard(@RequestBody CalendarVO vo) {
//		System.out.println("spring => selectCalendarController");
		System.out.println(vo);		
		return cDAO.selectCalendar(vo);
	}
}
