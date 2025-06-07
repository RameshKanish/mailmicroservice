package com.example.MailService.service;


import com.example.MailService.dto.EmailRequestDto;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(EmailRequestDto emailRequestDto){
        SimpleMailMessage message = new SimpleMailMessage();


        System.out.println("To " + emailRequestDto.getTo());
//        System.out.println("Subject " + emailRequestDto.getSubject());
        message.setTo(emailRequestDto.getTo());
        message.setSubject("Hello");
        message.setText("Body Data");

//        System.out.println("Subject " + message.getSubject());

        javaMailSender.send(message);

    }
}
