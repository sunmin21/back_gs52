package com.gs52.dao.manager;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.vo.emp.EmpVO;
import com.gs52.vo.manager.PositionVO;
import com.gs52.vo.manager.RankVO;
import com.gs52.vo.manager.RegistVO;
import com.gs52.vo.manager.TeamVO;

@Service  
@Transactional // 실패하면 다시 롤백하라
public class RegistDAO {

	@Autowired 
	private SqlSessionFactory sqlFacotry =null;
	
	public List<TeamVO> selectTeam(){

		System.out.println("selectTeam");
		 return sqlFacotry.openSession().selectList("regist.Select_Team");
	}
	public List<RankVO> selectRank(){

		System.out.println("selectRank");
		 return sqlFacotry.openSession().selectList("regist.Select_Rank");
	}
	public List<PositionVO> selectPosition(){

		System.out.println("SelectPosition");
		 return sqlFacotry.openSession().selectList("regist.Select_Position");
	}
	
	public List<EmpVO> selectEmp(){

		System.out.println("selectEmp");
		 return sqlFacotry.openSession().selectList("regist.Select_Emp");
	}
	
	
	
	

	public int insertRegist(@RequestBody RegistVO vo){
		System.out.println(vo);
		System.out.println("insertList");
		System.out.println(sqlFacotry.toString());
		System.out.println(sqlFacotry.openSession().toString());
		 return sqlFacotry.openSession().insert("regist.Insert_Regist", vo);
	}
	
	public RegistVO insertLogin(){

		System.out.println("Selec_Login");
		 return sqlFacotry.openSession().selectOne("regist.Selec_Login");
		 
		 
	}
}
