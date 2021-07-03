package com.gs52.controller.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.emp.empDAO;
import com.gs52.vo.emp.EmpVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/emp")
public class EmpController {

	@Autowired
	public empDAO  eDAO = null;
	
	@GetMapping(value="/listAll")
	public List<EmpVO> selectListUser() {
  
	
		return eDAO.selectListEmp();
		
	}
	@GetMapping(value="/login")
	public void login(@RequestBody EmpVO vo) {
	
		System.out.println(vo);
		
	}
	
}
