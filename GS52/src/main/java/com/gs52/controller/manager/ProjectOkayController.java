package com.gs52.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.manager.ProjectOkayDAO;
import com.gs52.vo.schedule.ProjectListVO;

@RestController
@RequestMapping(value="/manager/project")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectOkayController {
	
	@Autowired
	public ProjectOkayDAO plDAO = null;

	@PostMapping("/selectOkay")
	public List<ProjectListVO> ProjectListBoard(@RequestBody ProjectListVO vo) {
		System.out.println("spring => selectOkay");
		System.out.println(vo);		
		System.out.println(vo.getPROJECT_INDEX());
		return plDAO.selectList(vo);
	}
	
	
	@PostMapping("/selectOkay_teamLeader")
	public List<ProjectListVO> ProjectListBoard_teamLeader(@RequestBody ProjectListVO vo) {
		System.out.println("spring => electOkay_teamLeader");
		System.out.println(vo);		
		return plDAO.selectList_teamLeader(vo);
	}
	
	@PostMapping("/updateOkay")
	public void updateOkay(@RequestBody ProjectListVO vo) {
		System.out.println(vo);
		plDAO.updateOkay(vo);
	}
	@PostMapping("/selectAll")
	public List<ProjectListVO> selectAll(@RequestBody ProjectListVO vo) {
		System.out.println("spring => selectAll");
		System.out.println(vo);		
		System.out.println("야야야야");
		return plDAO.selectList2(vo);
	}

}