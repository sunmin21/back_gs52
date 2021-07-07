package com.gs52.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.manager.HolidayDAO;
import com.gs52.vo.manager.HolidayVO;

@RestController
@RequestMapping(value="/manager/holiday")
@CrossOrigin(origins="*",maxAge=3600)
public class HolidayController {
	
	@Autowired
	public HolidayDAO hDAO = null;
	
	@GetMapping("/showHoliday")
	public List<HolidayVO> HolidayBoard() {
		System.out.println("spring => holiday");
		System.out.println(hDAO.selectList());		
		return hDAO.selectList();
	}
	
	@PostMapping("/addHoliday")
	public void addHoliday(@RequestBody HolidayVO vo) {
		System.out.println("addHoliday=====");
		hDAO.addHoliday(vo);
	}
	
	@PostMapping("/delHoliday")
	public void delHoliday(@RequestBody HolidayVO vo) {
		System.out.println("delHoliday=====");
		hDAO.delHoliday(vo.getHOLIDAY_INDEX());
	}
}
