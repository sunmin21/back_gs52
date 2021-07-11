package com.gs52.vo.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class BreakTimeVO {
	long BREAK_INDEX = 0L;
	long BREAK_EMP_INDEX = 0L;
	String BREAK_DATE = null;
	String BREAK_START = null;
	String BREAK_END = null;
	long BREAK_TIME = 0L;
}
