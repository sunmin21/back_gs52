package com.gs52.controller.schedule;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.attendance.AnnualManageDAO;
import com.gs52.dao.attendance.PersonInsightDAO;
import com.gs52.dao.schedule.TeamInsightDAO;
import com.gs52.vo.attendance.AnnualManageVO;
import com.gs52.vo.attendance.PersonInsightVO;
import com.gs52.vo.schedule.TeamInsightVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/insight")
public class TeamInsightController {
 	
	private final TeamInsightDAO tiDAO;
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	public TeamInsightController(TeamInsightDAO tiDAO) {
		this.tiDAO = tiDAO;
	}
	
	
	@PostMapping("/selectteamentrydate")
	public List<TeamInsightVO> TestBoard(@RequestBody TeamInsightVO vo) {
	
	return tiDAO.selectList(vo.getEMP_TEAM_INDEX());
	}
	
	@PostMapping("/selectteamproject")
	public List<TeamInsightVO> TeamProject(@RequestBody TeamInsightVO vo) {
	System.out.println("!!"+tiDAO.selectProjectList(vo.getEMP_TEAM_INDEX()));
	return tiDAO.selectProjectList(vo.getEMP_TEAM_INDEX());
	}
	
	@PostMapping("/selectteamtodo")
	public List<TeamInsightVO> TeamTodo(@RequestBody TeamInsightVO vo) {
	System.out.println("!!"+tiDAO.selectTodoList(vo.getEMP_TEAM_INDEX()));
	return tiDAO.selectTodoList(vo.getEMP_TEAM_INDEX());
	}
	
	@PostMapping("/selectteambusiness")
	public List<TeamInsightVO> TeamBusiness(@RequestBody TeamInsightVO vo) {
	System.out.println("!!"+tiDAO.selectBusinessList(vo.getEMP_TEAM_INDEX()));
	return tiDAO.selectBusinessList(vo.getEMP_TEAM_INDEX());
	}
	
	@PostMapping("/selectteamreport")
	public List<TeamInsightVO> TeamReport(@RequestBody TeamInsightVO vo) {
	System.out.println("!!"+tiDAO.selectReportList(vo.getEMP_TEAM_INDEX()));
	return tiDAO.selectReportList(vo.getEMP_TEAM_INDEX());
	}
	
	
	@PostMapping("/selectteamworktime")
	public List<TeamInsightVO> TeamWorkTime(@RequestBody TeamInsightVO vo) {
	System.out.println("!!"+tiDAO.selectWorkTimeList(vo.getEMP_TEAM_INDEX()));
	return tiDAO.selectWorkTimeList(vo.getEMP_TEAM_INDEX());
	}
	
	
	
	
}
