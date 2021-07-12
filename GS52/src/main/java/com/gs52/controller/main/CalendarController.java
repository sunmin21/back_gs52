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

@RestController
@RequestMapping(value="/project")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CalendarController {
	
	@Autowired
	public CalendarDAO cDAO = null;
	
	@PostMapping("/selectCalendarAttend")
	public List<CalendarVO> ProjectListBoard(@RequestBody CalendarVO vo) {
		System.out.println("spring => selectCalendarAttend");
		System.out.println(vo);		
		return cDAO.selectList(vo);
	}
}
