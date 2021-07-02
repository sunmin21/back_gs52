package com.gs52.controller.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/schedule")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectListController {
	
//	@Autowired
//	public ProjectListDAO plDAO = null;
//	
//	@PostMapping("/projectList/selectProceeding")
//	public List<ProjectListVO> HolidayBoard() {
//		System.out.println("spring => selectProceeding");
//		System.out.println(plDAO.selectList());		
//		return plDAO.selectList();
//	}
}
