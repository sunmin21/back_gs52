package com.gs52.controller.attendance;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.attendance.AnnualManageDAO;
import com.gs52.dao.attendance.PersonInsightDAO;
import com.gs52.vo.attendance.AnnualManageVO;
import com.gs52.vo.attendance.PersonInsightVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/insight")
public class PersonInsightController {
 	
	private final PersonInsightDAO piDAO;
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	public PersonInsightController(PersonInsightDAO piDAO) {
		this.piDAO = piDAO;
	}
	
	
	@PostMapping("/selectempentrydate")
	public List<PersonInsightVO> TestBoard(@RequestBody PersonInsightVO vo) {
	
	return piDAO.selectList(vo.getEMP_INDEX());
	}
	
	
	@PostMapping("/selectprojectcount")
	public List<PersonInsightVO> ProjectCountBoard(@RequestBody PersonInsightVO vo) {
	
	return piDAO.selectProjectCount(vo.getEMP_INDEX());
	}
	
	@PostMapping("/selecttodocount")
	public List<PersonInsightVO> TodoCountBoard(@RequestBody PersonInsightVO vo) {
	
	return piDAO.selectTodoCount(vo.getEMP_INDEX());
	}
	
	@PostMapping("/selectbusinesscount")
	public List<PersonInsightVO> BusinessCountBoard(@RequestBody PersonInsightVO vo) {
	
	return piDAO.selectBusinessCount(vo.getEMP_INDEX());
	}
	
	@PostMapping("/selectreportcount")
	public List<PersonInsightVO> ReportCountBoard(@RequestBody PersonInsightVO vo) {
	
	return piDAO.selectReportCount(vo.getEMP_INDEX());
	}
	
	
	@PostMapping("/selectworktime")
	public List<PersonInsightVO> WorkTimeBoard(@RequestBody PersonInsightVO vo) {
	
	return piDAO.selectWorkTime(vo.getEMP_INDEX());
	}
	
	@PostMapping("/selectpersoninsight")
	public List<PersonInsightVO> PersonInsightBoard(@RequestBody PersonInsightVO vo) { 
		System.out.println("오나" + piDAO.selectPersonInsight());
	return piDAO.selectPersonInsight();
	}
	
	
}
