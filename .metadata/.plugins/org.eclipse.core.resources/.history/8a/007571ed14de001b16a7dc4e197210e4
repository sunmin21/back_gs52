package com.gs52.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.manager.AddOptionsDAO;
import com.gs52.vo.emp.DeptVO;
import com.gs52.vo.emp.TeamVO;
import com.gs52.vo.emp.WorkRuleVO;
import com.gs52.vo.schedule.ConfRoomVO;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/manager")
public class AddOptions {

	@Autowired
	public AddOptionsDAO aDAO = null;
	
	@GetMapping("/addoptions/dept")
	public List<DeptVO> DeptSelect() {
		
		
		return aDAO.selectListDept();
	}
	@PostMapping("/addoptions/deptCheck")
	public int DeptCheckSelect(@RequestBody DeptVO vo) {
		
	
		return aDAO.selectChecktDept(vo);
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

		return aDAO.insertDept(vo);
	}
	
	@GetMapping("/addoptions/team")
	public List<TeamVO> TeamSelect() {
	
		return aDAO.selectListTeam();
	}
	
	@PostMapping("/addoptions/teamCheck")
	public int TeamCheck(@RequestBody TeamVO vo) {
			

		return aDAO.selectCheckTeam(vo);
	}
	@GetMapping("/addoptions/workRule")
	public List<WorkRuleVO> workRuleSelect() {
	
		return aDAO.selectListWorkRule();
	}
	
	
	@PostMapping("/addoptions/teamDelete")
	public int TeamDelete(@RequestBody TeamVO vo) {
			
	
		return aDAO.deleteTeam(vo.getTEAM_INDEX());
	}
	@PostMapping("/addoptions/teamUpdate")
	public int TeamUpdate(@RequestBody TeamVO vo) {
			
		
		return aDAO.updateTeam(vo);
	}
	@PostMapping("/addoptions/teamInsert")
	public int teamInsert(@RequestBody TeamVO vo) {
		
		return aDAO.insertTeam(vo);
	}
	
	@GetMapping("/addoptions/workType")
	public List<WorkRuleVO> workTypeSelect() {
	 
		return aDAO.selectListWorkType();
	}
	
	@PostMapping("/addoptions/workRuleCheck")
	public int workRuleCheck(@RequestBody WorkRuleVO vo) {
	
		return aDAO.selectCheckWorkRule(vo);
	
	}
	@PostMapping("/addoptions/workRuleUpdate")
	public int workRuleUpdate(@RequestBody WorkRuleVO vo) {

		
		return aDAO.updateWorkRule(vo);
	
	}
	
	@PostMapping("/addoptions/workRuleDelete")
	public int workRuleDelete(@RequestBody WorkRuleVO vo) {

		return aDAO.deleteWorkRule(vo.getWORK_RULE_INDEX());
	}
	
	@PostMapping("/addoptions/workRuleInsert")
	public int workRuleInsert(@RequestBody WorkRuleVO vo) {
		
		return aDAO.insertWorkRule(vo);
	}
	@GetMapping("/addoptions/confRoom")
	public List<ConfRoomVO> ConfRoomSelect() {
		
		
		return aDAO.selectListConf();
	}
	
	@PostMapping("/addoptions/confRoomCheck")
	public int confRoomCheck(@RequestBody ConfRoomVO vo) {

		return aDAO.selectCheckConfRoom(vo);
	}
	@PostMapping("/addoptions/confRoomDelete")
	public int confRoomDelete(@RequestBody ConfRoomVO vo) {

		return aDAO.deleteConfRoom(vo.getCONF_ROOM_INDEX());
	}
	@PostMapping("/addoptions/confRoomUpdate")
	public int confRoomUpdate(@RequestBody ConfRoomVO vo) {

		
		return aDAO.updateConfRoom(vo);
	
	}
	@PostMapping("/addoptions/confRoomInsert")
	public int confRoomInsert(@RequestBody ConfRoomVO vo) {
	
		
		return aDAO.insertConfRoom(vo);
	}
	
}