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
import com.gs52.vo.schedule.ProjectTaskDetailVO;
import com.gs52.vo.schedule.ProjectTaskVO;
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


	 pDAO.updateProjectWith(vo);
	
	}
	
	@PostMapping(value="/project/insertProjectTodo")
	public void insertProjectTodo(@RequestBody ProjectTaskVO vo) {


	 pDAO.insertProjectTodo(vo);
	
	  }
	@PostMapping(value="/project/updateProjectTodo")
	public void updateProjectTodo(@RequestBody ProjectTaskVO vo) {

   System.out.println("너왔냐");
   System.out.println("업데이트가된거가?");
   System.out.println(vo);
	 pDAO.updateProjectTodo(vo);
	
	  }
	
	@PostMapping(value="/project/selectTask")
	public List<ProjectTaskVO>  selectTodo(@RequestBody ProjectTaskVO vo) {
      
	
		return pDAO.selectTask(vo);
	}
	@PostMapping(value="/project/selectTaskDetail")
	public List<ProjectTaskVO>  selectTaskDetail(@RequestBody ProjectTaskDetailVO vo) {
      
	
		return pDAO.selectTaskDetail(vo);
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
