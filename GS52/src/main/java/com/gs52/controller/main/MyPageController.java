package com.gs52.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.main.MyPageDAO;
import com.gs52.vo.emp.EmpVO;
import com.gs52.vo.main.WorkTimeVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/main/MyPage")

public class MyPageController {
	@Autowired
	public MyPageDAO  mDAO = null;
	
	@PostMapping("/selectEmp")
	public List<EmpVO> selectEmp(@RequestBody EmpVO vo){
		System.out.println("selectEmp");
		System.out.println(vo);
		return mDAO.selectEmp(vo);
	}
	
	@PostMapping("/updateInform")
	public int updateInform(@RequestBody EmpVO vo){
		System.out.println("updateInform");
		System.out.println("updateInform");
		System.out.println(vo);
		return mDAO.updateInform(vo);
	}

}
