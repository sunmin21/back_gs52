package com.gs52.vo.attendance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class PersonInsightVO {

	private int EMP_INDEX = 0;
	private String EMP_NAME = null;
	/*------------------------------selectEmpEntryDate----------------------------*/
	private String EMP_ENTRY_DATE = null;
	private String EMP_ENTRY_COUNT = null;

	
	/*------------------------------selectProjectCount----------------------------*/
	private String EMP_PROJECT_COUNT =null;
	
	/*------------------------------selectTodoCount----------------------------*/
	private String EMP_TODO_COUNT = null;
	
	
	/*------------------------------selectBusinessCount----------------------------*/
	private String EMP_BUSINESS_COUNT = null;
	
	
	/*------------------------------selectReportCount----------------------------*/
	private String EMP_REPORT_COUNT = null;
	
	/*------------------------------selectWorkTime----------------------------*/
	private String EMP_WORK_TIME = null;
}
