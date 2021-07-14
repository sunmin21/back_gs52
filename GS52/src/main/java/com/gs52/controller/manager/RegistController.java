package com.gs52.controller.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.manager.RegistDAO;
import com.gs52.vo.emp.EmpVO;
import com.gs52.vo.manager.PositionVO;
import com.gs52.vo.manager.RankVO;
import com.gs52.vo.manager.RegistVO;
import com.gs52.vo.manager.TeamVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/manager")
public class RegistController {
 
	@Autowired
	public RegistDAO  rDAO = null;
	

	@PostMapping("/select_team")
	public List<TeamVO> selectTeam() {

		System.out.println("selectTeam"); 
		//System.out.println(rDAO.selectTeam()); 
	return rDAO.selectTeam();
	}
	
	@PostMapping("/select_rank")
	public List<RankVO> selectRank() {

		System.out.println("selectRank"); 
		System.out.println(rDAO.selectRank()); 
	return rDAO.selectRank();
	}

	@PostMapping("/select_position")
	public List<PositionVO> selectPosition() {

		System.out.println("selectPosition"); 
		System.out.println(rDAO.selectPosition()); 
	return rDAO.selectPosition();
	}
	

	@PostMapping("/select_emp")
	public List<EmpVO> selectEmp() {

		System.out.println("selectEmp"); 
		System.out.println(rDAO.selectEmp()); 
	return rDAO.selectEmp();
	}
	
	
	@PostMapping("/regist")
	public int insertConf(@RequestBody RegistVO vo) throws ParseException {
		System.out.println("insertConf"); 
		System.out.println(vo);
		return rDAO.insertRegist(vo);
	}
	
}
