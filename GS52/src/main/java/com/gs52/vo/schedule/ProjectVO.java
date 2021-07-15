package com.gs52.vo.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.gs52.vo.manager.DeptVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 속성을 파라미터로 갖는 생성자

public class ProjectVO {
    long EMP_ID =0L;
    
    String EMP_IMG_PATH = null;
    String EMP_IMG_NAME =null;
    
	long PROJECT_INDEX = 0L;

	String PROJECT_TITLE = null;
	String PROJECT_CONTENT = null;
	String PROJECT_START = null;
	String PROJECT_END = null;
	String PROJECT_DATE = null;
	String PROJECT_UPDATE =null;
	int PROJECT_OKAY = 0;  
	
	//팀원 추가
	List<Integer> PROJECT_WITH_EMP_INDEXS = new ArrayList<Integer>();
	List<Integer> PROJECT_WITH_OKAYS = new ArrayList<Integer>();
	long PROJECT_WITH_INDEX =0L;
	long PROJECT_WITH_EMP_INDEX= 0L;
    int PROJECT_WITH_OKAY=0 ;
    String PROJECT_WITH_REJECT= null;
    int  PROJECT_WITH_LEADER= 0;
    String PROJECT_WITH_COLOR =null;
    
    // 첨부파일추가
    MultipartFile[] FILES = null;
    List<String> PROJECT_DELETE_FILES = new ArrayList<String>(); 
    
    long PROJECT_FILE_INDEX =0L;
    long PROJECT_FILE_PROJECT_INDEX =0L;
    String PROJECT_FILE_ORIGIN_NAME =null;
    String PROJECT_FILE_NAME =null;
    String PROJECT_FILE_PATH =null; 
    String PROJECT_FILE_DATE = null;
    String PROJECT_REACT_PATH= null;
}
