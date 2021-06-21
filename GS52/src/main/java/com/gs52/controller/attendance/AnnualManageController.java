package com.gs52.controller.attendance;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.attendance.AnnualManageDAO;
import com.gs52.vo.attendance.AnnualManageVO;


@RestController
@RequestMapping(value="/annual")
public class AnnualManageController {
 
	@Autowired
	public AnnualManageDAO  aDAO = null;
	@PostMapping("/select")
	public List<AnnualManageVO> TestBoard(@RequestBody AnnualManageVO vo) {
	System.out.println(aDAO.selectList(vo.getVACATION_EMP_ID()));
	return aDAO.selectList(vo.getVACATION_EMP_ID());
	}
	
	@PostMapping("/insert")
	public void insertBoard(@RequestBody AnnualManageVO vo){
		System.out.println("insert====");
		System.out.println(vo);
		aDAO.insertAnnual(vo);
		
	}
	
	@PostMapping("/delete")
	public void deleteBoard(@RequestBody AnnualManageVO vo) {
		System.out.println(vo.getVACATION_INDEX());
		aDAO.deleteAnnual(vo.getVACATION_INDEX());
	}
	
}
