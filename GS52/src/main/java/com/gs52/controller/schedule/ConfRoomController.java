package com.gs52.controller.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gs52.dao.schedule.ConfRoomDAO;
import com.gs52.vo.emp.EmpVO;
import com.gs52.vo.schedule.ConfReVO;
import com.gs52.vo.schedule.ConfRoomBookVO;
import com.gs52.vo.schedule.ConfRoomVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/schedule/confRoom")
public class ConfRoomController {

	@Autowired
	public ConfRoomDAO  tDAO = null;

	@PostMapping("/insert")
	public void insertConf(@RequestBody ConfRoomBookVO vo) {
		ObjectMapper mapper = new ObjectMapper();

		tDAO.insertList(vo);
		List<Map> lm = vo.getPerson();
		List<Integer> List_emp= new ArrayList<Integer>();
		
		for(int i=0; i<lm.size() ; i++) {
			 String str = lm.get(i).toString();
			 str = str.replace("{id=", "");
			 str = str.replace("}", "");
			 List_emp.add(Integer.parseInt(str.toString()));
		}
		
		ConfReVO crVO = new ConfReVO();
		crVO.setCONF_RE_EMP_INDEX(List_emp);
		crVO.setCONF_RE_CONF_INDEX(tDAO.selectConfSeq());
		tDAO.insertConfRe(crVO);
		
	
	}
	
	@PostMapping("/select_confList")
	public List<ConfRoomBookVO> selectConfList() {

		System.out.println("select Conf");
	
	return tDAO.selectConfList();
	}
	
	
	@PostMapping("/select_room_floor")
	public List<ConfRoomVO> selectRoomFloor() {
		System.out.println("select floor");
	return tDAO.selectRoomFloor();
	}
	
	@PostMapping("/Select_conf_room")
	public List<ConfRoomVO> selectRoom(@RequestBody ConfRoomVO vo) {
		System.out.println("select room");
		System.out.println(vo);
	return tDAO.selectConfRoom(vo);
	}
	
	@PostMapping("/select_emp")
	public List<EmpVO> selectEmp(@RequestBody EmpVO vo) {
	
	System.out.println(tDAO.selectEmp()); 
	
	return tDAO.selectEmp();
	}

	@PostMapping("/delete_conf")
	public int deleteConf(@RequestBody ConfRoomBookVO vo) {
		System.out.println("deleteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		
		System.out.println(vo);
		return tDAO.deleteConf(vo);
	}

	@PostMapping("/select_confOne")
	public List<ConfRoomBookVO> selectConfOne(@RequestBody ConfRoomBookVO vo) {

		System.out.println("selectConfOne");

		System.out.println(vo);
		System.out.println(tDAO.selectConfOne(vo));
	return tDAO.selectConfOne(vo);
	}
	
	@PostMapping("select_confOverlap")
	public List<ConfRoomBookVO> selectConOverlap(@RequestBody ConfRoomBookVO vo) {

		System.out.println("select_confOverlap");

		System.out.println(vo);
	return tDAO.selectConOverlap(vo);
	}
	
}
