package com.gs52.dao.main;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs52.vo.main.NoticeVO;

@Service  
@Transactional
public class NoticeDAO {
	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	
	public List<NoticeVO> selectListNotice(String NOTICE_INDEX){
		 return sqlFacotry.openSession().selectList("main.selectListNotice",NOTICE_INDEX);
	}

	public int insertNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().insert("main.insertNotice",vo);

	}

	public int deleteNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().delete("main.deleteNotice",vo);
	}

	public int updateNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return sqlFacotry.openSession().update("main.updateNotice",vo);
	}
}
