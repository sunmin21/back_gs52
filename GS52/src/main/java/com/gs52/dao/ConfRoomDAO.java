package com.gs52.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.ConfRoomVO;

@Service  
@Transactional // 실패하면 다시 롤백하라
public class ConfRoomDAO {

	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	
	public List<ConfRoomVO> selectList(){
			 
		 return sqlFacotry.openSession().selectList("ConfRoom.Select_room");
		 
		 
	}
	public int insertList(@RequestBody ConfRoomVO vo){
		System.out.println(vo);
		System.out.println("insertList");
		System.out.println(sqlFacotry.toString());
		System.out.println(sqlFacotry.openSession().toString());
		 return sqlFacotry.openSession().insert("ConfRoom.Insert_room", vo);
		 
		 
	}
}
