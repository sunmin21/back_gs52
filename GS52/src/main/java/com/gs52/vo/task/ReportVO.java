package com.gs52.vo.task;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportVO {
	private int REPORT_INDEX = 0;
	private int REPORT_EMP_INDEX = 0;
	private String REPORT_CONTENTS = null;
	private String REPORT_TARGET_DATE = null;
	
	private String WEEKSTART = null;
	private String WEEKEND = null;
}
