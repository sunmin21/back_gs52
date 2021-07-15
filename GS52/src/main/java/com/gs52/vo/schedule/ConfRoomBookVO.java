package com.gs52.vo.schedule;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class ConfRoomBookVO {
	private long CONF_INDEX=0L;
	private String CONF_TITLE=null;
	private long CONF_ROOM_INDEX=0L;
	private String CONF_DATE=null;
	private String CONF_START=null;
	private String CONF_END=null;
	private long CONF_EMP_INDEX_SEND=0L;
	
	
	private long CONF_RE_INDEX=0L;
	private long CONF_RE_EMP_INDEX=0L;
	private long CONF_RE_CONF_INDEX=0L; 
	
	private String EMP_NAME=null;
	private long CONF_ROOM_FLOOR=0L;
	private long CONF_ROOM_NUMBER=0L;
	
	private List<Map> person;
	
}
