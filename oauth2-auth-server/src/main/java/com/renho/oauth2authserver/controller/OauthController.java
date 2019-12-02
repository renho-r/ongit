package com.renho.oauth2authserver.controller;

import com.renho.oauth2authserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Controller
public class OauthController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/login")
    public String login() {
        return "user/login";
    }

    @RequestMapping("/hasauth")
    @ResponseBody
    public String hasauth() {
        return "hasauth";
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String noauth() {
        return "noauth";
    }

    @RequestMapping("/auth/user")
    @ResponseBody
    public Object user(@RequestParam String username, @RequestParam String password) {

        String url = "http://localhost:8000/oauth/token";
        MultiValueMap<String, String> otpp= new LinkedMultiValueMap<String, String>();
        otpp.add("grant_type", "password");
        otpp.add("username", username);
        otpp.add("password", password);
        otpp.add("scope", "all");
        otpp.add("client_id", "r");
        otpp.add("client_secret", "rr");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(otpp, headers);
        ResponseEntity<Map> resp = restTemplate.postForEntity(url, request, Map.class);

        return resp;
    }
}
