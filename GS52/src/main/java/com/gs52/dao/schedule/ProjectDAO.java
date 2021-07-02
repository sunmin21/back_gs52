package com.gs52.dao.schedule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.gs52.vo.manager.RegistVO;
import com.gs52.vo.schedual.ProjectVO;


@Service  
@Transactional // 실패하면 다시 롤백하라
public class ProjectDAO {

	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	
	@Value("${org.zerock.upload.path}") 
	
	private String uploadPath;
	
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

	public int insertProject(@RequestBody ProjectVO vo){
		System.out.println(sqlFacotry.openSession().insert("Project.insertProject", vo));
		System.out.println("인설트후");
    
		int projectIndex = sqlFacotry.openSession().selectOne("Project.selectIndex", vo);
		vo.setPROJECT_INDEX(projectIndex);
	   for (int  emp : vo.getPROJECT_WITH_EMP_INDEXS()) {
		 
		   vo.setPROJECT_WITH_EMP_INDEX(emp);
		   System.out.println(vo);
		 sqlFacotry.openSession().insert("Project.insertEmpWith", vo);
	   }
          
	   			//첨부파일 추가
	   if(vo.getFILES().length >=1) {
	 		for (MultipartFile uploadFile : vo.getFILES()) {
//	 			if(uploadFile.getContentType().startsWith("image")==false) {
//	 				return 0;
//	 			}  //이미지만 띄우고 싶을때 
	 			
	 			
	 			String originalName = uploadFile.getOriginalFilename();
	 			
	 			String fileName = originalName.substring(originalName.lastIndexOf("\\")+1); 
	 			String folderPath = makeFolder();
	 			String uuid = UUID.randomUUID().toString();
	 			String saveName = uploadPath + File.separator + folderPath + File.separator +uuid+"_"+ fileName;
	 		    
	 			Path savePath  = Paths.get(saveName);
	 			
	 		   vo.setPROJECT_FILE_ORIGIN_NAME(fileName);
	 		   vo.setPROJECT_FILE_NAME(uuid+"_"+fileName);
	 		   vo.setPROJECT_FILE_PATH(saveName);
	 		   vo.setPROJECT_FILE_DATE(vo.getPROJECT_DATE());
	 			System.out.println(originalName);
	 			System.out.println(fileName);
	 		     System.out.println(savePath);
	 		    try {
	 		    	System.out.println("에러");
	 		    	uploadFile.transferTo(savePath);
	 		    	sqlFacotry.openSession().insert("Project.insertProjectFile", vo);
	 		    	System.out.println("에러2");
	 		    }catch(IOException e){
	 		    
	 		    	e.printStackTrace();
	 		    }
	 		}
	   }
		return sqlFacotry.openSession().insert("Project.insertProjectFile", vo);	
//		 return sqlFacotry.openSession().insert("inform.Insert_Inform", vo);
	}
	
}