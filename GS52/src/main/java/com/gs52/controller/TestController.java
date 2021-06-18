package com.gs52.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.TestDAO;
import com.gs52.vo.TestVO;

@RestController
@RequestMapping(value="/test")
public class TestController {
 
	@Autowired
	public TestDAO  tDAO = null;
	@PostMapping("/t")
	public List<TestVO> TestBoard() {
	
	System.out.println(tDAO.selectList()); 
	
	return tDAO.selectList();
	}
	
}
