package com.gs52.controller.schedule;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.attendance.MemberAttendDAO;
import com.gs52.dao.attendance.MemberEmpDAO;
import com.gs52.dao.attendance.MemberTeamDAO;
import com.gs52.dao.schedule.PersonalConfDAO;
import com.gs52.vo.attendance.MemberAttendVO;
import com.gs52.vo.attendance.MemberEmpVO;
import com.gs52.vo.attendance.MemberTeamVO;
import com.gs52.vo.schedule.PersonalConfVO;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/personal")
public class PersonalScheduleController {
 
	private final PersonalConfDAO pDAO;
	
	
	
	
	@Autowired
	public PersonalScheduleController(PersonalConfDAO pDAO) {
		this.pDAO = pDAO;
	
	}
	
	@PostMapping("/confPerson")
	public List<PersonalConfVO> TestBoard() {
	
	
	return pDAO.selectList();
	}
	
	@PostMapping("/confLeader")
	public List<PersonalConfVO> LeaderBoard() {
	System.out.println("@@@");
	System.out.println(pDAO.selectLeaderList());
	return pDAO.selectLeaderList();
	}
	
	
	
}
