package com.fareye.training.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.util.LinkedHashMap;
@Component
public class UserService {

    public String avatarUrl(String userName) throws MalformedURLException {
        String url = "https://api.github.com/users/" + userName;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity =restTemplate.getForEntity(url,Object.class);
        Object objects = responseEntity.getBody();
        LinkedHashMap<String,String> h = (LinkedHashMap<String, String>) objects;
        return h.get("avatar_url");
    }

}
