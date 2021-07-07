package com.gs52.vo.schedule;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class ConfReVO {

	//private long CONF_RE_INDEX=0L;
	private List<Integer> CONF_RE_EMP_INDEX;
	private long CONF_RE_CONF_INDEX=0L;
	
}
