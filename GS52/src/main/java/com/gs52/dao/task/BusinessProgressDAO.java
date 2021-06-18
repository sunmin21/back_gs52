package com.gs52.dao.task;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gs52.vo.task.BusinessProgressVO;


@Service  
@Transactional
public class BusinessProgressDAO {

	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	
	public List<BusinessProgressVO> selectListTodo(BusinessProgressVO vo){
		
	
		  
		 return sqlFacotry.openSession().selectList("task.selectListTodo",vo);
		 
		 
	}
	public List<BusinessProgressVO> selectListSend(BusinessProgressVO vo){
		
		
		  
		 return sqlFacotry.openSession().selectList("task.selectListSend",vo);
		 
		 
	}
	public List<BusinessProgressVO> selectListSuccess(BusinessProgressVO vo){
		
		
		  
		 return sqlFacotry.openSession().selectList("task.selectListSuccess",vo);
		 
		 
	}
	public int updateTodoDone(BusinessProgressVO vo) {
		// TODO Auto-generated method stub
		System.out.println(vo);
		return sqlFacotry.openSession().update("task.updateTodoDone",vo);
	}
}
