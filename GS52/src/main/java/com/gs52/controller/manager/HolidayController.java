package com.gs52.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.manager.HolidayDAO;
import com.gs52.vo.manager.HolidayVO;

@RestController
@RequestMapping(value="/holiday")
public class HolidayController {
	
	@Autowired
	public HolidayDAO hDAO = null;
	
	@GetMapping("/h")
	public List<HolidayVO> HolidayBoard() {
		System.out.println("오냐");
		System.out.println(hDAO.selectList());		
		return hDAO.selectList();
	}
}
