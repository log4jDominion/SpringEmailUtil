package com.message.messenger.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
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
        ResponseEntity<String> responseEntity = template.exchange(serverUrl, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    public String createJsonString(String object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("channel", channel);
        jsonObject.put("text", object);
        return jsonObject.toString();
    }

}
