package com.gs52.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs52.dao.main.TimeProgressDAO;
import com.gs52.vo.main.WorkTimeVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/main/TimeProgress")
public class TimeProgressController {

	@Autowired
	public TimeProgressDAO  tDAO = null;

	@PostMapping("/oneday_total")
	public List<WorkTimeVO> OnedayTotal(@RequestBody WorkTimeVO vo){
		System.out.println("OnedayTotal");
		System.out.println(vo);
		return tDAO.OnedayTotal(vo);
	}
	@PostMapping("/oneweek_total")
	public List<WorkTimeVO> WeekTotal(@RequestBody WorkTimeVO vo){
		System.out.println("WeekTotal");
		System.out.println( tDAO.WeekTotal(vo));
		
		return tDAO.WeekTotal(vo);
	}
	@PostMapping("/selectVacation")
	public List<WorkTimeVO> SelectVacation(@RequestBody WorkTimeVO vo) {
		System.out.println("SelectVacation");
		System.out.println(vo);
		System.out.println(tDAO.SelectVacation(vo));
		
		return tDAO.SelectVacation(vo);
	}
}
