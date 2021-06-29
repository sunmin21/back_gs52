package com.gs52.dao.member;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.manager.RegistVO;


@Service  
@Transactional // 실패하면 다시 롤백하라
public class InformDAO {

	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	
//	public List<RegistVO> selectList(){
//
//		System.out.println("selectList");
//		 return sqlFacotry.openSession().selectList("regist.Select_Dept");
//		 
//		 
//	}

	public int insertInform(@RequestBody RegistVO vo){
		System.out.println(vo);
		System.out.println("insertInform");
		System.out.println(sqlFacotry.toString());
		System.out.println(sqlFacotry.openSession().toString());
		 return sqlFacotry.openSession().insert("inform.Insert_Inform", vo);
	}
	
}