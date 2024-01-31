package com.example.mapleinfo.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApiKey {
    @Value("${nexon-api-key}")
    private String apiKey;
}