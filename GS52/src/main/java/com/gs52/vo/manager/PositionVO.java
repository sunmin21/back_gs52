package com.gs52.vo.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class PositionVO {
	//EMP_TEAM_INDEX, EMP_RANK_INDEX, EMP_POSITION_INDEX, EMP_ID, EMP_ENTRY_DATE

	private long POSITION_INDEX=0L;
	private String POSITION_NAME=null;
	
}
