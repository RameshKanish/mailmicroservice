package com.example.MailService;


import com.example.MailService.dto.EmailRequestDto;
import com.example.MailService.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaListener {

    @Autowired
    private EmailService emailService;

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "email-topic",
            groupId = "email-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeEmail(EmailRequestDto emailRequestDto){
        emailService.sendMail(emailRequestDto);
    }
}