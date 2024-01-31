package com.example.mapleinfo.service;

import com.example.mapleinfo.entity.User;
import com.example.mapleinfo.entity.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
public class InfoService {

    private final ApiKey apiKey;
    private  final static String base_url = "https://open.api.nexon.com";
    public String getUserId(String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-nxopen-api-key",apiKey.getApiKey());
        HttpEntity<Object> headerEntity = new HttpEntity<>(headers);
        URI uri = UriComponentsBuilder.fromUriString(base_url + "/maplestory/v1/id")
                .queryParam("character_name", username)
                .build().encode().
                toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserId> responseEntity =
                restTemplate.exchange(uri, HttpMethod.GET,
                        headerEntity,
                        UserId.class);
        return responseEntity.getBody().getOcid();
    }

    public User getUserInfo(String userId, String date){
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-nxopen-api-key",apiKey.getApiKey());
        HttpEntity<Object> headerEntity = new HttpEntity<>(headers);
        URI uri = UriComponentsBuilder.fromUriString(base_url + "/maplestory/v1/character/basic")
                .queryParam("ocid", userId)
                .queryParam("date", date)
                .build().encode().
                toUri();

        RestTemplate restTemplate =  new RestTemplate();
        ResponseEntity<User> response =
                restTemplate.exchange(uri, HttpMethod.GET,
                        headerEntity,
                        User.class);

        return response.getBody();
    }
}
