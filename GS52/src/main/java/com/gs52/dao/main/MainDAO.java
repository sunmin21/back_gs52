package com.gs52.dao.main;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.main.NoticeVO;

@Service  
@Transactional
public class MainDAO {
	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	
	public List<NoticeVO> selectListNotice(){
		 return sqlFacotry.openSession().selectList("main.selectListNotice");
	}
}
