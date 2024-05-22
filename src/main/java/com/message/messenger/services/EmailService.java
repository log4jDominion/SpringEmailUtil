package com.message.messenger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public String sendEmail(String object) {

        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("bhardwajshashank1506@gmail.com");
            message.setTo("sbhardw7@umd.edu");
            message.setSubject("Json Object");
            message.setText(object);
            emailSender.send(message);

            return "Mail sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Mail sent failed";
        }
    }
}
