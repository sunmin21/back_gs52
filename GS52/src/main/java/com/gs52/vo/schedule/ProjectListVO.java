package com.gs52.vo.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectListVO {
	private int EMP_INDEX=0;
	
	// project 테이블 컬럼들
	private int PROJECT_INDEX = 0;
	private String PROJECT_TITLE = null;
	private String PROJECT_CONTENT = null;
	private String PROJECT_START = null;
	private String PROJECT_END = null;
	private int PROJECT_OKAY = 0;
	private String PROJECT_DATE = null;
	
	// projcet_with 테이블 컬럼들
	private int PROJECT_WITH_INDEX = 0;
	private int PROJECT_WITH_EMP_INDEX = 0;
	private int PROJECT_WITH_OKAY = 0;
	private String PROJECT_WITH_REJECT = null;
	private int PROJECT_WITH_LEADER = 0;
     
	private String EMP_NAME = null;	
}
