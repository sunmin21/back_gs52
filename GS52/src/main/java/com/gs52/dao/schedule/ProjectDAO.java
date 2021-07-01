package com.gs52.dao.schedule;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.manager.RegistVO;
import com.gs52.vo.schedual.ProjectVO;


@Service  
@Transactional // 실패하면 다시 롤백하라
public class ProjectDAO {

	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	

	public int insertProject(@RequestBody ProjectVO vo){
		System.out.println(vo);
		return 0;
//		 return sqlFacotry.openSession().insert("inform.Insert_Inform", vo);
	}
	
}