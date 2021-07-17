package com.gs52.vo.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class WorkTimeVO {
	long EMP_TEAM_INDEX = 0L;
	long EMP_INDEX = 0L;

	//ATTEND TABLE
	long ATTEND_INDEX = 0L;
	long ATTEND_EMP_INDEX = 0L;						//FK
	String ATTEND_DATE=null;
	String ATTEND_START=null;
	String ATTEND_BREAK=null;
	String ATTEND_END=null;
	long ATTEND_ATTEND_TYPE_INDEX=0L;				//FK
	long ATTEND_TOTAL=0L;
	long ATTEND_TYPE_COUNT=0L;


	//ATTEND_TYPE TABLE
	long ATTEND_TYPE_INDEX=0L;


	//WORK TYPE
	long WORK_TYPE_INDEX=0L;
	String WORK_TYPE_NAME=null;


	//WORK_RULE
	long WORK_RULE_INDEX=0L;
	long WORK_RULE_WORK_TYPE_INDEX=0L;				//FK
	String WORK_RULE_START=null;
	String WORK_RULE_END=null;
	String WORK_RULE_BREAK=null;
	String WORK_RULE_AVG_HOUR=null;

	//user team index 가져올수 있음.
	//team 테이블에서 index 찾아서 그 행의 근무유형 값을 가져오면 됨.

}
