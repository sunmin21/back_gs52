package com.gs52.controller.manager;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.attendance.AnnualManageDAO;
import com.gs52.dao.manager.VacationManageDAO;
import com.gs52.vo.attendance.AnnualManageVO;
import com.gs52.vo.manager.VacationManageVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/manager/vacation")
public class VacationManageController {
 	
	
	private final VacationManageDAO vDAO;
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	public VacationManageController(VacationManageDAO vDAO) {
		this.vDAO = vDAO;
		
	}
	
	
	@PostMapping("/select")
	public List<VacationManageVO> TestBoard(@RequestBody VacationManageVO vo) {
	System.out.println(vDAO.selectList());
	return vDAO.selectList();
	}

	@PostMapping("/update")
	public void updateBoard(@RequestBody VacationManageVO vo) {
		vDAO.updateVacation(vo);
	    System.out.println(vo.getVACATION_DATE());
	    System.out.println(vo);
		if(vo.getCOUNT()==1) {
			
			System.out.println("성공");
		vDAO.insertAttend(vo);
		}
		
	}
	
}
