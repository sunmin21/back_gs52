package com.gs52.dao.schedule;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.emp.EmpVO;
import com.gs52.vo.schedule.ConfReVO;
import com.gs52.vo.schedule.ConfRoomBookVO;
import com.gs52.vo.schedule.ConfRoomVO;

@Service  
@Transactional // 실패하면 다시 롤백하라
public class ConfRoomDAO {

	@Autowired 
	private SqlSessionFactory sqlFacotry =null;

	public int insertList(@RequestBody ConfRoomBookVO vo){
		System.out.println("insertList");
		 return sqlFacotry.openSession().insert("ConfRoom.Insert_book", vo);
	}
	
	public int selectConfSeq(){
		 return sqlFacotry.openSession().selectOne("ConfRoom.Select_conf_seq");
	}
	
	public int insertConfRe(@RequestBody ConfReVO vo){
		System.out.println("insertConfRe");
		 return sqlFacotry.openSession().insert("ConfRoom.Insert_conf_re", vo);
	}
	
	
	
	public List<ConfRoomBookVO> selectConfList(){
		 return sqlFacotry.openSession().selectList("ConfRoom.Select_book");
	}
	
	
	public List<ConfRoomVO> selectRoomFloor(){
		System.out.println("DAO select Room Floor");
		 return sqlFacotry.openSession().selectList("ConfRoom.Select_room_floor");
	}
	
	public List<ConfRoomVO> selectConfRoom(@RequestBody ConfRoomVO vo){
		System.out.println("DAO select Room");
		 return sqlFacotry.openSession().selectList("ConfRoom.Select_conf_room", vo);
	}
	
	public List<EmpVO> selectEmp(){

		System.out.println("selectEmp");
		 return sqlFacotry.openSession().selectList("ConfRoom.Select_emp");
	}
	
	public int deleteConf(@RequestBody ConfRoomBookVO vo) {
		System.out.println("deleteConf");
		System.out.println("1");
		System.out.println(sqlFacotry.openSession().selectList("ConfRoom.Select_conf_find", vo));
		if(sqlFacotry.openSession().selectList("ConfRoom.Select_conf_find", vo).isEmpty()==false)
		{

			System.out.println("2");
			sqlFacotry.openSession().delete("ConfRoom.Delete_conf_re", vo.getCONF_INDEX());

			return sqlFacotry.openSession().delete("ConfRoom.Delete_conf", vo);
		}
		else {
			return 0;
		}
	}
	
	public List<ConfRoomBookVO> selectConfOne(@RequestBody ConfRoomBookVO vo){
		 return sqlFacotry.openSession().selectList("ConfRoom.Select_confOne",vo);
	}

	public List<ConfRoomBookVO> selectConOverlap(@RequestBody ConfRoomBookVO vo){
		 return sqlFacotry.openSession().selectList("ConfRoom.Select_confOverlap",vo);
	}
}
