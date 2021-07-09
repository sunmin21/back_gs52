package com.gs52.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.main.NoticeDAO;
import com.gs52.vo.emp.DeptVO;
import com.gs52.vo.main.NoticeVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/main")

public class NoticeController {
 
	@Autowired
	public NoticeDAO  mDAO = null;
	
	@GetMapping("/notice")
	public List<NoticeVO> TestBoard(@RequestParam(value="notice_INDEX" ,defaultValue = "", required = false) String notice_INDEX) {
            
         
		     
		
		return mDAO.selectListNotice(notice_INDEX);
		
		
	}
	
	@PostMapping("/addNotice")
	public int noticeInsert(@RequestBody NoticeVO vo) {
       
		     
		
		return mDAO.insertNotice(vo);
		
		
	}
	@PostMapping("/deleteNotice")
	public int noticeDelete(@RequestBody NoticeVO vo) {
       
		     
		
		return mDAO.deleteNotice(vo);
		
		
	}
	@PostMapping("/updateNotice")
	public int noticeUpdate(@RequestBody NoticeVO vo) {
       
		     
		
		return mDAO.updateNotice(vo);
		
		
	}
	
	

	
}
