package com.gs52.controller.schedule;




import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.gs52.vo.schedual.ProjectVO;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/schedule")
public class ProjectController {
	@Autowired
	public ProjectDAO pDAO = null;
	@Value("${org.zerock.upload.path}") 
	private String uploadPath;
	
	@PostMapping(value="/project/insertproject")
	public int  selectListTodo(@ModelAttribute ProjectVO vo) {
	
		
		//프로젝트 추가 
		
		
		
	
		return pDAO.insertProject(vo);
	}

	
}
