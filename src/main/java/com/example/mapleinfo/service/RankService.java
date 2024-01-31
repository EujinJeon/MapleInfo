package com.example.mapleinfo.service;

import com.example.mapleinfo.entity.Rank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankService {

    private final ApiKey apiKey;
    private final static String base_url = "https://open.api.nexon.com";
    public List<Rank.RankLoad> rankList(String date, long world_type, long page){
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-nxopen-api-key",apiKey.getApiKey());
        HttpEntity<Object> headerEntity = new HttpEntity<>(headers);
        URI uri = UriComponentsBuilder.fromUriString(base_url + "/maplestory/v1/ranking/overall")
                .queryParam("date", date)
                .queryParam("world_type", world_type)
                .queryParam("page", page)
                .build().encode().
                toUri();

        RestTemplate restTemplate =  new RestTemplate();
        ResponseEntity<Rank> response =
                restTemplate.exchange(uri, HttpMethod.GET,
                        headerEntity,
                        Rank.class);

        return response.getBody().getRanking();
    }
}
