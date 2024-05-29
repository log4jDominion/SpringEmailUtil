package com.message.messenger.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.message.messenger.enums.SlackEnums;
import com.message.messenger.models.SlackRequestModel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class SlackService {

    @Value("${slack.app.base.url}")
    private String serverUrl;

    @Value("${slack.app.channel}")
    private String channel;

    @Value("${slack.app.oauth.token}")
    private String token;

    private RestTemplate template;
    private HttpHeaders headers;

    public String sendAppMessage(String object) {
        this.template = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Bearer " + token);
        HttpEntity<String> requestEntity = new HttpEntity<String>(createJsonString(object), headers);
        ResponseEntity<String> responseEntity = template.exchange(serverUrl, HttpMethod.POST, requestEntity, String.class);
        return responseEntity.getBody();
    }

    public String createJsonString(String object) {
        SlackRequestModel slackModel = new SlackRequestModel();
        slackModel.setChannel(channel);
        SlackRequestModel.Blocks block = new SlackRequestModel.Blocks();
        block.setType(SlackEnums.SECTION.label);
        block.getText().setType(SlackEnums.TEXT_MARKDOWN.label);
        block.getText().setText(object + SlackEnums.BREAK.label + "This is " + SlackEnums.BOLD.label + "Bold Text" + SlackEnums.BOLD.label + " " + SlackEnums.BREAK.label + " This is " + SlackEnums.ITALIC.label + "Italic Text" + SlackEnums.ITALIC.label + " " + SlackEnums.BREAK.label + " This is " + SlackEnums.CODE.label + "code" + SlackEnums.CODE.label + " " + SlackEnums.BREAK.label + " " + SlackEnums.CODE_SNIPPET.label + "This is a code block" + SlackEnums.BREAK.label + "And it's multi-line" + SlackEnums.CODE_SNIPPET.label + "");
        slackModel.getBlocks().add(block);
        return slackModel.toString();
    }

}
