package com.gs52.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.task.BusinessProgressDAO;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	public BusinessProgressDAO  bDAO = null;
	
//	@GetMapping(value="/listAll")
//	public List<BusinessProgressVO> selectListTodo() {
//		
////		return bDAO.selectListTodo(vo);
//	}
	
	
}
