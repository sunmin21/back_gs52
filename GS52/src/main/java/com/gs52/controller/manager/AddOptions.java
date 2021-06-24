package com.gs52.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.manager.AddOptionsDAO;
import com.gs52.dao.manager.HolidayDAO;
import com.gs52.vo.emp.DeptVO;
import com.gs52.vo.emp.TeamVO;
import com.gs52.vo.manager.HolidayVO;

@RestController
@RequestMapping(value="/manager")
public class AddOptions {

	@Autowired
	public AddOptionsDAO aDAO = null;
	
	@GetMapping("/addoptions/dept")
	public List<DeptVO> DeptSelect() {
		
		
		return aDAO.selectListDept();
	}
	
	@PostMapping("/addoptions/deptDelete")
	public int DeptDelete(@RequestBody DeptVO vo) {
			
		
		return aDAO.deleteDept(vo.getDEPT_INDEX());
	}
	
	@PostMapping("/addoptions/deptUpdate")
	public int deptUpdate(@RequestBody DeptVO vo) {
		
		return aDAO.updateDept(vo);
	}
	
	@PostMapping("/addoptions/deptInsert")
	public int deptInsert(@RequestBody DeptVO vo) {
		System.out.println(vo);
		return aDAO.insertDept(vo);
	}
	
	@GetMapping("/addoptions/team")
	public List<TeamVO> TeamSelect() {
	
		return aDAO.selectListTeam();
	}
	@PostMapping("/addoptions/teamDelete")
	public int TeamDelete(@RequestBody TeamVO vo) {
			
		System.out.println(vo.getTEAM_INDEX());
		return aDAO.deleteTeam(vo.getTEAM_INDEX());
	}
}