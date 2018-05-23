package com.renho.esbtestservice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @auther: renho
 * @since: 1.0.0
 */
public class JsonUtil {

    public static <T> String toJson(T obj) {
        ObjectMapper mapper = new ObjectMapper();
        String backJson = "";
        try {
            backJson = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return backJson;
    }

}
