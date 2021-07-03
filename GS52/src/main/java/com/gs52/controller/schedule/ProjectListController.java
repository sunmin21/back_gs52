package com.gs52.controller.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.schedule.ProjectListDAO;
import com.gs52.vo.schedule.ProjectListVO;

@RestController
@RequestMapping(value="/project")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectListController {
	
	@Autowired
	public ProjectListDAO plDAO = null;
	
	@PostMapping("/selectProceeding")
	public List<ProjectListVO> ProjectListBoard(@RequestBody ProjectListVO vo) {
		System.out.println("spring => selectProceeding");
		System.out.println(vo);		
		return plDAO.selectList(vo);
	}
}
