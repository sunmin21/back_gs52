package com.gs52.vo.emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class EmpVO {
	private String EMP_INDEX = null;
	private String EMP_ID = null;
	private String EMP_NAME = null;
	private String EMP_PWD = null;
	private String EMP_EMAIL = null;
	private String EMP_ADDRESS = null;
	private String EMP_PHONE = null;
	private String EMP_BIRTH = null;
	private String EMP_ENTRY_DATE = null;
	private int EMP_RANK_INDEX = 0;
	private String RANK_NAME =null;
	private int EMP_DEPT_INDEX = 0;
	private String DEPT_NAME= null;
	private int EMP_TEAM_INDEX = 0;
	private String TEAM_NAME=null;
	private int EMP_POSITION_INDEX = 0;
	private String POSITION_NAME=null;
	private int EMP_VACATION = 0;
	private String EMP_IMG_PATH=null;
	private String admin ="USER";
}
