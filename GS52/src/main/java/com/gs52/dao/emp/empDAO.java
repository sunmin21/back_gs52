package com.gs52.dao.emp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gs52.vo.emp.EmpVO;
import com.gs52.vo.schedule.ProjectVO;

@Service
@Transactional
public class empDAO {
	@Autowired
	private SqlSessionFactory sqlFacotry = null;
	
	@Value("${org.zerock.upload.path}")

	private String uploadPath;
	public List<EmpVO> selectListEmp() {

		return sqlFacotry.openSession().selectList("emp.selectListUser");

	}

	public EmpVO selectUser(String EMP_ID) {

		return sqlFacotry.openSession().selectOne("emp.selectUser", EMP_ID);

	}

	private void makeFolder() {

	
		
		// make folder
		File uploadPathFolder = new File(uploadPath,"empImages");
		if (uploadPathFolder.exists() == false) {
			uploadPathFolder.mkdirs();
		}
		
	}
	public int updateEmpImg(ProjectVO vo) {
		// TODO Auto-generated method stub

		// 첨부파일 추가
		if (vo.getFILES() != null) {
			for (MultipartFile uploadFile : vo.getFILES()) {
			 			if(uploadFile.getContentType().startsWith("image")==false) {
			 				return 0;
			 			}  //이미지만 띄우고 싶을때 
				
				
				String originalName = uploadFile.getOriginalFilename();

				String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
				 makeFolder();
				String uuid = UUID.randomUUID().toString();
				String saveName = uploadPath + File.separator + "empImages" + File.separator + vo.getEMP_ID() + "_" + fileName;
              
				Path savePath = Paths.get(saveName);
				System.out.println(savePath);
//				vo.setPROJECT_FILE_ORIGIN_NAME(fileName);
//				vo.setPROJECT_FILE_NAME(uuid + "_" + fileName);
//				vo.setPROJECT_FILE_PATH(saveName);
//				vo.setPROJECT_FILE_DATE(vo.getPROJECT_DATE());
				vo.setEMP_IMG_NAME(fileName);
				vo.setEMP_IMG_PATH("/upload/" + "empImages" + "/" + vo.getEMP_ID() + "_" + fileName);
				
				try {

					uploadFile.transferTo(savePath);
					System.out.println(vo);
					sqlFacotry.openSession().update("emp.updateEmpImgFile", vo);

				} catch (IOException e) {

					e.printStackTrace();
					return 0;
				}
			}
		}
		return 0;
	}
}
