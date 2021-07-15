package com.gs52.vo.attendance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class MemberAttendVO {

	
	private int EMP_INDEX=0;
	private String EMP_ID =null;
	private String EMP_NAME = null;
	private int EMP_TEAM_INDEX = 0;
	private int ATTEND_INDEX = 0;
	private int ATTEND_EMP_INDEX = 0;
	private String ATTEND_DATE = null;
	private String ATTEND_TYPE_NAME = null;
	private String ATTEND_START = null;
	private String ATTEND_END = null;
	
	
   
	
}
