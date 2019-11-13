package com.example.demo.dto;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;


@Data
public class QueueDto {

    @Autowired
    private static ObjectMapper objectMapper;

    public QueueDto(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public static Map<String, String> getBodyObject(String body){
        return objectMapper.convertValue(body, new TypeReference<Map<String, String>>() {});
    }
}
