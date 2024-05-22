package com.message.messenger.controller;

import com.message.messenger.models.JsonModel;
import com.message.messenger.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> getTestData(@RequestBody JsonModel jsonModel) {
        return new ResponseEntity<>(emailService.sendEmail(jsonModel.getMessage()), HttpStatus.OK);
    }
}
