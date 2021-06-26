package com.gs52.vo.emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class WorkRuleVO {
	long WORK_RULE_INDEX = 0L;
	long WORK_RULE_WORK_TYPE_INDEX =0L;
	String WORK_RULE_NAME =null;
	String WORK_RULE_START = null;
	String WORK_RULE_END =null;
	String WORK_RULE_BREAK =null;
	long WORK_RULE_AVG_HOUR =0L;
	String WORK_TYPE_NAME =null;
	long WORK_TYPE_INDEX =0L;
	long TEAM_COUNT=0L;
}
