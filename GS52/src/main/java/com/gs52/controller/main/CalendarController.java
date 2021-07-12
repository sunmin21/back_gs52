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
		System.out.println("111111111111");
		return cDAO.selectCalendar(vo);
	}
	
	@PostMapping("/selectCalendar2")
	public List<CalendarVO> CalendarBoard2(@RequestBody CalendarVO vo) {
		System.out.println("2222222222222");
		return cDAO.selectCalendar2(vo);
	}
	
	@PostMapping("/selectCalendar3")
	public List<CalendarVO> CalendarBoard3(@RequestBody CalendarVO vo) {
		System.out.println("33333333333333");
		return cDAO.selectCalendar3(vo);
	}
}
