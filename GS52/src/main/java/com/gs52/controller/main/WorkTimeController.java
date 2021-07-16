package com.gs52.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.main.WorkTimeDAO;
import com.gs52.vo.emp.EmpVO;
import com.gs52.vo.main.BreakTimeVO;
import com.gs52.vo.main.WorkTimeVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/main/WorkTime")

public class WorkTimeController {
	@Autowired
	public WorkTimeDAO  wDAO = null;
	
	@PostMapping("/empImg")
	public List<EmpVO> empImg(@RequestBody EmpVO vo){
		System.out.println("empImg");
		return wDAO.SelectEmpImg(vo);
	}

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

	@PostMapping("/workEnd")
	public int WorkEnd(@RequestBody WorkTimeVO vo) {

		System.out.println("WorkStart");
		System.out.println(vo);
		return wDAO.WorkEnd(vo);
	}
	
	@PostMapping("/workBreak")
	public int WorkBreak(@RequestBody WorkTimeVO vo) {

		System.out.println("WorkBreak");
		System.out.println(vo);
		return wDAO.WorkBreak(vo);
	}
	

	@PostMapping("/workCheck")
	public List<WorkTimeVO> WorkCheck(@RequestBody WorkTimeVO vo){
		System.out.println("WorkCheck");
		System.out.println(vo);
		return wDAO.SelectWorkCheck(vo);
	}
	
	@PostMapping("/breakStart")
	public long BreakStart(@RequestBody BreakTimeVO vo) {

		System.out.println("BreakStart");
		System.out.println(vo);
		int value = wDAO.BreakStart(vo);
		System.out.println("value");
		System.out.println(vo.getBREAK_INDEX());
		return vo.getBREAK_INDEX();
	}
	
	@PostMapping("/breakEnd")
	public long BreakEnd(@RequestBody BreakTimeVO vo) {

		System.out.println("BreakEnd");
		System.out.println(vo);
		int value=wDAO.BreakEnd(vo);
		System.out.println("value");
		System.out.println(vo.getBREAK_TIME());
		long time=vo.getBREAK_TIME();
		return vo.getBREAK_TIME();
	}

	
}
