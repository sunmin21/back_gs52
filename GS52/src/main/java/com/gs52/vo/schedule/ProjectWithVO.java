package com.gs52.vo.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gs52.vo.manager.DeptVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 속성을 파라미터로 갖는 생성자

public class ProjectWithVO {

	long PROJECT_INDEX = 0L;

	
	long PROJECT_WITH_INDEX =0L;
	long PROJECT_WITH_EMP_INDEX= 0L;
    int PROJECT_WITH_OKAY=0 ;
    String PROJECT_WITH_REJECT= null;
    int  PROJECT_WITH_LEADER= 0;
    float  PROJECT_WITH_SCORE =0;
    String 	PROJECT_WITH_COLOR =null;
    String EMP_NAME= null;
    String TEAM_NAME= null;
    String  DEPT_NAME =null;
}
