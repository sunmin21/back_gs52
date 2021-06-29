package com.gs52.vo.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class TodoBoardVO {
  
	
	int TODO_INDEX = 0;
	int TODO_EMP_ID_SEND= 0;
	int TODO_EMP_ID_RECEIVCE=0;
	int TODO_DONE=0;
	String TODO_TITLE=null;
	String TODO_CONTENTS=null;
	String TODO_START_DATE=null;
	String TODO_END_DATE=null;
	
}
