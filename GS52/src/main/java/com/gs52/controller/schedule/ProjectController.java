package com.gs52.controller.schedule;




import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gs52.dao.schedule.ProjectDAO;
import com.gs52.dao.task.BusinessProgressDAO;
import com.gs52.vo.schedule.ProjectFileVO;
import com.gs52.vo.schedule.ProjectSelectVO;
import com.gs52.vo.schedule.ProjectVO;
import com.gs52.vo.schedule.ProjectWithVO;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/schedule")
public class ProjectController {
	@Autowired
	public ProjectDAO pDAO = null;
	@Value("${org.zerock.upload.path}") 
	private String uploadPath;
	
	@PostMapping(value="/project/insertproject")
	public int  insertProject(@ModelAttribute ProjectVO vo) {

	
		return pDAO.insertProject(vo);
	}
	
	@PostMapping(value="/project/updateproject")
	public int   updateProject(@ModelAttribute ProjectVO vo) {

	
		return pDAO.updateProject(vo);
	}
	
	@PostMapping(value="/project/updateprojectWith")
	public void updateProjectWith(@RequestBody ProjectWithVO vo) {

	System.out.println("이거타냐?뭐지이거");
	System.out.println( pDAO.updateProjectWith(vo));
	System.out.println("이거다이거");
	}
	
	@PostMapping(value="/project/selectOneProject")
	public ProjectSelectVO  selectOneProject(@RequestBody ProjectSelectVO vo) {
      
	
		return pDAO.selectOneProject(vo);
	}

	@PostMapping(value="/project/selectOneProjectWith")
	public List<ProjectWithVO>  selectOneProjectWith(@RequestBody ProjectWithVO vo) {
      

		return pDAO.selectOneProjectWith(vo);
	}
	
	@PostMapping(value="/project/selectOneProjectFile")
	public List<ProjectWithVO>  selectOneProjectFile(@RequestBody ProjectFileVO vo) {
      
	
		return pDAO.selectOneProjectFile(vo);
	}


	
}
