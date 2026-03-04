package com.servidortpc.servidor_tpc.Infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component

public class SendHTTP {


    private final RestTemplate restTemplate;
    private final String backendUrl;

    public SendHTTP(RestTemplate restTemplate, @Value("${backend.base-url}") String backendUrl) {
        this.restTemplate = restTemplate;
        this.backendUrl = backendUrl; 
    }
    

    
}

