package com.gs52.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gs52.dao.manager.GmailDAO;
import com.gs52.vo.manager.GmailVO;

import lombok.AllArgsConstructor;


@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@AllArgsConstructor
public class GmailController {
    private final GmailDAO mailService;
//
//    @PostMapping("/mail")
//    public String dispMail() {
//        return "mail";
//    }

    @PostMapping("/mail")
    public String execMail(@RequestBody GmailVO mailDto) {
    	System.out.println("maillllllllllllllllllllllllllllllllllllllllllllllllll");
    	System.out.println(mailDto.getAddress());
    	System.out.println(mailDto.getTitle());
    	System.out.println(mailDto.getMessage());
        mailService.mailSend(mailDto);
        
        return "성공";
    }
}
