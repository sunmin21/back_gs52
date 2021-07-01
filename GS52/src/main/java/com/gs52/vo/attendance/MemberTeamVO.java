package com.gs52.vo.attendance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class MemberTeamVO {

	
	private int TEAM_INDEX=0;
	private int TEAM_DEPT_INDEX =0;
	private String TEAM_NAME = null;
	private int TEAM_WORK_TYPE = 0;
	private String DEPT_NAME = null;
	
   
	
}
