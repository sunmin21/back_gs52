package com.gs52.vo.emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class DeptVO {
	int DEPT_INDEX =0;
	String DEPT_NAME= null;
	int TEAM_COUNT=0;
	
}
