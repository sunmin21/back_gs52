package com.gs52.vo.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HolidayVO {
	private int HOLIDAY_INDEX = 0;
	private String HOLIDAY_DATE = null;
	private String HOLIDAY_TITLE = null;
	private int HOLIDAY_ANNUAL_REPEAT = 0;
}
