package com.message.messenger.controller;

import com.message.messenger.models.JsonModel;
import com.message.messenger.services.EmailService;
import com.message.messenger.services.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/slack")
public class SlackController {

    @Autowired
    private SlackService slackService;

    @PostMapping
    public ResponseEntity<String> getTestData(@RequestBody JsonModel jsonModel) {
        return new ResponseEntity<>(slackService.sendAppMessage(jsonModel.getMessage()), HttpStatus.OK);
    }
}
