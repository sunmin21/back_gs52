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
		
		for (MultipartFile uploadFile : vo.getFILES()) {
//			if(uploadFile.getContentType().startsWith("image")==false) {
//				return 0;
//			}  //이미지만 띄우고 싶을때 
			String originalName = uploadFile.getOriginalFilename();
			String fileName = originalName.substring(originalName.lastIndexOf("\\")+1); 
			String folderPath = makeFolder();
			String uuid = UUID.randomUUID().toString();
			String saveName = uploadPath + File.separator + folderPath + File.separator +uuid+"_"+ fileName;
		    System.out.println("여기냐2");
            System.out.println(saveName);
			Path savePath  = Paths.get(saveName);
		    System.out.println("여기냐");
		     System.out.println(savePath);
		    try {
		    	System.out.println("에러");
		    	uploadFile.transferTo(savePath);
		    	System.out.println("에러2");
		    }catch(IOException e){
		    
		    	e.printStackTrace();
		    }
		}
		return 0;
//		return pDAO.insertProject(vo);
	}
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		String folderPath = str.replace("/", File.separator);
		//make folder
		File uploadPathFolder = new File(uploadPath, folderPath);
		if (uploadPathFolder.exists()==false) {
			uploadPathFolder.mkdirs();
		}
		return folderPath;
	}
	
}
