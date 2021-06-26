package com.gs52.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.member.InformDAO;
import com.gs52.vo.manager.RegistVO;


@RestController
@RequestMapping(value="/manager/informLayout")
public class InformController {
 
	@Autowired
	public InformDAO  mDAO = null;

	
	@PostMapping("/regist")
	public int insertInform(@RequestBody RegistVO vo) {
		System.out.println("insertInform"); 
		System.out.println(vo.getEMP_PWD());
		
		return mDAO.insertInform(vo);
	}

}
