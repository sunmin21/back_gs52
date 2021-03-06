package com.gs52.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.manager.RegistDAO;
import com.gs52.vo.manager.RegistVO;

@RestController
@RequestMapping(value="/manager")
public class RegistController {
 
	@Autowired
	public RegistDAO  rDAO = null;
	

	@GetMapping("/select_dept")
	public List<RegistVO> selectDept() {

		System.out.println("selectDept"); 
		System.out.println(rDAO.selectList()); 
	return rDAO.selectList();
	}
	
	
	@PostMapping("/regist")
	public int insertConf(@RequestBody RegistVO vo) {
		System.out.println("insertConf"); 
		System.out.println(vo);
		return rDAO.insertRegist(vo);
	}
	
}
