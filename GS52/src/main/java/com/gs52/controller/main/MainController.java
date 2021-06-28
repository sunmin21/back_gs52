package com.gs52.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.TestDAO;
import com.gs52.dao.main.MainDAO;
import com.gs52.vo.TestVO;
import com.gs52.vo.main.NoticeVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/main")
public class MainController {
 
	@Autowired
	public MainDAO  mDAO = null;
	
	@GetMapping("/notice")
	public List<NoticeVO> TestBoard() {
	
		
		return mDAO.selectListNotice();
	}
}
