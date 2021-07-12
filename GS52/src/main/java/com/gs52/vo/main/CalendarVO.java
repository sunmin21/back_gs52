package com.gs52.vo.main;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarVO {
	private int EMP_INDEX = 0;
	private String EMP_NAME = null;
	private String ATTEND_DATE = null;
	private String ATTEND_TYPE_NAME = null;
	
	private String CONF_TITLE = null;
	private String CONF_DATE = null;
	private String CONF_START = null;
	private String CONF_END = null;
}
