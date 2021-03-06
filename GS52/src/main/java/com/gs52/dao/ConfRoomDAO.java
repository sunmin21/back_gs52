package com.gs52.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.ConfRoomBookVO;
import com.gs52.vo.ConfRoomVO;
import com.gs52.vo.emp.EmpVO;

@Service  
@Transactional // 실패하면 다시 롤백하라
public class ConfRoomDAO {

	@Autowired 
	private SqlSessionFactory sqlFacotry =null;

	public int insertList(@RequestBody ConfRoomBookVO vo){
		System.out.println(vo);
		System.out.println("insertList");
		System.out.println(sqlFacotry.toString());
		System.out.println(sqlFacotry.openSession().toString());
		 return sqlFacotry.openSession().insert("ConfRoom.Insert_book", vo);
	}
	
	public List<ConfRoomBookVO> selectList(){
		 return sqlFacotry.openSession().selectList("ConfRoom.Select_book");
	}
	
	
	
	public List<ConfRoomVO> selectRoom(){
		System.out.println("DAO select Room");
		 return sqlFacotry.openSession().selectList("ConfRoom.Select_room");
		 
		 
	}
	public List<EmpVO> selectEmp(){

		System.out.println("selectEmp");
		 return sqlFacotry.openSession().selectList("ConfRoom.Select_emp");
		 
		 
	}
}
