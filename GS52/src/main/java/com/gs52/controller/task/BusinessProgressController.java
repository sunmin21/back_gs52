package com.gs52.controller.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.TestDAO;
import com.gs52.dao.task.BusinessProgressDAO;
import com.gs52.vo.task.BusinessProgressVO;

@RestController
@RequestMapping(value="/task")
public class BusinessProgressController {

	@Autowired
	public BusinessProgressDAO  bDAO = null;
	
	@PostMapping(value="/todo")
	public List<BusinessProgressVO> selectListTodo(@RequestBody BusinessProgressVO vo ) {
		
		System.out.println(vo);
		return bDAO.selectListTodo(vo);
	}
	
	@PostMapping(value="/todo/Done")
	public int selectListTodoDone(@RequestBody BusinessProgressVO vo ) {
		
		 System.out.println(vo);
		return bDAO.updateTodoDone(vo);
	}
	
	@PostMapping(value="/send")
	public List<BusinessProgressVO> selectListSend(@RequestBody BusinessProgressVO vo ) {
		
		System.out.println(vo);
		return bDAO.selectListSend(vo);
	}
	
	@PostMapping(value="/success")
	public List<BusinessProgressVO> selectListSuccess(@RequestBody BusinessProgressVO vo ) {
		
		
		return bDAO.selectListSuccess(vo);
	}
}
