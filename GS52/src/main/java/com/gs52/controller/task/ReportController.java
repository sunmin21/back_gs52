package com.gs52.controller.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.task.ReportDAO;
import com.gs52.vo.task.ReportVO;

@RestController
@RequestMapping(value="/report")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReportController {
	
	@Autowired
	public ReportDAO rDAO = null;
	
	@PostMapping("/showReport")
	public List<ReportVO> ReportBoard(@RequestBody ReportVO vo) {
		System.out.println("spring => report");
		System.out.println(vo);
		return rDAO.selectList(vo);
	}
	
	@PostMapping("/addReport")
	public void addReport(@RequestBody ReportVO vo) {
		System.out.println("addReport =========");
		rDAO.addReport(vo);
	}
	
	@PostMapping("/delReport")
	public void delReport(@RequestBody ReportVO vo) {
		System.out.println("delReport =========");
		rDAO.delReport(vo.getREPORT_INDEX());
	}
	
	@PostMapping("/empList")
	public List<ReportVO> empList(@RequestBody ReportVO vo) {
		System.out.println("empList =========");
		System.out.println(vo);
		return rDAO.selectEmpList(vo);
	}
}
