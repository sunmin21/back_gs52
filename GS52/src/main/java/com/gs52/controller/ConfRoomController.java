package com.gs52.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.ConfRoomDAO;
import com.gs52.vo.ConfRoomVO;

@RestController
@RequestMapping(value="/schedule/confRoom")
public class ConfRoomController {
 
	@Autowired
	public ConfRoomDAO  tDAO = null;
//	@GetMapping("/select")
//	public List<ConfRoomVO> selectConf() {
//	
//	System.out.println(tDAO.selectList()); 
//	
//	return tDAO.selectList();
//	}
	@PostMapping("/insert")
	public int insertConf(@RequestBody ConfRoomVO vo) {
	System.out.println("insertConf");
	return tDAO.insertList(vo);
	}
}