package com.gs52.vo.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 속성을 파라미터로 갖는 생성자
public class ProjectTaskDetailVO {

	
	long PROJECT_TASK_DETAIL_INDEX =0L;
	
	long PROJECT_TASK_INDEX= 0L;
	String PROJECT_TASK_DETAIL_CONTENT= null;
	int PROJECT_TASK_DETAIL_PERCENT=0; 
	int PERCENT_SUM  = 0;
	long PROJECT_TASK_DETAIL_EMP= 0L;
	long PROJECT_INDEX =0L;
	int PROJECT_TASK_DETAIL_SUCCESS =0;
	String PROJECT_WITH_COLOR =null;
	int DETAIL_SUM =0;
}
