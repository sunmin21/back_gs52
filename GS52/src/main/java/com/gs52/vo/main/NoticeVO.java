package com.gs52.vo.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class NoticeVO {

	long NOTICE_INDEX = 0L;
	String NOTICE_TITLE=null;
	String NOTICE_CONTENTS=null;
	long NOTICE_EMP_INDEX=0L;
	String NOTICE_DATE=null;
	String EMP_NAME = null;
}
