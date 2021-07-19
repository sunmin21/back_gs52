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
import com.gs52.vo.attendance.AnnualManageVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/annual")
public class AnnualManageController {
 	
	private final AnnualManageDAO aDAO;
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	public AnnualManageController(AnnualManageDAO aDAO) {
		this.aDAO = aDAO;
	}
	
	@PostMapping("/near")
	public List<AnnualManageVO> NearBoard(@RequestBody AnnualManageVO vo) {
	System.out.println(aDAO.selectNear(vo.getVACATION_EMP_INDEX()));
	return aDAO.selectNear(vo.getVACATION_EMP_INDEX());
	}


	@PostMapping("/select")
	public List<AnnualManageVO> TestBoard(@RequestBody AnnualManageVO vo) {
	System.out.println(aDAO.selectList(vo.getVACATION_EMP_INDEX()));
	return aDAO.selectList(vo.getVACATION_EMP_INDEX());
	}
	
	@PostMapping("/select2")
	public List<AnnualManageVO> EmpBoard(@RequestBody AnnualManageVO vo) {
		log.info("\n"+ aDAO.selectOne(vo.getVACATION_EMP_INDEX()));
		return aDAO.selectOne(vo.getVACATION_EMP_INDEX());
		} 
	
	@PostMapping("/insert")
	public void insertBoard(@RequestBody AnnualManageVO vo){
		aDAO.insertAnnual(vo);
	}
	
	@PostMapping("/delete")
	public void deleteBoard(@RequestBody AnnualManageVO vo) {
		aDAO.deleteAttend(vo);
		aDAO.deleteAnnual(vo);
	}
	
	@PostMapping("/update")
	public void updateBoard(@RequestBody AnnualManageVO vo) {
		aDAO.updateAnnual(vo);
	}
	
}
