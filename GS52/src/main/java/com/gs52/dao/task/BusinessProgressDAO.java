package com.gs52.dao.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		 
		System.out.println("??");
     System.out.println(vo);
	System.out.println("??");
		 return sqlFacotry.openSession().selectList("task.selectListSend",vo);
		 
		 
	}
	public List<BusinessProgressVO> selectListSuccess(BusinessProgressVO vo){
		
		
		
		 return sqlFacotry.openSession().selectList("task.selectListSuccess",vo);
		 
		 
	}
	public int updateTodoDone(BusinessProgressVO vo) {
		// TODO Auto-generated method stub
		
		return sqlFacotry.openSession().update("task.updateTodoDone",vo);
	}
	public List<BusinessProgressVO> insertBoard(List list) {
		
		Map vo = new HashMap();
		vo.put("content",list.get(0));
		vo.put("startDate",list.get(1));
		vo.put("sendId",list.get(2));
		sqlFacotry.openSession().insert("task.insertBoard",vo);
		int TODO_INDEX = sqlFacotry.openSession().selectOne("task.selectStartDate",vo);
		vo.put("todoIndex",TODO_INDEX);
		for(int item : (List<Integer>)list.get(3)) {
			vo.put("receiveId",item);
			
			sqlFacotry.openSession().selectOne("task.insertReBoard",vo);
			
					
		}
           
		// TODO Auto-generated method stub
		return null;
	}
}
