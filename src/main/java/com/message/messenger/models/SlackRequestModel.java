package com.message.messenger.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.cglib.core.Block;

import java.util.ArrayList;
import java.util.List;

@Data
public class SlackRequestModel {

    String channel;
    List<Blocks> blocks;

    public SlackRequestModel() {
        this.blocks = new ArrayList<>();
    }

    @Data
    public static class Blocks {
        String type;
        Text text;

        public Blocks() {
            this.text = new Text();
        }
    }

    @Data
    public static class Text {
        String type;
        String text;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
