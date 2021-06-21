package com.gs52.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.task.BusinessProgressDAO;
import com.gs52.vo.task.BusinessProgressVO;

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
