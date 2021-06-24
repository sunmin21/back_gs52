package com.gs52.vo.emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class TeamVO {
	int TEAM_INDEX =0;
	int TEAM_DEPT_INDEX =0;
	String DEPT_NAME= null;
	String TEAM_NAME =null;
	int PERSON_COUNT=0;
	int TEAM_WORK_TYPE =0;
	String WORK_TYPE_NAME =null;
	
	int WORK_RULE_INDEX =0;
	String WORK_RULE_NAME =null;
    String WORK_RULE_START =null;
    String WORK_RULE_BREAK =null;
    int WORK_RULE_AVG_HOUR=0;
	
}
