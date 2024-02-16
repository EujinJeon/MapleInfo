package com.example.mapleinfo.service;

import com.example.mapleinfo.entity.Equiment;
import com.example.mapleinfo.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class EquiService {

    private final ApiKey apiKey;
    private  final static String base_url = "https://open.api.nexon.com";

    public Equiment getUserEquiment(String userId, String date){
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-nxopen-api-key",apiKey.getApiKey());
        HttpEntity<Object> headerEntity = new HttpEntity<>(headers);
        URI uri = UriComponentsBuilder.fromUriString(base_url + "/maplestory/v1/character/item-equipment")
                .queryParam("ocid", userId)
                .queryParam("date", date)
                .build().encode().
                toUri();

        RestTemplate restTemplate =  new RestTemplate();
        ResponseEntity<Equiment> response =
                restTemplate.exchange(uri, HttpMethod.GET,
                        headerEntity,
                        Equiment.class);

        return response.getBody();
    }
}
