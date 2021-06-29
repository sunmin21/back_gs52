package com.gs52.controller.attendance;

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
import com.gs52.vo.attendance.MemberAttendVO;
import com.gs52.vo.attendance.MemberEmpVO;
import com.gs52.vo.attendance.MemberTeamVO;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/member")
public class MemberScheduleController {
 
	private final MemberTeamDAO mtDAO;
	private final MemberEmpDAO  msDAO;
	private final MemberAttendDAO maDAO;
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	public MemberScheduleController(MemberTeamDAO mtDAO, MemberEmpDAO msDAO,MemberAttendDAO maDAO) {
		this.msDAO = msDAO;
		this.mtDAO = mtDAO;
		this.maDAO = maDAO;
	}
	
	@PostMapping("/team")
	public List<MemberTeamVO> TestBoard() {
	log.info("\n"+ mtDAO.selectList());
	System.out.println(mtDAO.selectList());
	return mtDAO.selectList();
	}
	
	@PostMapping("/emp")
	public List<MemberEmpVO> EmpBoard() {
	
		System.out.println(msDAO.selectList());
		return msDAO.selectList();
		} 
	
	
	@PostMapping("/attend")
	public List<MemberAttendVO> AttendBoard(){
		return maDAO.selectList();
	}
	
	
}
