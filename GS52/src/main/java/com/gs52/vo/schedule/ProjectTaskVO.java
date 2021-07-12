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

public class ProjectTaskVO {

	long PROJECT_TASK_INDEX= 0L;
	
	long PROJECT_INDEX=0L;
	int PROJECT_TASK_SUCCESS=0;
	int PROJECT_TASK_PERCENT=0; 
	String PROJECT_TASK_CONTENT = null;
	int PERCENT_SUM  = 0;
	int DETAIL_SUM = 0;
	int DETAIL_SUCCESS_SUM=0;
	long PROJECT_TASK_DETAIL_INDEX =0L;
}
