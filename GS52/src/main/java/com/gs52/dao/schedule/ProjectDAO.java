package com.gs52.dao.schedule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.gs52.vo.manager.RegistVO;
import com.gs52.vo.schedule.ProjectFileVO;
import com.gs52.vo.schedule.ProjectSelectVO;
import com.gs52.vo.schedule.ProjectTaskDetailVO;
import com.gs52.vo.schedule.ProjectTaskVO;
import com.gs52.vo.schedule.ProjectVO;
import com.gs52.vo.schedule.ProjectWithVO;

import io.jsonwebtoken.Header;
import oracle.sql.BLOB;

@Service
@Transactional // 실패하면 다시 롤백하라
public class ProjectDAO {

	@Autowired
	private SqlSessionFactory sqlFacotry = null;

	@Value("${org.zerock.upload.path}")

	private String uploadPath;

	private String makeFolder(String str) {

		String folderPath = str.replace("/", File.separator);
		
		// make folder
		File uploadPathFolder = new File(uploadPath, folderPath);
		if (uploadPathFolder.exists() == false) {
			uploadPathFolder.mkdirs();
		}
		return folderPath;
	}

	public int insertProject(@RequestBody ProjectVO vo) {
		sqlFacotry.openSession().insert("Project.insertProject", vo);

		int projectIndex = sqlFacotry.openSession().selectOne("Project.selectIndex", vo);
		vo.setPROJECT_INDEX(projectIndex);
		for (int emp : vo.getPROJECT_WITH_EMP_INDEXS()) {

			vo.setPROJECT_WITH_EMP_INDEX(emp);
			if (vo.getPROJECT_WITH_LEADER() == emp) {
				vo.setPROJECT_WITH_OKAY(1);
			} else {
				vo.setPROJECT_WITH_OKAY(0);

			}

			sqlFacotry.openSession().insert("Project.insertEmpWith", vo);
		}

	
		// 첨부파일 추가
		if (vo.getFILES() != null) {

			for (MultipartFile uploadFile : vo.getFILES()) {
//	 			if(uploadFile.getContentType().startsWith("image")==false) {
//	 				return 0;
//	 			}  //이미지만 띄우고 싶을때 
				String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				String originalName = uploadFile.getOriginalFilename();

				String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
				String folderPath = makeFolder(str);
				String uuid = UUID.randomUUID().toString();
				String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
                   
				Path savePath = Paths.get(saveName);
				String ReactPath = folderPath.replace(File.separator,"/"); 
			
				vo.setPROJECT_FILE_ORIGIN_NAME(fileName);
				vo.setPROJECT_FILE_NAME(uuid + "_" + fileName);
				vo.setPROJECT_FILE_PATH(saveName);
				vo.setPROJECT_FILE_DATE(vo.getPROJECT_DATE());
				vo.setPROJECT_REACT_PATH("/upload/"+str+ "/" + uuid + "_" + fileName);

				try {

					uploadFile.transferTo(savePath);
					sqlFacotry.openSession().insert("Project.insertProjectFile", vo);

				} catch (IOException e) {

					e.printStackTrace();
					return 0;
				}
			}
		}
		return 1;
//		 return sqlFacotry.openSession().insert("inform.Insert_Inform", vo);
	}

	public int updateProject(ProjectVO vo) {

		sqlFacotry.openSession().update("Project.updateProject", vo);

//	    
//		int projectIndex = sqlFacotry.openSession().selectOne("Project.selectIndex", vo);
//		vo.setPROJECT_INDEX(projectIndex);
		sqlFacotry.openSession().delete("Project.deleteEmpWith", vo);
		int index =0;
		for (int emp : vo.getPROJECT_WITH_EMP_INDEXS()) {

			System.out.println(vo);
			
			System.out.println(index);
	      vo.setPROJECT_WITH_EMP_INDEX(emp);
		   vo.setPROJECT_WITH_OKAY(vo.getPROJECT_WITH_OKAYS().get(index++));
				
			
	
			sqlFacotry.openSession().insert("Project.insertEmpWith", vo);
		}

		for (String deleteFile : vo.getPROJECT_DELETE_FILES()) {
			File file = new File(deleteFile);
			file.delete();

			sqlFacotry.openSession().insert("Project.deleteFile", deleteFile);

		}

		// 첨부파일 추가
		if (vo.getFILES() != null) {
			for (MultipartFile uploadFile : vo.getFILES()) {
//	 			if(uploadFile.getContentType().startsWith("image")==false) {
//	 				return 0;
//	 			}  //이미지만 띄우고 싶을때 
				String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				String originalName = uploadFile.getOriginalFilename();

				String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
				String folderPath = makeFolder(str);
				String uuid = UUID.randomUUID().toString();
				String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
               
				Path savePath = Paths.get(saveName);
				
				vo.setPROJECT_FILE_ORIGIN_NAME(fileName);
				vo.setPROJECT_FILE_NAME(uuid + "_" + fileName);
				vo.setPROJECT_FILE_PATH(saveName);
				vo.setPROJECT_FILE_DATE(vo.getPROJECT_DATE());
				vo.setPROJECT_REACT_PATH("/upload/"+str+ "/" + uuid + "_" + fileName);
				try {

					uploadFile.transferTo(savePath);
					sqlFacotry.openSession().insert("Project.insertProjectFile", vo);

				} catch (IOException e) {

					e.printStackTrace();
					return 0;
				}
			}
		}
		// TODO Auto-generated method stub
		return 1;
	}
	
	
	public int updateProjectWith(ProjectWithVO vo) {
		// TODO Auto-generated method stub
	
		return sqlFacotry.openSession().update("Project.updateProjectWith", vo);
	}
	public ProjectSelectVO selectOneProject(ProjectSelectVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().selectOne("Project.selectOneProject", vo);
	}

	public List<ProjectWithVO> selectOneProjectWith(ProjectWithVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().selectList("Project.selectOneProjectWith", vo);
	}

	public List<ProjectWithVO> selectOneProjectFile(ProjectFileVO vo) {

		return sqlFacotry.openSession().selectList("Project.selectOneProjectFile", vo);
	}

	public int insertProjectTodo(ProjectTaskVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().insert("Project.insertProjectTodo", vo);
		
	}

	public List<ProjectTaskVO> selectTask(ProjectTaskVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().selectList("Project.selectTask", vo);
	}

	public int updateProjectTodo(ProjectTaskVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().update("Project.updateProjectTodo", vo);
	}

	public List<ProjectTaskVO> selectTaskDetail(ProjectTaskDetailVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().selectList("Project.selectTaskDetail", vo);
	}

	public int deleteProjectTodo(ProjectTaskVO vo) {

		
		
		return sqlFacotry.openSession().delete("Project.deleteProjectTodo", vo);
		
	}

	public int insertprojectTaskDetail(ProjectTaskDetailVO vo) {
		// TODO Auto-generated method stub
		
		return sqlFacotry.openSession().insert("Project.insertprojectTaskDetail", vo);
	}

	public int updateProjecTaskDetailSuccess(ProjectTaskDetailVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().update("Project.updateProjecTaskDetailSuccess", vo);
	}

	public int updateprojectTaskDetail(ProjectTaskDetailVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().update("Project.updateprojectTaskDetail", vo);
	}

	public int deleteProjectTaskDetail(ProjectTaskDetailVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().delete("Project.deleteProjectTaskDetail", vo);
		
	}

	public void deleteProjecTaskAll(ProjectTaskVO vo) {
		// TODO Auto-generated method stub\

		sqlFacotry.openSession().delete("Project.deleteProjectTaskDetailAll", vo);
	}

	public int updateProjectWithScore(ProjectWithVO vo) {
		// TODO Auto-generated method stub
//		return 1;
		
		return sqlFacotry.openSession().update("Project.updateProjectWithScore", vo);
	}

	public float selectProjectWithScore(ProjectWithVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().selectOne("Project.selectProjectWithScore", vo);
	}

	public int deleteproject(ProjectVO vo) {
		// TODO Auto-generated method stub
		System.out.println(vo);
		return sqlFacotry.openSession().delete("Project.deleteProject", vo);
	}

	

}