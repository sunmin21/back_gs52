package com.gs52.controller.auth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculVacation {
	
	public long CalculVacation(String entry_date) throws ParseException {

		//2021/07/01
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date entryDate = simpleDateFormat.parse(entry_date);
		Date nowDate = new Date();

		System.out.println("CalculVacation");

		System.out.println(entry_date);
		System.out.println(entryDate);
		System.out.println(nowDate);
		
        long diffDays = (nowDate.getTime() - entryDate.getTime()) / (24*60*60*1000); //일자수 차이

		System.out.println("################################");
		System.out.println(diffDays);
		long vac=0;
		
		if(diffDays<365) {
			//1년 미만
			vac = (diffDays/31);
			System.out.println("1년 미만");
			System.out.println(vac);
		}
		
		else if(diffDays<(365*3)) {
			//1년 이상
			vac = 15;
		}
		else {
			//3년 이상
			vac = (15 + ((diffDays-365)/365)/2);
		}
		return vac;
	}	
}
