package com.gs52.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.main.WorkTimeDAO;
import com.gs52.vo.main.WorkTimeVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/main/WorkTime")

public class WorkTimeController {
	@Autowired
	public WorkTimeDAO  wDAO = null;
	
	@PostMapping("/workRule")
	public List<WorkTimeVO> WorkRule(@RequestBody WorkTimeVO vo){
		System.out.println("WorkRule");
		System.out.println(vo);
		return wDAO.SelectWorkRule(vo);
	}
	
	@PostMapping("/workStart")
	public int WorkStart(@RequestBody WorkTimeVO vo) {

		System.out.println("WorkStart");
		System.out.println(vo);
		return wDAO.WorkStart(vo);
	}
	

	@PostMapping("/workCheck")
	public List<WorkTimeVO> WorkCheck(@RequestBody WorkTimeVO vo){
		System.out.println("WorkCheck");
		System.out.println(vo);
		return wDAO.SelectWorkCheck(vo);
	}
}
