package com.gs52.vo.task;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportVO {
	private int REPORT_INDEX = 0;
	private int REPORT_EMP_INDEX = 0;
	private String REPORT_CONTENTS = null;
	private String REPORT_TARGET_DATE = null;
	
	private String WEEKSTART = null;
	private String WEEKEND = null;
	
	// 팀원 조회를 위해 필요한 부분
	private int EMP_INDEX = 0;
	private String EMP_NAME = null;
	private String DEPT_NAME = null;
	private String TEAM_NAME = null;
	private String POSITION_NAME = null;
	private String RANK_NAME = null;
}
