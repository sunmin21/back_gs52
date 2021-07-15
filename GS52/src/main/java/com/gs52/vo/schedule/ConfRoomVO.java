package com.gs52.vo.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //DTO 코드를 자동으로 Generate (Getter, Setter, toString, default 생성자)
@NoArgsConstructor // 기본생성자
@AllArgsConstructor //모든 속성을 파라미터로 갖는 생성자
public class ConfRoomVO {

	private long CONF_ROOM_INDEX=0L;
	private long CONF_ROOM_FLOOR=0L;
	private long CONF_ROOM_NUMBER=0L;
	private int CONF_ROOM_COUNT=0;
	
}
