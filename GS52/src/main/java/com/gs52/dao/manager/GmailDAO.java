package com.gs52.dao.manager;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gs52.vo.manager.GmailVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GmailDAO {
    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "GS52@gs52.com";

    public void mailSend(GmailVO mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        message.setFrom(GmailDAO.FROM_ADDRESS);
        
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());

        mailSender.send(message);
    }
}