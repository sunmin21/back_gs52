package com.gs52.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.ConfRoomDAO;
import com.gs52.vo.ConfRoomBookVO;
import com.gs52.vo.ConfRoomVO;
import com.gs52.vo.emp.EmpVO;

@RestController
@RequestMapping(value="/schedule/confRoom")
public class ConfRoomController {
 
	@Autowired
	public ConfRoomDAO  tDAO = null;

	@PostMapping("/insert")
	public int insertConf(@RequestBody ConfRoomBookVO vo) {
		System.out.println("insert Conf");
	return tDAO.insertList(vo);
	}
	
	@GetMapping("/select")
	public List<ConfRoomBookVO> selectConf() {

		System.out.println("select Conf");
	System.out.println(tDAO.selectList()); 
	
	return tDAO.selectList();
	}
	
	
	@GetMapping("/select_room")
	public List<ConfRoomVO> selectRoom() {
		System.out.println("select room");
	return tDAO.selectRoom();
	}
	
	@GetMapping("/select_emp")
	public List<EmpVO> selectEmp(@RequestBody EmpVO vo) {
	
	System.out.println(tDAO.selectEmp()); 
	
	return tDAO.selectEmp();
	}
}
