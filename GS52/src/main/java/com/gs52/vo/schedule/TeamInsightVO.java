package com.gs52.vo.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class TeamInsightVO {

	private String EMP_NAME = null;
	private String RANK_NAME = null;
	private int EMP_INDEX = 0;
	private int EMP_TEAM_INDEX = 0;
	
	
	/*------------------------------selectEmpEntryDate----------------------------*/
	
	private String TEAM_ENTRY_COUNT = null;

	
	/*------------------------------selectProjectCount----------------------------*/
	private String TEAM_PROJECT_AVG =null;
	
	/*------------------------------selectTodoCount----------------------------*/
	private String TEAM_TODO_AVG = null;
	
	
	/*------------------------------selectBusinessCount----------------------------*/
	private String TEAM_BUSINESS_AVG = null;
	
	
	/*------------------------------selectReportCount----------------------------*/
	private String TEAM_REPORT_AVG = null;
	
	/*------------------------------selectWorkTime----------------------------*/
	private String TEAM_WORK_TIME = null;
}
