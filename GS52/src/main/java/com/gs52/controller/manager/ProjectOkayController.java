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
		return plDAO.selectList(vo);
	}
}